var storeViewModel = new StoreViewModel();
ko.validation.init({insertMessages: false}, true);
ko.validation.locale('sk-SK');
ko.applyBindings(storeViewModel);

//runs when page is loaded -> bound to jQuery document ready function
function initKlostIS() {

    setAvailTableHeightStoreman();
    addEvent(window, "resize", setAvailTableHeightStoreman);
    setScrollspyOffset(140);

    jsRoutes.controllers.Items.list().ajax().done(function (items) {
        storeViewModel.items(items);
        initTooltips();
    });

    onModalsHideBlurBtnAndOnModalShownFocusEditBoxAndOnCategorySelectChangeValidationBindings();
}

function Item(category, name, amount, weight, isCarpet) {
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

    this.modalAdd = function () {
        this.item(new Item());
    }

    this.add = function () {
        if (!this.item.isValid()) return;
        var requestAddItem = jsRoutes.controllers.Items.add().ajax({data: this.item()});
        modalNewItem.modal('hide');
        requestAddItem.done(function (items) {
            showSuccessNotification(Messages('f.addItem', storeViewModel.item().name()));
            storeViewModel.items(items);
            initTooltips();
        });
        requestAddItem.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.general'));
        });
    }

    this.edit = function (item) {
        var editedItem = new Item(item.category, item.name, item.amount, item.weight, item.category === 'CARPET');
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
            storeViewModel.items(items);
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
            storeViewModel.items(items);
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
            storeViewModel.items(items);
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
            storeViewModel.items(items);
            initTooltips();
        });
        requestDeleteItem.fail(function (jqXHR, textStatus) {
            showErrorNotification(jqXHR.responseText);
        });
    }
}



