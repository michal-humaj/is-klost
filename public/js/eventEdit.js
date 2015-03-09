function initKlostIS() {

    var allDay = 'true' === $('#eventId').attr('data-allDay') ? true : false;
    eventViewModel = new EventViewModel(allDay);
    ko.applyBindings(eventViewModel);
    checkErrorsOnFormSubmit();

    var requestItemList = jsRoutes.controllers.Items.listEventItems().ajax();

    requestItemList.done(function (items) {
        eventViewModel.items = items.map(function (item) {
            return item.name;
        });
        eventViewModel.itemIdMap(new ItemIdMap(items));


        $(".autocomplete").each(function () {
            $(this).autocomplete({
                source: autocompleteSource
            });
        });
      
    });

    requestItemList.fail(function (jqXHR, textStatus) {
        showErrorNotification(Messages('err.general'));
    });
}

function Event(allDay) {
    this.allDay = ko.observable(allDay);
}

function Entry(index) {
    this.fieldItem = ko.observable('entries[' + index + '].item.id');
    this.fieldAmount = ko.observable('entries[' + index + '].amount');
    this.amount = ko.observable();
    this.itemName = ko.observable().extend({
        validation: {
            validator: function (val) {
                if (eventViewModel.items.indexOf(val) === -1) return false;
                return true;
            },
            message: Messages('err.itemFromList')
        },
        required: true
    });
}

function ItemIdMap(items) {
    if (items === undefined) return;
    var key;
    for (var i = 0; i < items.length; i++) {
        key = items[i].name;
        this[key] = items[i].id;
    }
}

function EventViewModel(allDay) {
    this.event = ko.observable(new Event(allDay));
    this.entries = ko.observableArray([]);
    this.items = [];
    this.itemIdMap = ko.observable(new ItemIdMap());

    this.addEntry = function () {
        this.entries.push(new Entry(this.entries().length));
        $(".autocomplete").each(function () {
            $(this).autocomplete({
                source: autocompleteSource
            });
        });
    }

    this.removeEntry = function (removedEntry) {
        eventViewModel.entries.remove(removedEntry);
        var i = 0;
        eventViewModel.entries().map(function (entry) {
            entry.fieldItem('entries[' + i + '].item.id');
            entry.fieldAmount('entries[' + i + '].amount');
            i++;
        });
    }
}

function checkErrorsOnFormSubmit() {
    $("#form").on('submit', function () {
        var errors = ko.validation.group(eventViewModel.entries(), {deep: true});
        console.log(errors());
        if (errors().length === 0) return true;
        return false;
    });
}

function autocompleteSource(request, response) {
    var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
    response($.grep(eventViewModel.items, function (value) {
        value = value.label || value.value || value;
        return matcher.test(value) || matcher.test(normalize(value));
    }));
}





