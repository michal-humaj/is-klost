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

    public String id;
    public String name;
    public EventType eventType;
    public long start;
    public long end;
    public boolean allDay;
    public String actionId;

    public String startDate;
    public String startTime = "00:00";
    public String endDate;
    public String endTime = "00:00";

    public EventTO() {
    }

    public EventTO(Event e, EventType eventType) {
        this(e);
        this.eventType = eventType;
    }

    public EventTO(Event e) {
        name = e.getSummary() == null ? "" : e.getSummary().split(" →")[0];
        DateTime startDateTime;
        DateTime endDateTime;
        id = e.getId();
        if (e.getStart() == null) {
            return;
        }
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

    public Event toGoogleEvent(String id, String entriesInfo, boolean dontSplit) {
        Event e = new Event();
        if (!dontSplit) name = name.split(" →")[0];
        if (entriesInfo == null) {
            e.setSummary(name);
        } else {
            e.setSummary(name + " → " + entriesInfo);
        }
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

    public Event toGoogleEvent(String id, String entriesInfo) {
        return toGoogleEvent(id, entriesInfo, false);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventTO)) return false;

        EventTO eventTO = (EventTO) o;

        if (eventType != eventTO.eventType) return false;
        if (id != null ? !id.equals(eventTO.id) : eventTO.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        return result;
    }
}