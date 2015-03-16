function changeItemValidationBindings() {
    var id = storeViewModel.item().id;
    var name = storeViewModel.item().name();
    var amount = storeViewModel.item().amount();
    var weight = storeViewModel.item().weight();
    if (this.value === 'CARPET') {
        storeViewModel.item(new Item(this.value, name, amount, weight, true));
    } else {
        storeViewModel.item(new Item(this.value, name, amount, weight, false));
    }
    storeViewModel.item().id = id;
}

function Amount(isCarpet) {
    var restrictsAmount;
    if (isCarpet) {
        restrictsAmount = {required: true, number: true, min: 0.01, step: 0.01};
    } else {
        restrictsAmount = {required: true, number: true, min: 1, step: 1};
    }
    this.value = ko.observable().extend(restrictsAmount);
}

function onModalsHideBlurBtnAndOnModalShownFocusEditBoxAndOnCategorySelectChangeValidationBindings() {
    var selectCategoryEditItem = $("#selectCategoryEditItem");
    var selectCategoryNewItem = $("#selectCategoryNewItem");
    var modalNewItem = $('#modalNewItem');
    var modalEditItem = $('#modalEditItem');
    var modalImportItem = $('#modalImportItem');
    var modalExportItem = $('#modalExportItem');

    modalNewItem.on('shown.bs.modal', function () {
        selectCategoryNewItem.focus();
    });
    modalNewItem.on('hidden.bs.modal', function () {
        setTimeout(function () {
            $("#btnModalNewItem").blur();
        }, 1);
    });
    modalEditItem.on('shown.bs.modal', function () {
        selectCategoryEditItem.focus();
    });
    modalEditItem.on('hidden.bs.modal', function () {
        setTimeout(function () {
            $(".linkEditItem").each(function () {
                this.blur();
            });
        }, 1);
    });
    modalImportItem.on('hidden.bs.modal', function () {
        setTimeout(function () {
            $(".linkImportItem").each(function () {
                this.blur();
            });
        }, 1);
    });
    modalImportItem.on('shown.bs.modal', function () {
        $("#inputImportAmount").focus();
    });
    modalExportItem.on('hidden.bs.modal', function () {
        setTimeout(function () {
            $(".linkExportItem").each(function () {
                this.blur();
            });
        }, 1);
    });
    modalExportItem.on('shown.bs.modal', function () {
        $("#inputExportAmount").focus();
    });
    $("#modalDeleteItem").on('hidden.bs.modal', function () {
        setTimeout(function () {
            $(".linkDeleteItem").each(function () {
                this.blur();
            });
        }, 1);
    });
    selectCategoryEditItem.on('change', changeItemValidationBindings);
    selectCategoryNewItem.on('change', changeItemValidationBindings);
}
