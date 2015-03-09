var addEvent = function(elem, type, eventHandle) {
    if (elem == null || typeof(elem) == 'undefined') return;
    if ( elem.addEventListener ) {
        elem.addEventListener( type, eventHandle, false );
    } else if ( elem.attachEvent ) {
        elem.attachEvent( "on" + type, eventHandle );
    } else {
        elem["on"+type]=eventHandle;
    }
}

function createDatepicker(){
    $.datepicker.regional['sk'] = {
        closeText: 'Zavrieť',
        prevText: '&#x3c;Predchádzajúci',
        nextText: 'Nasledujúci&#x3e;',
        currentText: 'Dnes',
        monthNames: ['Január','Február','Marec','Apríl','Máj','Jún',
            'Júl','August','September','Október','November','December'],
        monthNamesShort: ['Jan','Feb','Mar','Apr','Máj','Jún',
            'Júl','Aug','Sep','Okt','Nov','Dec'],
        dayNames: ['Nedel\'a','Pondelok','Utorok','Streda','Štvrtok','Piatok','Sobota'],
        dayNamesShort: ['Ned','Pon','Uto','Str','Štv','Pia','Sob'],
        dayNamesMin: ['Ne','Po','Ut','St','Št','Pia','So'],
        weekHeader: 'Ty',
        dateFormat: 'yy-mm-dd',
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''};

    var datepicker =  $("#datepicker");
    datepicker.datepicker($.datepicker.regional['sk']);
    datepicker.datepicker('option', 'firstDay', 1);
    return datepicker;
}

function initTooltips(){
    $('[data-rel="tooltip"]').tooltip();
}

function setAvailTableHeightAdmin(){
    $("table.tableScrollable tbody").height($(window).height() - $("#widgetEvents").height() - 192);
}

function setAvailTableHeightStoreman() {
    $("table.tableScrollable tbody").height($(window).height() - 159);
}

function setScrollspyOffset(val){
    $('.tableScrollable > tbody').scrollspy({ offset: val });
}

function setAvailTableHeightOnCollapseEventsWidget(){
    $("#btnCollapseEventsWidget").on('click', function() {
        setTimeout(function(){
            setAvailTableHeightAdmin();
        },350);
    });
}

function setFullcalendarHeight(){
    $("#fullcalendar").fullCalendar('option', 'contentHeight', $(window).height() - 119);
}

function showSuccessNotification(msg){
    $.gritter.add({
        title: Messages('h.success'),
        text: msg,
        time: 3000,
        class_name: 'gritter-success gritter-light'
    });
}

function showErrorNotification(msg){
    $.gritter.add({
        title: Messages('h.err'),
        text: msg,
        time: 6000,
        class_name: 'gritter-error gritter-light'
    });
}

var normalize = function (term) {
    var ret = "";
    for (var i = 0; i < term.length; i++) {
        ret += accentMap[term.charAt(i)] || term.charAt(i);
    }
    return ret;
};

var accentMap = {
    "á": "a",
    "ä": "a",
    "č": "c",
    "ď": "d",
    "é": "e",
    "í": "i",
    "ľ": "l",
    "ň": "n",
    "ó": "o",
    "ô": "o",
    "ŕ": "r",
    "š": "s",
    "ť": "t",
    "ú": "u",
    "ý": "y",
    "ž": "z"
};