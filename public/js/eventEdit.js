function initKlostIS() {


    var eventViewModel = new EventViewModel();
    ko.applyBindings(eventViewModel);
}

function Event() {
    if ('true' === $('#eventId').attr('data-allDay')) {
        this.allDay = ko.observable(true);
    } else {
        this.allDay = ko.observable(false);
    }
}

function EventViewModel() {
    this.event = ko.observable(new Event());

    this.jozo = function () {
        console.log(this.event().allDay());
    }
}

