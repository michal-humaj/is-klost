function initCalendarVariables(){
    var calIdsElement = $('#calIds');
    calIds = {};
    calIds['ACTION'] = calIdsElement.attr('data-calIdsAction');
    calIds['RESERVATION'] = calIdsElement.attr('data-calIdsReservation');
    calIds['INSTALLATION'] = calIdsElement.attr('data-calIdsInstallation');
    calIds['SELFTRANSPORT'] = calIdsElement.attr('data-calIdsSelftransport');

    calTypes = {};
    calTypes[calIds['ACTION']] = 'ACTION';
    calTypes[calIds['RESERVATION']] = 'RESERVATION';
    calTypes[calIds['INSTALLATION']] = 'INSTALLATION';
    calTypes[calIds['SELFTRANSPORT']] = 'SELFTRANSPORT';

    ONE_HOUR = 3600000;
    ONE_DAY = 86400000;

    ACTIONS_COLOR = "#7BD148";
    INSTALLATIONS_COLOR = "#F83A22";
    RESERVATIONS_COLOR = "#F691B2";
    SELFTRANSPORTS_COLOR = "#FAD165";
    ACTIONS_BORDER_COLOR = "#48A015";
    INSTALLATIONS_BORDER_COLOR = "#C50700";
    RESERVATIONS_BORDER_COLOR = "#C36080";
    SELFTRANSPORTS_BORDER_COLOR = "#C7A032";

    fullcalendarArgs = {
        googleCalendarApiKey: 'AIzaSyDNriXYLhSFMcUEMU00O5RwUdA0M-QLpr4',  //TODO moze tu byt api kluc?
        eventSources: [
            {
                googleCalendarId: calIds['ACTION'],
                color: ACTIONS_COLOR,
                borderColor: ACTIONS_BORDER_COLOR,
                textColor: '#000000'
            },
            {
                googleCalendarId: calIds['INSTALLATION'],
                color: INSTALLATIONS_COLOR,
                borderColor: INSTALLATIONS_BORDER_COLOR,
                textColor: '#000000'
            },
            {
                googleCalendarId: calIds['RESERVATION'],
                color: RESERVATIONS_COLOR,
                borderColor: RESERVATIONS_BORDER_COLOR,
                textColor: '#000000'
            },
            {
                googleCalendarId: calIds['SELFTRANSPORT'],
                color: SELFTRANSPORTS_COLOR,
                eventBorderColor: SELFTRANSPORTS_BORDER_COLOR,
                textColor: '#000000'
            }
        ],
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        timezone: 'local',
        defaultView: 'agendaWeek'
    };
}

function removePopovers() {
    var popover = $('.popover');
    if (popover[0] === undefined) return;
    ko.cleanNode(popover[0]);
    popover.remove();
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

function Event(id, eventType, name, start, end, allDay, dontSplit) {
    this.id = ko.observable(id);
    this.eventType = ko.observable(eventType);
    if (name === undefined) {
        this.name = ko.observable();
    } else if (dontSplit){
        this.name = ko.observable(name);
    }else{
        this.name = ko.observable(name.split(' →')[0]);
    }
    this.start = ko.observable(start);
    this.end = ko.observable(end);
    this.allDay = ko.observable(allDay);
    this.actionId = ko.observable();

    this.changeCalText = ko.computed(function () {
        return this.eventType() === 'RESERVATION' ? Messages('btn.toAction') : Messages('btn.toReservation');
    }, this);

    this.downloadDocText = ko.computed(function () {
        return this.eventType() === 'SELFTRANSPORT' ? Messages('btn.contract') : Messages('btn.specs');
    }, this);

    this.isChangeCalBtnVisible = ko.computed(function () {
        if (this.eventType() === 'RESERVATION' || this.eventType() === 'ACTION') {
            return true;
        }
        return false;
    }, this);

    this.isDownloadDocBtnVisible = ko.computed(function () {
        if (this.eventType() === 'INSTALLATION') {
            return false;
        }
        return true;
    }, this);
}


function EventViewModel() {

    this.event = ko.validatedObservable(new Event());
    this.upcomingActions = ko.observableArray([]);

    this.modalDelete = function () {
        removePopovers();
        $('#modalDeleteEvent').modal('show');
    }

    this.delet = function () {
        var requestDeleteEvent;
        $('#modalDeleteEvent').modal('hide');
        if ('INSTALLATION' === this.event().eventType()) {
            requestDeleteEvent = jsRoutes.controllers.Events.deleteInstl(this.event().id()).ajax();
        } else {
            requestDeleteEvent = jsRoutes.controllers.Events.delete(this.event().eventType(), this.event().id()).ajax();
        }
        requestDeleteEvent.done(function () {
            showSuccessNotification(Messages('f.deleteEvent', eventViewModel.event().name()));
            $('#fullcalendar').fullCalendar('refetchEvents');
        });
        requestDeleteEvent.fail(function (jqXHR, textStatus) {
            showErrorNotification(Messages('err.googleCal'));
        });
    }

    this.changeCal = function () {
        removePopovers();
        var requestChangeCal = jsRoutes.controllers.Events.changeCal(this.event().eventType(), this.event().id()).ajax();
        requestChangeCal.done(function () {
            if (eventViewModel.event().eventType() === 'RESERVATION') {
                showSuccessNotification(Messages('f.changeToAction', eventViewModel.event().name()));
            } else {
                showSuccessNotification(Messages('f.changeToReservation', eventViewModel.event().name()));
            }
            $('#fullcalendar').fullCalendar('refetchEvents');
        });
        requestChangeCal.fail(function (jqXHR, textStatus) {
            if (jqXHR.status === 400) {
                showErrorNotification(Messages('err.changeCal'));
            } else {
                showErrorNotification(Messages('err.googleCal'));
            }
        });
    }

    this.priceOffer = function () {
        removePopovers();
    }
}