function initKlostIS() {

    jsRoutes.controllers.Items.listTentItems().ajax().done(function (items) {

        tentViewModel.items = items.map(function (item) {
            return item.name;
        });
        tentViewModel.itemIdMap(new ItemIdMap(items));

        $(".autocomplete").autocomplete({
            source: autocompleteSource
        });
    });

    $("#form").on('submit', function () {
        var errors = ko.validation.group(tentViewModel.accessories(), {deep: true});
        if (errors().length === 0) return true;
        return false;
    });
}

function Accessory(index) {
    this.fieldItem = ko.observable('accessories[' + index + '].item.id');
    this.fieldAmount = ko.observable('accessories[' + index + '].amount');
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

var tentViewModel = new TentViewModel();
tentViewModel.accessories([new Accessory(0)]);
ko.applyBindings(tentViewModel);


var normalize = function (term) {
    var ret = "";
    for (var i = 0; i < term.length; i++) {
        ret += accentMap[term.charAt(i)] || term.charAt(i);
    }
    return ret;
};

var accentMap = {
    "á": "a",
    "ä": "a",
    "č": "c",
    "ď": "d",
    "é": "e",
    "í": "i",
    "ľ": "l",
    "ň": "n",
    "ó": "o",
    "ô": "o",
    "ŕ": "r",
    "š": "s",
    "ť": "t",
    "ú": "u",
    "ý": "y",
    "ž": "z"
};

function autocompleteSource(request, response) {
    var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
    response($.grep(tentViewModel.items, function (value) {
        value = value.label || value.value || value;
        return matcher.test(value) || matcher.test(normalize(value));
    }));
}



