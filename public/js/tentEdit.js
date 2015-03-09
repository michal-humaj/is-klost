//runs when page is loaded -> bound to jQuery document ready function
function initKlostIS() {

    var tentId = $("#tentId").attr('data-tentId');
    var requestItemList = jsRoutes.controllers.Items.listTentItems().ajax();

    requestItemList.done(function (items) {
        tentViewModel.items = items.map(function (item) {
            return item.name;
        });
        tentViewModel.itemIdMap(new ItemIdMap(items));

        var requestTent = jsRoutes.controllers.Tents.getTent(tentId).ajax();

        requestTent.done(function (tent) {
            tentViewModel.name(tent.name);
            var i = 0;
            var accessories = tent.accessories.map(function(acc){
                var accessory = new Accessory(i);
                i++;
                accessory.itemName(acc.item.name);
                accessory.amount(acc.amount);
                return accessory;
            });
            tentViewModel.accessories(accessories);

            $(".autocomplete").each(function () {
                $(this).autocomplete({
                    source: autocompleteSource
                });
            });
        });

        requestTent.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.tentNotFound', tentId));
        });
    });

    requestItemList.fail(function (jqXHR, textStatus) {
        showErrorNotification(Messages('err.general'));
    });

    checkErrorsOnFormSubmit();
}

var tentViewModel = new TentViewModel();
ko.applyBindings(tentViewModel);