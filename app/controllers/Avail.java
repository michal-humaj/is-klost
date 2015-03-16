package controllers;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import dto.*;
import models.*;
import org.joda.time.LocalDate;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.GoogleAPI;

import java.io.IOException;
import java.util.*;

import static com.avaje.ebean.Expr.eq;
import static java.util.Collections.sort;
import static play.data.Form.form;
import static play.libs.Json.toJson;

/**
 * Created by MiHu on 11.1.2015.
 */
@Security.Authenticated(LoggedStoremanOrAdmin.class)
public class Avail extends Controller {

    public static Result getEventsAt(String date) throws IOException {
        LocalDate localDate = new LocalDate(date);
        DateTime dateTimeNow = new DateTime((new LocalDate()).toDateTimeAtStartOfDay().getMillis());
        DateTime dateTimeMin = new DateTime(localDate.toDateTimeAtStartOfDay().getMillis());
        DateTime dateTimeMax = new DateTime(localDate.toDateTimeAtStartOfDay().plusDays(1).getMillis());
        Set<EventTO> eventTOList = new HashSet<>();
        com.google.api.services.calendar.model.Events events;
        for (EventType eType : EventType.values()) {
            events = GoogleAPI.findEvents(eType, dateTimeMin, dateTimeMax, session("accessToken"));
            for (Event e : events.getItems()) {
                if (eType != EventType.INSTALLATION) {
                    eventTOList.add(new EventTO(e, eType));
                    continue;
                }
                Installation inst = Installation.find.byId(e.getId());
                if (inst == null) continue;
                try {
                    Event action = GoogleAPI.findEvent(EventType.ACTION, inst.actionId);
                    eventTOList.add(new EventTO(action, EventType.ACTION));
                } catch (IOException ex) {
                    inst.delete();
                }
            }
        }
        Set<EventTO> tilDateEventList = new HashSet();
        for (EventType eType : EventType.values()) {
            if (eType == EventType.INSTALLATION) continue;
            events = GoogleAPI.findEvents(eType, dateTimeNow, dateTimeMin, session("accessToken"));
            for (Event e : events.getItems()) {
                tilDateEventList.add(new EventTO(e, eType));
            }
        }
        tilDateEventList.removeAll(eventTOList);
        EventsContainer container = new EventsContainer();
        container.actions = new ArrayList(eventTOList);
        container.tilDateActions = new ArrayList(tilDateEventList);
        return ok(toJson(container));
    }

    public static Result availability() {
        List<StoredItem> items = StoredItem.find.all();
        Map<Long, AvailTO> map = new HashMap();
        Iterator<StoredItem> it = items.iterator();
        while (it.hasNext()) {
            StoredItem i = it.next();
            map.put(i.id, new AvailTO(i.id, i.name, i.category, i.amount, i.weight));
            it.remove();
        }
        items = null;

        EventsContainer container = form(EventsContainer.class).bindFromRequest().get();
        for (EventTO eventTO : container.actions) {
            List<Entry> eventEntries = Entry.find.where().eq("eventType", eventTO.eventType).eq("eventId", eventTO.id).findList();
            for (Entry entry : eventEntries) {
                AvailTO availTO = map.get(entry.item.id);
                if (availTO == null) {//je to stan
                    Tent tent = Tent.find.byId(entry.item.id);
                    if (tent == null) continue;
                    for (Accessory a : tent.accessories) {
                        availTO = map.get(a.item.id);
                        if (eventTO.eventType.equals(EventType.RESERVATION)) {
                            availTO.reserve(entry.amount.multiply(a.amount));
                        } else {
                            availTO.rent(entry.amount.multiply(a.amount));
                        }
                    }
                } else {
                    if (eventTO.eventType.equals(EventType.RESERVATION)) {
                        availTO.reserve(entry.amount);
                    } else {
                        availTO.rent(entry.amount);
                    }
                }
            }
        }
        for (EventTO eventTO : container.tilDateActions) {
            List<Entry> eventEntries = Entry.find.where().eq("eventType", eventTO.eventType).eq("eventId", eventTO.id).or(eq("item.category", Category.CARPET), eq("item.category", Category.PB)).findList();
            for (Entry entry : eventEntries) {
                AvailTO availTO = map.get(entry.item.id);
                if (eventTO.eventType.equals(EventType.RESERVATION)) {
                    availTO.reserve(entry.amount);
                } else {
                    availTO.rent(entry.amount);
                }
            }
        }
        ArrayList<AvailTO> availTos = new ArrayList(map.values());
        sort(availTos);
        return ok(toJson(availTos));
    }
}
