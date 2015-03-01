package controllers;

import dto.EventTO;
import play.mvc.Controller;
import play.mvc.Result;
import services.GoogleAPI;

import java.io.IOException;

import static play.data.Form.form;

/**
 * Created by MiHu on 11.1.2015.
 */
public class Events extends Controller {

    public static Result add() throws IOException {
        EventTO eventTO = form(EventTO.class).bindFromRequest().get();

  
        GoogleAPI.addEvent(eventTO.toGoogleEvent(), eventTO.eventType);

        return ok(eventTO.name);
    }

    public static Result edit(String type, String id) {
        return play.mvc.Results.TODO;
    }

    public static Result update(String type, String id) {
        return play.mvc.Results.TODO;
    }

    public static Result delete(String eventType, String id) {
        return play.mvc.Results.TODO;
    }

    public static Result drag(String eventType, String id) {
        return play.mvc.Results.TODO;
    }

    public static Result changeCal(String eventType, String id) {
        return play.mvc.Results.TODO;
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
}
