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

function initDatepicker(){
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
        dateFormat: 'dd.mm.yy',
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''};

    var datepicker =  $("#datepicker");
    datepicker.datepicker($.datepicker.regional['sk']);
    datepicker.datepicker('option', 'firstDay', 1);
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

function showGritterNotification(){
    $.gritter.add({
        title: 'Uspech',
        text: 'Vytvorili ste novy polozku stol novy rododendron',
        time: 2000,
        class_name: 'gritter-success gritter-light'
    });
}


function initFullcalendar(){

    /* initialize the external events
     -----------------------------------------------------------------*/

    $('#external-events div.external-event').each(function () {

        // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
        // it doesn't need to have a start or end
        var eventObject = {
            title: $.trim($(this).text()) // use the element's text as the event title
        };

        // storeAdmin the Event Object in the DOM element so we can get to it later
        $(this).data('eventObject', eventObject);

        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0  //  original position after the drag
        });

    });


    /* initialize the fullcalendar
     -----------------------------------------------------------------*/

    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();


    var fullcalendar = $('#fullcalendar').fullCalendar({
        //isRTL: true,

        buttonHtml: {
            prev: '<i class="ace-icon fa fa-chevron-left"></i>',
            next: '<i class="ace-icon fa fa-chevron-right"></i>'
        },

        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        events: [
            {
                title: 'All Day Event',
                start: new Date(y, m, 1),
                className: 'label-important'
            },
            {
                title: 'Long Event',
                start: moment().subtract(5, 'days').format('YYYY-MM-DD'),
                end: moment().subtract(1, 'days').format('YYYY-MM-DD'),
                className: 'label-success'
            },
            {
                title: 'Some Event',
                start: new Date(y, m, d - 3, 16, 0),
                allDay: false,
                className: 'label-info'
            }
        ]
        ,
        editable: true,
        droppable: true, // this allows things to be dropped onto the fullcalendar !!!
        drop: function (date, allDay) { // this function is called when something is dropped

            // retrieve the dropped element's stored Event Object
            var originalEventObject = $(this).data('eventObject');
            var $extraEventClass = $(this).attr('data-class');


            // we need to copy it, so that multiple events don't have a reference to the same object
            var copiedEventObject = $.extend({}, originalEventObject);

            // assign it the date that was reported
            copiedEventObject.start = date;
            copiedEventObject.allDay = allDay;
            if ($extraEventClass) copiedEventObject['className'] = [$extraEventClass];

            // render the event on the fullcalendar
            // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
            $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);

            // is the "remove after drop" checkbox checked?
            if ($('#drop-remove').is(':checked')) {
                // if so, remove the element from the "Draggable Events" list
                $(this).remove();
            }

        }
        ,
        selectable: true,
        selectHelper: true,
        select: function (start, end, allDay) {

            bootbox.prompt("New Event Title:", function (title) {
                if (title !== null) {
                    fullcalendar.fullCalendar('renderEvent',
                        {
                            title: title,
                            start: start,
                            end: end,
                            allDay: allDay,
                            className: 'label-info'
                        },
                        true // make the event "stick"
                    );
                }
            });


            fullcalendar.fullCalendar('unselect');
        }
        ,
        eventClick: function (calEvent, jsEvent, view) {

            //display a modal
            var modal =
                '<div class="modal fade">\
                  <div class="modal-dialog">\
                   <div class="modal-content">\
                     <div class="modal-body">\
                       <button type="button" class="close" data-dismiss="modal" style="margin-top:-10px;">&times;</button>\
                       <form class="no-margin">\
                          <label>Change event name &nbsp;</label>\
                          <input class="middle" autocomplete="off" type="text" value="' + calEvent.title + '" />\
					 <button type="submit" class="btn btn-sm btn-success"><i class="ace-icon fa fa-check"></i> Save</button>\
				   </form>\
				 </div>\
				 <div class="modal-footer">\
					<button type="button" class="btn btn-sm btn-danger" data-action="delete"><i class="ace-icon fa fa-trash-o"></i> Delete Event</button>\
					<button type="button" class="btn btn-sm" data-dismiss="modal"><i class="ace-icon fa fa-times"></i> Cancel</button>\
				 </div>\
			  </div>\
			 </div>\
			</div>';


            var modal = $(modal).appendTo('body');
            modal.find('form').on('submit', function (ev) {
                ev.preventDefault();

                calEvent.title = $(this).find("input[type=text]").val();
                fullcalendar.fullCalendar('updateEvent', calEvent);
                modal.modal("hide");
            });
            modal.find('button[data-action=delete]').on('click', function () {
                fullcalendar.fullCalendar('removeEvents', function (ev) {
                    return (ev._id == calEvent._id);
                })
                modal.modal("hide");
            });

            modal.modal('show').on('hidden', function () {
                modal.remove();
            });


            //console.log(calEvent.id);
            //console.log(jsEvent);
            //console.log(view);

            // change the border color just for fun
            //$(this).css('border-color', 'red');

        }

    });

    setFullcalendarHeight();

}
