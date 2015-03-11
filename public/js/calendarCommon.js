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

var ACTIONS_COLOR = "#7BD148";
var INSTALLATIONS_COLOR = "#F83A22";
var RESERVATIONS_COLOR = "#F691B2";
var SELFTRANSPORTS_COLOR = "#FAD165";
var ACTIONS_BORDER_COLOR = "#48A015";
var INSTALLATIONS_BORDER_COLOR = "#C50700";
var RESERVATIONS_BORDER_COLOR = "#C36080";
var SELFTRANSPORTS_BORDER_COLOR = "#C7A032";
var EVENT_TEXT_COLOR = "#000000";

var fullcalendarArgs = {
    googleCalendarApiKey: 'AIzaSyDNriXYLhSFMcUEMU00O5RwUdA0M-QLpr4',  //TODO moze tu byt api kluc?
    eventSources: [
        {
            googleCalendarId: calIds['ACTION'],
            color: ACTIONS_COLOR,
            borderColor: ACTIONS_BORDER_COLOR
        },
        {
            googleCalendarId: calIds['INSTALLATION'],
            color: INSTALLATIONS_COLOR,
            borderColor: INSTALLATIONS_BORDER_COLOR
        },
        {
            googleCalendarId: calIds['RESERVATION'],
            color: RESERVATIONS_COLOR,
            borderColor: RESERVATIONS_BORDER_COLOR
        },
        {
            googleCalendarId: calIds['SELFTRANSPORT'],
            color: SELFTRANSPORTS_COLOR,
            eventBorderColor: SELFTRANSPORTS_BORDER_COLOR
        }
    ],
    header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
    },
    timezone: 'local',
    defaultView: 'agendaWeek',
    viewRender: function (view, element) {
        datepicker.datepicker('setDate', view.intervalStart.format());
    },
    eventClick: eventClick
};