package controllers;

import com.google.api.services.calendar.model.Event;
import dto.EntriesContainer;
import dto.EventTO;
import dto.EventType;
import models.Entry;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import services.GoogleAPI;
import views.html.error404;
import views.html.event.editAdmin;

import java.io.IOException;
import java.util.List;

import static play.data.Form.form;
import static play.libs.Json.toJson;
import static play.mvc.Http.Context.current;

/**
 * Created by MiHu on 11.1.2015.
 */
public class Events extends Controller {

    public static Result add() throws IOException {
        EventTO eventTO = form(EventTO.class).bindFromRequest().get();
        GoogleAPI.addEvent(eventTO.toGoogleEvent(null, null), eventTO.eventType);
        return ok();
    }

    public static Result addAndEdit() throws IOException {
        EventTO eventTO = form(EventTO.class).bindFromRequest().get();
        Event e = GoogleAPI.addEvent(eventTO.toGoogleEvent(null, null), eventTO.eventType);
        return redirect(routes.Events.edit(eventTO.eventType.toString(), e.getId()));
    }

    public static Result edit(String eventType, String id) {
        Event e;
        try {
            e = GoogleAPI.findEvent(EventType.valueOf(eventType), id);
        } catch (IOException | IllegalArgumentException e1) {
            e1.printStackTrace();
            return notFound(error404.render());
        }
        EventTO eventTO = new EventTO(e);
        Form<EventTO> eventForm = form(EventTO.class).fill(eventTO);
        return ok(editAdmin.render(eventType, id, eventTO.allDay, eventForm, eventTO.startDate));
    }

    public static Result update(String sEventType, String id) throws Exception {
        try {
            EventType eventType = EventType.valueOf(sEventType);
            Event e = GoogleAPI.findEvent(eventType, id);
            EventTO eventTO = form(EventTO.class).bindFromRequest().get();
            EntriesContainer container = form(EntriesContainer.class).bindFromRequest().get();
            List<Entry> oldEntries = Entry.find.where().eq("eventType", eventType).eq("eventId", id).findList();
            for (Entry entry : oldEntries) entry.delete();
            for (Entry entry : container.entries) {
                entry.eventType = eventType;
                entry.eventId = e.getId();
                entry.save();
            }
            container.entries = Entry.find.where().eq("eventType", eventType).eq("eventId", id).findList();
            e = eventTO.toGoogleEvent(e.getId(), container.getEntriesInfo());
            GoogleAPI.updateEvent(e, eventType);
            return redirect(routes.App.calendar(eventTO.startDate));
        } catch (IOException | IllegalArgumentException e1) {
            e1.printStackTrace();
            return notFound(error404.render());
        } catch (IllegalStateException e1) {
            current().flash().put("error", Messages.get("err.eventStartEnd", id));
            return redirect(routes.Events.edit(sEventType, id));
        }
    }

    public static Result delete(String sEventType, String id) throws IOException {
        EventType eventType = EventType.valueOf(sEventType);
        GoogleAPI.deleteEvent(eventType, id);
        List<Entry> entries = Entry.find.where().eq("eventType", eventType).eq("eventId", id).findList();
        for (Entry entry : entries) entry.delete();
        return ok();
    }

    public static Result drag(String eventType, String id) throws IOException {
        EventTO eventTO = form(EventTO.class).bindFromRequest().get();
        GoogleAPI.updateEvent(eventTO.toGoogleEvent(id, null), eventTO.eventType);
        return ok();
    }

    public static Result changeCal(String sEventType, String id)  {
        EventType eventType = EventType.valueOf(sEventType);
        try {
            GoogleAPI.moveEvent(eventType, id);
        } catch (IOException e) {
            if (e.getMessage().contains("cannotChangeOrganizerOfInstance")){
                return badRequest();
            }else{
                return notFound();
            }
        }
        final List<Entry> entries = Entry.find.where().eq("eventType", eventType).eq("eventId", id).findList();
        for(Entry entry: entries){
            entry.eventType = eventType == EventType.ACTION ? EventType.RESERVATION : EventType.ACTION;
            entry.update(entry.id);
        }
        //TODO kod na zmazanie instalacii
        return ok();
    }

    public static Result editInstl(String eventType, String id) {
        return play.mvc.Results.TODO;
    }

    public static Result updateInstl(String eventType, String id) {
        return play.mvc.Results.TODO;
    }

    public static Result editStrmn(String eventType, String id) {
        return play.mvc.Results.TODO;
    }

    public static Result updateStrmn(String eventType, String id) {
        return play.mvc.Results.TODO;
    }

    public static Result upcomingActions() {
        return play.mvc.Results.TODO;
    }

    public static Result getEntries(String eventType, String id) {
        List<Entry> entries = Entry.find.where().eq("eventType", EventType.valueOf(eventType)).eq("eventId", id).findList();
        return ok(toJson(entries));
    }
}
