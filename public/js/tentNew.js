function initKlostIS() {

    var requestItemList = jsRoutes.controllers.Items.listTentItems().ajax();

    requestItemList.done(function (items) {
        tentViewModel.items = items.map(function (item) {
            return item.name;
        });
        tentViewModel.itemIdMap(new ItemIdMap(items));
        $(".autocomplete").autocomplete({
            source: autocompleteSource
        });
    });
    requestItemList.fail(function (jqXHR, textStatus) {
        showErrorNotification(Messages('err.general'));
    });

    checkErrorsOnFormSubmit();
}

var tentViewModel = new TentViewModel();
tentViewModel.accessories([new Accessory(0)]);
ko.applyBindings(tentViewModel);