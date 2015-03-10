var calIds = {};
calIds['ACTION'] = "o776rmha219v92fvejs0hahsso@group.calendar.google.com";
calIds['RESERVATION'] = "3jg1lna270kjsjb0jjrhhqo5m8@group.calendar.google.com";
calIds['INSTALLATION'] = "gehqh0ptgh0i2hkh3f1l4tlerg@group.calendar.google.com";
calIds['SELFTRANSPORT'] = "hq8a7ru1eh0qoj7bpn05amtsg8@group.calendar.google.com";

var calTypes = {};
calTypes[calIds['ACTION']] = 'ACTION';
calTypes[calIds['RESERVATION']] = 'RESERVATION';
calTypes[calIds['INSTALLATION']] = 'INSTALLATION';
calTypes[calIds['SELFTRANSPORT']] = 'SELFTRANSPORT';

var ONE_HOUR = 3600000;
var ONE_DAY = 86400000;

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
                googleCalendarId: calIds['ACTION'],
                color: ACTIONS_COLOR,
                borderColor: ACTIONS_BORDER_COLOR,
                editable: true
            },
            {
                googleCalendarId: calIds['INSTALLATION'],
                color: INSTALLATIONS_COLOR,
                borderColor: INSTALLATIONS_BORDER_COLOR,
                editable: true
            },
            {
                googleCalendarId: calIds['RESERVATION'],
                color: RESERVATIONS_COLOR,
                borderColor: RESERVATIONS_BORDER_COLOR,
                editable: true
            },
            {
                googleCalendarId: calIds['SELFTRANSPORT'],
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
    ko.applyBindings(eventViewModel, $('#modalDeleteEvent')[0]);

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
    eventViewModel.event(new Event(event.id, eventType, event.title));
    $(jsEvent.target).popover({
        animation: false,
        container: '#fullcalendar',
        title: event.title.split(' →')[0],
        trigger: 'manual',
        placement: 'auto',
        html: true,
        content: $("#popoverClick").html()
    });
    $(jsEvent.target).popover('show');
    doNotDismissOnPopoverClick();
    ko.applyBindings(eventViewModel, $('.popover')[0]);
    return false;
}

function onTimeRangeSelect(start, end, jsEvent, view) {
    removePopovers();
    eventViewModel.event(new Event());
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
        requestAddEvent.done(function () {
            showSuccessNotification(Messages('f.addEvent', eventViewModel.event().name()));
            fullcalendar.fullCalendar('refetchEvents');
        });
        requestAddEvent.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.googleCal'));
        });
        return false;
    });
}

function dragEvent(event, delta, revertFunc, jsEvent, ui, view) {
    var eventType = calTypes[event.source.googleCalendarId];
    var start = event.start.valueOf();
    var end;
    if (event.end !== null) {
        end = event.end.valueOf();
    } else if (event.start.hasTime()) {
        end = event.start.valueOf() + 2 * ONE_HOUR;
    } else {
        end = event.start.valueOf() + ONE_DAY;
    }
    eventViewModel.event(new Event(event.id, eventType, event.title, start, end, !event.start.hasTime()));
    var requestUpdateEvent = jsRoutes.controllers.Events.drag(eventType, event.id).ajax({data: eventViewModel.event()});

    requestUpdateEvent.done(function () {
        showSuccessNotification(Messages('f.dragEvent', eventViewModel.event().name()));
    });
    requestUpdateEvent.fail(function (jqXHR, textStatus) {
        showErrorNotification(Messages('err.googleCal'));
        revertFunc();
    });
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

function Event(id, eventType, name, start, end, allDay) {
    this.id = ko.observable(id);
    this.eventType = ko.observable(eventType);
    if (name === undefined){
        this.name = ko.observable();
    }else{
        this.name = ko.observable(name.split(' →')[0]);
    }
    this.start = ko.observable(start);
    this.end = ko.observable(end);
    this.allDay = ko.observable(allDay);
}

function Action(id, name) {
    this.id = ko.observable(id);
    this.name = ko.observable(name);
}

function EventViewModel() {

    this.event = ko.validatedObservable(new Event());

    this.modalDelete = function () {
        removePopovers();
        $('#modalDeleteEvent').modal('show');
    }

    this.delet = function () {
        $('#modalDeleteEvent').modal('hide');
        var requestDeleteEvent = jsRoutes.controllers.Events.delete(this.event().eventType(), this.event().id()).ajax();
        requestDeleteEvent.done(function () {
            showSuccessNotification(Messages('f.deleteEvent', eventViewModel.event().name()));
            $('#fullcalendar').fullCalendar('refetchEvents');
        });
        requestDeleteEvent.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.googleCal'));
        });
    }

}

var eventViewModel = new EventViewModel();
