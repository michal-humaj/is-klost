package services;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import com.google.common.collect.ImmutableMap;
import dto.EventType;

import java.io.IOException;
import java.util.Map;

import static play.mvc.Controller.session;

/**
 * Created by MiHu on 20.2.2015.
 */
public class GoogleAPI {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    public static final Map<EventType, String> calIds = ImmutableMap.of(
            EventType.ACTION, "gkga73e3s4bklif5eltqb41gno@group.calendar.google.com",
            EventType.RESERVATION, "qe79trfqih92ah9rnq19h5pmto@group.calendar.google.com",
            EventType.INSTALLATION, "rt1atosnnssnfqp0nmupusq31g@group.calendar.google.com",
            EventType.SELFTRANSPORT, "ccb1islld3e8s5iukdksp6k4k0@group.calendar.google.com"
    );

    public static Event addEvent(Event event, EventType eventType) throws IOException {
        return calendar()
                .events()
                .insert(calIds.get(eventType), event)
                .setOauthToken(session("accessToken"))
                .execute();
    }

    public static Event findEvent(EventType eventType, String id) throws IOException {
        return calendar()
                .events()
                .get(calIds.get(eventType), id)
                .setOauthToken(session("accessToken"))
                .execute();
    }

    public static void updateEvent(Event event, EventType eventType) throws IOException {
        event.setSequence(calendar()
                .events()
                .get(calIds.get(eventType), event.getId())
                .setOauthToken(session("accessToken"))
                .execute()
                .getSequence());
        calendar()
                .events()
                .update(calIds.get(eventType), event.getId(), event)
                .setOauthToken(session("accessToken"))
                .execute();
    }

    public static void deleteEvent(EventType eventType, String id) throws IOException {
        calendar()
                .events()
                .delete(calIds.get(eventType), id)
                .setOauthToken(session("accessToken"))
                .execute();
    }

    public static void moveEvent(EventType eventType, String id) throws IOException {
        EventType moveTo;
        if (eventType == EventType.ACTION) {
            moveTo = EventType.RESERVATION;
        } else if (eventType == EventType.RESERVATION) {
            moveTo = EventType.ACTION;
        } else {
            throw new IllegalArgumentException("Events of type: " + eventType + " cannot be moved to different calendar.");
        }
        calendar()
                .events()
                .move(calIds.get(eventType), id, calIds.get(moveTo))
                .setOauthToken(session("accessToken"))
                .execute();
    }

    public static Events findEvents(EventType type, Long millisMin, Long millisMax) throws IOException {
        return findEvents(type, millisMin, millisMax, session("accessToken"));
    }

    public static Events findEvents(EventType type, Long millisMin, Long millisMax, String accessToken) throws IOException {
        DateTime dateTimeMin = millisMin == null ? null : new DateTime(millisMin);
        DateTime dateTimeMax = millisMax == null ? null : new DateTime(millisMax);
        return findEvents(type, dateTimeMin, dateTimeMax, accessToken);
    }

    public static Events findEvents(EventType type,  DateTime dateTimeMin, DateTime dateTimeMax, String accessToken) throws IOException {
        return calendar()
                .events()
                .list(calIds.get(type))
                .setTimeMin(dateTimeMin)
                .setTimeMax(dateTimeMax)
                .setOauthToken(accessToken)
                .execute();
    }

    private static Calendar calendar() {
        Calendar.Builder builder = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, null);
        return builder.build();
    }
}

