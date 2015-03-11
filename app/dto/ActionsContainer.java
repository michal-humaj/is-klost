package dto;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiHu on 11.3.2015.
 */
public class ActionsContainer {

    public List<EventTO> actions = new ArrayList();

    public ActionsContainer(Events events) {
        for (Event e : events.getItems()) {
            actions.add(new EventTO(e));
        }
    }
}
