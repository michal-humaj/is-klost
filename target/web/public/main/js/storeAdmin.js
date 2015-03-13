var spinnerOptions = {
    lines: 13,
    length: 20,
    width: 10,
    radius: 30,
    corners: 1,
    rotate: 0,
    direction: 1,
    color: '#555',
    speed: 1,
    trail: 60,
    shadow: false,
    hwaccel: false,
    className: 'spinner',
    zIndex: 2e9,
    top: '50%',
    left: '36%'
};
var spinnerOptions2 = JSON.parse(JSON.stringify(spinnerOptions));
spinnerOptions2.color = '#2e8965';

var storeViewModel = new StoreViewModel();
ko.validation.init({insertMessages: false}, true);
ko.validation.locale('sk-SK');
ko.applyBindings(storeViewModel);
var spinner = new Spinner(spinnerOptions);
var spinner2 = new Spinner(spinnerOptions2);

function initKlostIS() {

    widgetEvents = $('#widgetEvents');
    widgetItems = $('#widgetItems');
    var datepicker = createDatepicker();
    var urlDate = widgetEvents.attr('data-date');
    datepicker.datepicker('setDate', urlDate);
    storeViewModel.dateSelected(moment(urlDate));
    setAvailTableHeightAdmin();
    addEvent(window, "resize", setAvailTableHeightAdmin);
    setAvailTableHeightOnCollapseEventsWidget();
    setScrollspyOffset(140);
    loadEventsAndAvailForSelectedDay();
    onModalsHideBlurBtnAndOnModalShownFocusEditBoxAndOnCategorySelectChangeValidationBindings()
    datepicker.datepicker('option', 'onSelect', function (date) {
        storeViewModel.dateSelected(moment(date));
        loadEventsAndAvailForSelectedDay();
    });
}

function Item(category, name, amount, weight, isCarpet, available, rented, reserved) {
    this.id = null;
    this.category = ko.observable(category).extend({required: true});
    this.name = ko.observable(name).extend({required: true, minLength: 3});
    var restrictsAmount;
    if (isCarpet) {
        restrictsAmount = {required: true, number: true, min: 0.01, step: 0.01};
    } else {
        restrictsAmount = {required: true, number: true, min: 1, step: 1};
    }
    this.amount = ko.observable(amount).extend(restrictsAmount);
    this.weight = ko.observable(weight).extend({required: true, number: true, min: 0, step: 0.01});
    this.reserved = ko.observable(reserved);
    this.available = ko.observable(available);
    this.rented = ko.observable(rented);
}

function Event(eventType, id, name, start, end) {
    this.eventType = eventType;
    this.id = id;
    this.name = name;
    this.startTime = start;
    this.endTime = end;
    this.calcAvail = ko.observable(true);
}


function loadEventsAndAvailForSelectedDay() {
    startSpinWidgetEvents();
    startSpinWidgetItems();

    var requestEvents = jsRoutes.controllers.Avail.getEventsAt(storeViewModel.dateSelected().format().split('T')[0]).ajax();
    requestEvents.done(function (eventsContainer) {
        var atDateEvents = eventsContainer.actions.map(function (e) {
            if (e.allDay) {
                return new Event(e.eventType, e.id, e.name, '', '');
            } else {
                var eventStart = moment(e.start).startOf('day');
                eventStart = storeViewModel.dateSelected().isSame(eventStart) ? e.startTime.substring(0, 5) : '';
                var eventEnd = moment(e.end).startOf('day');
                eventEnd = storeViewModel.dateSelected().isSame(eventEnd) ? e.endTime.substring(0, 5) : '';
                return new Event(e.eventType, e.id, e.name, eventStart, eventEnd);
            }
        });
        var tilDateEvents = eventsContainer.tilDateActions.map(function (e) {
            return new Event(e.eventType, e.id, e.name, '', '');
        });
        storeViewModel.events(atDateEvents);
        storeViewModel.tilDateEvents(tilDateEvents);
        stopSpinWidgetEvents();
    });
    requestEvents.fail(function (jqXHR, textStatus) {
        showErrorNotification(Messages('err.general'));
        stopSpinWidgetEvents();
    });


}

function StoreViewModel() {
    var modalNewItem = $('#modalNewItem');
    var modalEditItem = $('#modalEditItem');
    var modalImportItem = $('#modalImportItem');
    var modalExportItem = $('#modalExportItem');
    var modalDeleteItem = $('#modalDeleteItem');

    this.item = ko.validatedObservable(new Item());
    this.items = ko.observableArray();
    this.importAmount = ko.validatedObservable(new Amount());
    this.dateSelected = ko.observable();
    this.events = ko.observableArray([]);
    this.tilDateEvents = ko.observableArray([]);

    this.headingWidgetEvents = ko.computed(function () {
        if (this.dateSelected() === undefined) return '';
        return this.dateSelected().format('dddd DoM. YYYY');
    }, this);

    this.availability = ko.computed(function () {
        var data = {};
        var arrayLength = this.events().length;
        var omitted = 0;
        for (var i = 0; i < arrayLength; i++) {
            if (!this.events()[i].calcAvail()) {
                omitted++;
                continue;
            }
            data['actions[' + (i - omitted) + '].id'] = this.events()[i].id;
            data['actions[' + (i - omitted) + '].eventType'] = this.events()[i].eventType;
        }
        arrayLength = this.tilDateEvents().length;
        for (var i = 0; i < arrayLength; i++) {
            data['tilDateActions[' + i + '].id'] = this.tilDateEvents()[i].id;
            data['tilDateActions[' + i + '].eventType'] = this.tilDateEvents()[i].eventType;
        }
        var requestAvailability = jsRoutes.controllers.Avail.availability().ajax({data: data});
        try {
            startSpinWidgetItems();
        } catch (err) {
            console.log(err);
        }
        requestAvailability.done(function (availTos) {
            storeViewModel.items(availTos);
            initTooltips();
            stopSpinWidgetItems();
            setAvailTableHeightAdmin();
        });
        requestAvailability.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.general'));
            stopSpinWidgetItems();
        });

        this.events().map(function (e) { //tricky code to force knockout update
            e.calcAvail();
        });
        return '';
    }, this);

    this.modalAdd = function () {
        this.item(new Item());
    }

    this.add = function () {
        if (!this.item.isValid()) return;
        var requestAddItem = jsRoutes.controllers.Items.add().ajax({data: this.item()});
        modalNewItem.modal('hide');
        requestAddItem.done(function (newId) {
            showSuccessNotification(Messages('f.addItem', storeViewModel.item().name()));
            var it = storeViewModel.item();
            var insertItem = {id: newId, category: it.category(), name: it.name(), amount: +it.amount(), weight: +it.weight(), available: +it.amount(), reserved: 0, rented: 0};
            var i = 0;
            while (storeViewModel.items()[i].category !== it.category()) i++;
            while (storeViewModel.items()[i].category == it.category()) i++;
            storeViewModel.items.splice(i, 0, insertItem);
            initTooltips();
        });
        requestAddItem.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.general'));
        });
    }

    this.edit = function (item) {
        var editedItem = new Item(item.category, item.name, item.amount, item.weight, item.category === 'CARPET', item.available, item. rented, item.reserved);
        editedItem.id = item.id;
        storeViewModel.item(editedItem);
        storeViewModel.importAmount(new Amount(item.category === 'CARPET'));
    }

    this.update = function () {
        if (!this.item.isValid()) return;
        var requestUpdateItem = jsRoutes.controllers.Items.update(this.item().id).ajax({data: this.item()});
        modalEditItem.modal('hide');
        requestUpdateItem.done(function (items) {
            showSuccessNotification(Messages('f.updateItem', storeViewModel.item().name()));
            var it = storeViewModel.item();
            console.log(it.available());
            var updateItem = {id: it.id, category: it.category(), name: it.name(), amount: +it.amount(), weight: +it.weight(), available: +it.amount() - it.reserved() - it.rented(), reserved: +it.reserved(), rented: +it.rented()};
            console.log(updateItem);
            var i = 0;
            while (storeViewModel.items()[i].id !== it.id) i++;
            storeViewModel.items.splice(i, 1, updateItem);
            initTooltips();
        });
        requestUpdateItem.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.general'));
        });
    }

    this.imprt = function () {
        if (!this.importAmount.isValid()) return;
        var formerAmount = this.item().amount();
        var newAmount = formerAmount + parseFloat(this.importAmount().value());
        this.item().amount(newAmount);
        var requestImportItem = jsRoutes.controllers.Items.update(this.item().id).ajax({data: this.item()});
        modalImportItem.modal('hide');
        requestImportItem.done(function (items) {
            showSuccessNotification(Messages('f.importItem', storeViewModel.item().name(), formerAmount, newAmount));
            var it = storeViewModel.item();
            console.log(it.available());
            var updateItem = {id: it.id, category: it.category(), name: it.name(), amount: +it.amount(), weight: +it.weight(), available: +it.amount() - it.reserved() - it.rented(), reserved: +it.reserved(), rented: +it.rented()};
            console.log(updateItem);
            var i = 0;
            while (storeViewModel.items()[i].id !== it.id) i++;
            storeViewModel.items.splice(i, 1, updateItem);
            initTooltips();
        });
        requestImportItem.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.general'));
        });
    }

    this.exprt = function () {
        if (!this.importAmount.isValid()) return;
        var formerAmount = this.item().amount();
        var newAmount = formerAmount - parseFloat(this.importAmount().value());
        this.item().amount(newAmount);
        var requestExportItem = jsRoutes.controllers.Items.update(this.item().id).ajax({data: this.item()});
        modalExportItem.modal('hide');
        requestExportItem.done(function (items) {
            showSuccessNotification(Messages('f.exportItem', storeViewModel.item().name(), formerAmount, Math.round(newAmount * 100) / 100));
            var it = storeViewModel.item();
            console.log(it.available());
            var updateItem = {id: it.id, category: it.category(), name: it.name(), amount: +it.amount(), weight: +it.weight(), available: +it.amount() - it.reserved() - it.rented(), reserved: +it.reserved(), rented: +it.rented()};
            console.log(updateItem);
            var i = 0;
            while (storeViewModel.items()[i].id !== it.id) i++;
            storeViewModel.items.splice(i, 1, updateItem);
            initTooltips();
        });
        requestExportItem.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.general'));
        });
    }

    this.delet = function () {
        var requestDeleteItem = jsRoutes.controllers.Items.delete(this.item().id).ajax();
        modalDeleteItem.modal('hide');
        requestDeleteItem.done(function (items) {
            showSuccessNotification(Messages('f.deleteItem', storeViewModel.item().name()));
            var it = storeViewModel.item();
            var i = 0;
            while (storeViewModel.items()[i].id !== it.id) i++;
            storeViewModel.items.splice(i, 1);
            initTooltips();
        });
        requestDeleteItem.fail(function (jqXHR, textStatus) {
            showErrorNotification(jqXHR.responseText);
        });
    }
}

function startSpinWidgetEvents() {
    spinner.spin(widgetEvents[0]);
    $("#widgetEvents :input").attr("disabled", true);
}

function stopSpinWidgetEvents() {
    spinner.stop();
    $("#widgetEvents :input").attr("disabled", false);
}

function startSpinWidgetItems() {
    spinner2.spin(widgetItems[0]);
    $("#widgetItems :input").attr("disabled", true);
}

function stopSpinWidgetItems() {
    spinner2.stop();
    $("#widgetItems :input").attr("disabled", false);
}