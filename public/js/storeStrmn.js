//runs when page is loaded -> bound to jQuery document ready function
function initKlostIS() {

    setAvailTableHeightStoreman();
    addEvent(window, "resize", setAvailTableHeightStoreman);
    setScrollspyOffset(140);

    var modalNewItem = $('#modalNewItem');
    modalNewItem.on('shown.bs.modal', function () {
        $('#newItemCategorySelect').focus();
    });
    modalNewItem.on('hidden.bs.modal', function () {
        setTimeout(function () {
            $("#btnModalNewItem").blur();
        }, 1);
    });
    $('#newItemCategorySelect').on('change', function() {
        var name = storeViewModel.newItem().name();
        var amount = storeViewModel.newItem().amount();
        var weight = storeViewModel.newItem().weight();
        if (this.value === 'CARPET'){
            console.log("CARPET zmena");
            storeViewModel.newItem(new Item(this.value, name, amount, weight, true));
        }else{
            console.log("nie CARPET zmena");
            storeViewModel.newItem(new Item(this.value, name, amount, weight, false));
        }
    });
}

function Item(category, name, amount, weight, isCarpet) {
    this.category = ko.observable(category).extend({required: true});
    this.name = ko.observable(name).extend({required: true, minLength: 3});
    var restrictions;
    if (isCarpet) {
        restrictions = {required: true, number: true, min: 0.01, step: 0.01};
    } else {
        restrictions = {required: true, number: true, min: 1, step: 1};
    }
    this.amount = ko.observable(amount).extend(restrictions);
    this.weight = ko.observable(weight).extend({required: true, number: true, min: 0, step: 0.01});
}

function StoreViewModel() {
    var modalNewItem = $('#modalNewItem');

    this.newItem = ko.validatedObservable(new Item());
    this.items = ko.observableArray();

    this.addItem = function () {
        if (!this.newItem.isValid()) return;
        var requestAddItem = jsRoutes.controllers.Items.add().ajax({data: this.newItem()});
        requestAddItem.done(function (msg) {
            showSuccessNotification(msg);
        });
        requestAddItem.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.general'));
        });
        modalNewItem.modal('hide');
        this.newItem(new Item());
    }
}

var storeViewModel = new StoreViewModel();
ko.validation.init({insertMessages: false}, true);
ko.validation.locale('sk-SK');
ko.applyBindings(storeViewModel);

jsRoutes.controllers.Items.list().ajax({
    success: function (items) {
        storeViewModel.items(items);
        initTooltips();
    }
});