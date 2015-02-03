//runs when page is loaded -> bound to jQuery document ready function
function initKlostIS() {

    setAvailTableHeightStoreman();
    addEvent(window, "resize", setAvailTableHeightStoreman);
    setScrollspyOffset(140);
}

function Item(category, name, amount, weight) {
    this.category = ko.observable(category).extend({required: true});
    this.name = ko.observable(name).extend({required: true, minLength: 3});
    this.amount = ko.observable(amount).extend({required: true, number:true, min: 1, step: 1});
    this.weight = ko.observable(amount).extend({required: true, number:true, min: 0, step: 0.01});
};

function StoreViewModel() {
    this.newItem = ko.validatedObservable(new Item());
    this.items = ko.observableArray();
    this.addItem = function () {
        console.log(this.newItem.isValid());
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