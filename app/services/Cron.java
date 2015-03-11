package services;

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import controllers.LoggedAdmin;
import dto.Category;
import dto.EventType;
import models.Entry;
import models.StoredItem;
import models.User;
import org.json.JSONException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.avaje.ebean.Expr.eq;

/**
 * Created by MiHu on 10.3.2015.
 */
public class Cron implements Runnable {

    @Override
    public void run() {
        System.out.println((new Date()) + " Cron is running");
        try {
            User admin = User.find.byId(LoggedAdmin.adminId);
            if (admin == null) (new Exception("Cron run: could not find admin in DB")).printStackTrace();
            String accessToken = admin.getFreshAccessToken();

            for (EventType type : EventType.values()) { //iterating over SELF TRANSPORTS and ACTIONS
                if (type.equals(EventType.INSTALLATION) || type.equals(EventType.RESERVATION)) continue;
                long nowMillis = (new Date()).getTime();
                Events events = GoogleAPI.findEvents(type, nowMillis, nowMillis + 300_000L, accessToken);
                for (Event e : events.getItems()) {
                    List<Entry> entries = Entry.find.where().eq("eventType", type).eq("eventId", e.getId())
                            .or(eq("item.category", Category.PB), eq("item.category", Category.CARPET)).findList();
                    for (Entry entry : entries) {
                        StoredItem item = (StoredItem) entry.item;
                        item.amount = item.amount.subtract(entry.amount);
                        item.update();
                        entry.delete();
                    }
                }

            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}