package dto;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiHu on 11.3.2015.
 */
public class EventsContainer {

    public List<EventTO> actions = new ArrayList();
    public List<EventTO> tilDateActions = new ArrayList();

    public EventsContainer() {
    }

    public EventsContainer(Events events) {
        for (Event e : events.getItems()) {
            actions.add(new EventTO(e));
        }
    }
}
