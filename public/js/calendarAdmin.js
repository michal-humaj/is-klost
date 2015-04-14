function initKlostIS() {

    initCalendarVariables();

    eventViewModel = new EventViewModel();

    $('html').on('click', function () {
        removePopovers();
    });

    var datepicker = createDatepicker();
    var fullcalendar = $('#fullcalendar');
    pMouseOverEvent = $('#pMouseOverEvent');
    fullcalendarArgs.eventSources.map(function (eSource) {
        eSource.editable = true;
    });
    fullcalendarArgs.selectHelper = true;
    fullcalendarArgs.unselectCancel = ".popover";
    fullcalendarArgs.selectable = true;
    fullcalendarArgs.select = onTimeRangeSelect;
    fullcalendarArgs.unselect = removePopovers;
    fullcalendarArgs.eventDrop = dragEvent;
    fullcalendarArgs.eventResize = dragEvent;
    fullcalendarArgs.eventClick = eventClick;
    fullcalendarArgs.eventMouseover = eventMouseover;
    fullcalendarArgs.viewRender = function (view, element) {
        datepicker.datepicker('setDate', view.intervalStart.format());
    };
    fullcalendar.fullCalendar(fullcalendarArgs);

    setFullcalendarHeight();
    addEvent(window, "resize", setFullcalendarHeight);
    ko.applyBindings(eventViewModel, $('#modalDeleteEvent')[0]);

    datepicker.datepicker('option', 'onSelect', function (date) {
        fullcalendar.fullCalendar('gotoDate', date);
    });

    var urlDate = fullcalendar.attr('data-date');
    datepicker.datepicker('setDate', urlDate);
    fullcalendar.fullCalendar('gotoDate', urlDate);
    loadUpcomingActions();
}

function eventMouseover(event, jsEvent, view){
    pMouseOverEvent.html(event.title);
}

function eventClick(event, jsEvent, view) {
    removePopovers();
    var eventType = calTypes[event.source.googleCalendarId];
    eventViewModel.event(new Event(event.id, eventType, event.title));
    $(jsEvent.target).popover({
        animation: false,
        container: '#fullcalendar',
        title: '<a href="/event/' + eventViewModel.event().eventType() + '/' + eventViewModel.event().id() + '">' + event.title + '</a>',
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
    loadUpcomingActions();
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
    eventViewModel.event(new Event(event.id, eventType, event.title, start, end, !event.start.hasTime(), true));
    var requestUpdateEvent = jsRoutes.controllers.Events.drag(eventType, event.id).ajax({data: eventViewModel.event()});

    requestUpdateEvent.done(function () {
        showSuccessNotification(Messages('f.dragEvent', eventViewModel.event().name().split(' →')[0]));
    });
    requestUpdateEvent.fail(function (jqXHR, textStatus) {
        showErrorNotification(Messages('err.googleCal'));
        revertFunc();
    });
}

function loadUpcomingActions() {
    var requestUpcomingActions = jsRoutes.controllers.Events.upcomingActions().ajax();
    requestUpcomingActions.done(function (actions) {
        eventViewModel.upcomingActions(actions);
    });
    requestUpcomingActions.fail(function (jqXHR, textStatus) {
        showErrorNotification(Messages('err.googleCal'));
    });
}