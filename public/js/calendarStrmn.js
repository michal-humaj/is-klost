function initKlostIS() {

    initCalendarVariables();

    $('html').on('click', function () {
        removePopovers();
    });

    eventViewModel = new EventViewModel();

    var datepicker = createDatepicker();
    var fullcalendar = $('#fullcalendar');
    fullcalendarArgs.eventClick = eventClick;
    fullcalendarArgs.viewRender = function (view, element) {
        datepicker.datepicker('setDate', view.intervalStart.format());
    };
    fullcalendar.fullCalendar(fullcalendarArgs);
    setFullcalendarHeight();
    addEvent(window, "resize", setFullcalendarHeight);
    datepicker.datepicker('option', 'onSelect', function (date) {
        fullcalendar.fullCalendar('gotoDate', date);
    });

    var urlDate = fullcalendar.attr('data-date');
    datepicker.datepicker('setDate', urlDate);
    fullcalendar.fullCalendar('gotoDate', urlDate);

}

function eventClick(event, jsEvent, view) {
    removePopovers();
    var eventType = calTypes[event.source.googleCalendarId];
    if (eventType === 'INSTALLATION') return false;
    eventViewModel.event(new Event(event.id, eventType, event.title));
    $(jsEvent.target).popover({
        animation: false,
        container: '#fullcalendar',
        title: event.title.split(' →')[0],
        trigger: 'manual',
        placement: 'auto',
        html: true,
        content: $("#popoverStrmn").html()
    });
    $(jsEvent.target).popover('show');
    doNotDismissOnPopoverClick();
    ko.applyBindings(eventViewModel, $('.popover')[0]);
    return false;
}