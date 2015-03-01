package dto;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by MiHu on 20.2.2015.
 */
public class EventTO {

    public String name;
    public EventType eventType;
    public long start;
    public long end;
    public boolean allDay;

    public Event toGoogleEvent(){
        Event e = new Event();
        e.setSummary(name);


        EventDateTime startEventDateTime = new EventDateTime();
        EventDateTime endEventDateTime = new EventDateTime();

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
