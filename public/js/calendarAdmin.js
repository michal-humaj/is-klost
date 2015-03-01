function initKlostIS() {

    $('html').on('click', function () {
        removePopovers();
    });

    var datepicker = createDatepicker();
    var fullcalendar = $('#fullcalendar');

    var ACTIONS_COLOR = "#7BD148";
    var INSTALLATIONS_COLOR = "#F83A22";
    var RESERVATIONS_COLOR = "#F691B2";
    var SELFTRANSPORTS_COLOR = "#FAD165";
    var ACTIONS_BORDER_COLOR = "#48A015";
    var INSTALLATIONS_BORDER_COLOR = "#C50700";
    var RESERVATIONS_BORDER_COLOR = "#C36080";
    var SELFTRANSPORTS_BORDER_COLOR = "#C7A032";
    var EVENT_TEXT_COLOR = "#000000";

    fullcalendar.fullCalendar({
        googleCalendarApiKey: 'AIzaSyDNriXYLhSFMcUEMU00O5RwUdA0M-QLpr4',  //TODO moze tu byt api kluc?
        eventSources: [
            {
                googleCalendarId: 'o776rmha219v92fvejs0hahsso@group.calendar.google.com',
                color: ACTIONS_COLOR,
                borderColor: ACTIONS_BORDER_COLOR,
                editable: true
            },
            {
                googleCalendarId: 'gehqh0ptgh0i2hkh3f1l4tlerg@group.calendar.google.com',
                color: INSTALLATIONS_COLOR,
                borderColor: '#FF00FF',
                editable: true
            },
            {
                googleCalendarId: '3jg1lna270kjsjb0jjrhhqo5m8@group.calendar.google.com',
                color: RESERVATIONS_COLOR,
                borderColor: RESERVATIONS_BORDER_COLOR,
                editable: true
            },
            {
                googleCalendarId: 'hq8a7ru1eh0qoj7bpn05amtsg8@group.calendar.google.com',
                color: SELFTRANSPORTS_COLOR,
                eventBorderColor: SELFTRANSPORTS_BORDER_COLOR,
                editable: true
            }
        ],
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        selectHelper: true,
        unselectCancel: ".popover",
        timezone: 'local',
        selectable: true,
        defaultView: 'agendaWeek',
        viewRender: function (view, element) {
            datepicker.datepicker('setDate', view.intervalStart.format());
        },
        select: onTimeRangeSelect,
        unselect: removePopovers,
        eventDrop: dragEvent,
        eventResize: dragEvent,
        eventClick: eventClick
    });

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
    $(jsEvent.target).popover({
        animation: false,
        container: '#fullcalendar',
        title: event.title,
        trigger: 'manual',
        placement: 'auto',
        html: true,
        content: $("#popoverClick").html()
    });
    $(jsEvent.target).popover('show');
    doNotDismissOnPopoverClick();
    return false;
}

function onTimeRangeSelect(start, end, jsEvent, view) {
    removePopovers();
    $(jsEvent.target).popover({
        animation: false,
        container: '#fullcalendar',
        title: Messages('h.newEvent'),
        trigger: 'manual',
        placement: 'auto',
        html: true,
        content: $("#popoverNew").html()
    });
    $(jsEvent.target).popover('show');
    $('.popover .inputNewEvent').focus();
    eventViewModel.event().start(start.valueOf());
    eventViewModel.event().end(end.valueOf());
    eventViewModel.event().allDay(!start.hasTime());
    ko.applyBindings(eventViewModel, $('.popover')[0]);

    doNotDismissOnPopoverClick();
    $('.fc-widget-content').on('click', function (event) {
        event.stopPropagation();
    });
    $(".formNew").on('submit', function (event) {
        if (submitClicked === 'addEventAndEdit') return true;
        var requestAddEvent = jsRoutes.controllers.Events.add().ajax({data: eventViewModel.event()});
        var fullcalendar = $('#fullcalendar');
        removePopovers();
        fullcalendar.fullCalendar('unselect');
        requestAddEvent.done(function (eventName) {
            eventViewModel.event().name('');
            showSuccessNotification(Messages('f.addEvent', eventName));
            fullcalendar.fullCalendar('refetchEvents');
        });
        requestAddEvent.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.googleCal'));
        });
        return false;
    });
}

function dragEvent(event, delta, revertFunc, jsEvent, ui, view) {
}

function doNotDismissOnPopoverClick() {
    $('.popover').on('click', function (event) {
        event.stopPropagation();
    });
}

function removePopovers() {
    var popover = $('.popover');
    if (popover[0] === undefined) return;
    ko.cleanNode(popover[0]);
    popover.remove();
}

function Event() {
    this.eventType = ko.observable();
    this.name = ko.observable();
    this.start = ko.observable();
    this.end = ko.observable();
    this.allDay = ko.observable();
}

function Action(id, name) {
    this.id = ko.observable(id);
    this.name = ko.observable(name);
}

function EventViewModel() {

    this.event = ko.validatedObservable(new Event());

}

var eventViewModel = new EventViewModel();
