package dto;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

/**
 * Created by MiHu on 20.2.2015.
 */
public class EventTO {

    public String name;
    public EventType eventType;
    public long start;
    public long end;
    public boolean allDay;

    public String startDate;
    public String startTime = "00:00";
    public String endDate;
    public String endTime = "00:00";

    public EventTO() {
    }

    public EventTO(Event e) {
        name = e.getSummary();
        DateTime startDateTime;
        DateTime endDateTime;
        allDay = null == e.getStart().getDateTime();
        if (allDay) {
            startDateTime = e.getStart().getDate();
            endDateTime = e.getEnd().getDate();
        } else {
            startDateTime = e.getStart().getDateTime();
            endDateTime = e.getEnd().getDateTime();
        }
        start = startDateTime.getValue();
        end = endDateTime.getValue();
        startDate = (new LocalDate(start)).toString();
        startTime = (new LocalTime(start)).toString();
        endTime = (new LocalTime(end)).toString();
        if (allDay) {
            endDate = (new LocalDate(end).plusDays(-1)).toString();
        } else {
            endDate = (new LocalDate(end)).toString();
        }
    }

    public Event toGoogleEvent(String id) {
        Event e = new Event();
        e.setSummary(name);
        if (id != null) {
            e.setId(id);
        }

        EventDateTime startEventDateTime = new EventDateTime();
        EventDateTime endEventDateTime = new EventDateTime();

        if (start == 0) {
            LocalTime startTime = new LocalTime(this.startTime);
            LocalTime endTime = new LocalTime(this.endTime);
            LocalDate startDate = new LocalDate(this.startDate);
            LocalDate endDate = new LocalDate(this.endDate);

            if (allDay) {
                start = startDate.toDateTimeAtStartOfDay().plusHours(2).getMillis();
                end = endDate.toDateTimeAtStartOfDay().plusDays(1).plusHours(2).getMillis();
            } else {
                start = startDate.toDateTime(startTime).getMillis();
                end = endDate.toDateTime(endTime).getMillis();
            }
            if (start >= end) {
                throw new IllegalStateException("In allday event end must be later than start.");
            }
        }
        if (allDay) {
            DateTime startDateTime = new DateTime(true, start, null);
            DateTime endDateTime = new DateTime(true, end, null);

            startEventDateTime.setDate(startDateTime);
            endEventDateTime.setDate(endDateTime);
        } else {
            DateTime startDateTime = new DateTime(start);
            DateTime endDateTime = new DateTime(end);

            startEventDateTime.setDateTime(startDateTime);
            endEventDateTime.setDateTime(endDateTime);
        }
        return e.setStart(startEventDateTime).setEnd(endEventDateTime);
    }
}
