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
                if (eventViewModel.itemIdMap()[val] === undefined) return false;
                return true;
            },
            message: Messages('err.itemFromList')
        },
        required: true
    });

    this.isCarpet = ko.computed(function () {
        var cat = eventViewModel.itemIdMap().categories[this.itemName()];
        if (cat === undefined){
            return true;
        }
        return cat === 'CARPET';
    }, this);

    this.amountMinAndStep = ko.computed(function () {
        var cat = eventViewModel.itemIdMap().categories[this.itemName()];
        return cat === 'CARPET' ? '0.01' : '1';
    }, this);
}

function ItemIdMap(items) {
    if (items === undefined) return;
    this.categories = {};
    var key;
    for (var i = 0; i < items.length; i++) {
        key = items[i].name;
        this[key] = items[i].id;
        this.categories[key] = items[i].category;
    }
}

function EventViewModel(allDay) {
    this.event = ko.observable(new Event(allDay));
    this.entries = ko.observableArray([]);
    this.items = [];
    this.itemIdMap = ko.observable(new ItemIdMap());

    this.carpetEntries = ko.computed(function() {
        return ko.utils.arrayFilter(this.entries(), function(entry) {
            return entry.isCarpet();
        });
    }, this);

    this.nonCarpetEntries = ko.computed(function () {
        return ko.utils.arrayFilter(this.entries(), function(entry) {
            return !entry.isCarpet();
        });
    }, this);

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