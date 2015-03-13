function initKlostIS() {

    var event = $('#eventId');
    var allDay = 'true' === event.attr('data-allDay') ? true : false;
    var eventType = event.attr('data-eventType');
    var eventId = event.attr('data-eventId');
    eventViewModel = new EventViewModel(allDay);
    ko.applyBindings(eventViewModel);
    checkErrorsOnFormSubmit();

    var requestItemList = jsRoutes.controllers.Items.listEventItems().ajax();
    requestItemList.done(function (items) {
        items.map(function (item) {
            if(item.category === 'CARPET') {
                eventViewModel.items.push(item.name);
            }
        });
        eventViewModel.itemIdMap(new ItemIdMap(items));

        var requestEventEntries = jsRoutes.controllers.Events.getEntries(eventType, eventId).ajax();
        requestEventEntries.done(function (entries) {
            var i = 0;
            var entries = entries.map(function(ent){
                var entry = new Entry(i);
                i++;
                entry.itemName(ent.item.name);
                entry.amount(ent.amount);
                return entry;
            });
            if (entries.length === 0){
                entries = [new Entry(0)];
            }
            eventViewModel.entries(entries);

            $(".autocomplete").each(function () {
                $(this).autocomplete({
                    source: autocompleteSource
                });
            });
        });

        requestEventEntries.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.noEventEntries'));
        });
    });

    requestItemList.fail(function (jqXHR, textStatus) {
        showErrorNotification(Messages('err.general'));
    });
}