function initKlostIS() {
    var allDay = 'true' === $('#eventId').attr('data-allDay') ? true : false;
    eventViewModel = new EventViewModel(allDay);
    ko.applyBindings(eventViewModel);
}

function Event(allDay) {
    this.allDay = ko.observable(allDay);
}

function EventViewModel(allDay) {
    this.event = ko.observable(new Event(allDay));
}






