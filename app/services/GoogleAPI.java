package services;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
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

            EventType.ACTION, "o776rmha219v92fvejs0hahsso@group.calendar.google.com",
            EventType.RESERVATION, "3jg1lna270kjsjb0jjrhhqo5m8@group.calendar.google.com",
            EventType.INSTALLATION, "gehqh0ptgh0i2hkh3f1l4tlerg@group.calendar.google.com",
            EventType.SELFTRANSPORT, "hq8a7ru1eh0qoj7bpn05amtsg8@group.calendar.google.com"
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

    private static Calendar calendar() {
        Calendar.Builder builder = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, null);
        return builder.build();
    }
}

