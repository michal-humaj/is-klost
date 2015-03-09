function Accessory(index) {
    this.fieldItem = ko.observable('accessories[' + index + '].item.id');
    this.fieldAmount = ko.observable('accessories[' + index + '].amount');
    this.amount = ko.observable();
    this.itemName = ko.observable().extend({
        validation: {
            validator: function (val) {
                if (tentViewModel.items.indexOf(val) === -1) return false;
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

function TentViewModel() {
    this.name = ko.observable();
    this.accessories = ko.observableArray([]);
    this.items = [];
    this.itemIdMap = ko.observable(new ItemIdMap());

    this.addAccessory = function () {
        this.accessories.push(new Accessory(this.accessories().length));
        $(".autocomplete").each(function () {
            $(this).autocomplete({
                source: autocompleteSource
            });
        });
    }

    this.removeAccessory = function (removedAcc) {
        tentViewModel.accessories.remove(removedAcc);
        var i = 0;
        tentViewModel.accessories().map(function (acc) {
            acc.fieldItem('accessories[' + i + '].item.id');
            acc.fieldAmount('accessories[' + i + '].amount');
            i++;
        });
    }
}

function checkErrorsOnFormSubmit(){
    $("#form").on('submit', function () {
        var errors = ko.validation.group(tentViewModel.accessories(), {deep: true});
        console.log(errors());
        if (errors().length === 0) return true;
        return false;
    });
}

function autocompleteSource(request, response) {
    var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
    response($.grep(tentViewModel.items, function (value) {
        value = value.label || value.value || value;
        return matcher.test(value) || matcher.test(normalize(value));
    }));
}




