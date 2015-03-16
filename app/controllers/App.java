package controllers;

import jsmessages.JsMessages;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import play.Play;
import play.Routes;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.Util;
import views.html.calendar;
import views.html.login;
import views.html.storeAdmin;
import views.html.storeStrmn;

import java.util.Date;

import static controllers.LoggedAdmin.isUserAdmin;
import static play.mvc.Http.Context.current;


public class App extends Controller {

    final static JsMessages messages = JsMessages.create(Play.application());

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result calendar(String date) { // only valid date format is 2015-05-28
        String validDate = date;
        if (date.length() > 9) {
            validDate = date.substring(0, 10);
        }
        if ("TODAY".equals(date) || !Util.isDateValid(date)) {
            DateTime today = new LocalDate().toDateTimeAtStartOfDay();
            validDate = Util.sdf.format(new Date(today.getMillis()));
        }
        return ok(calendar.render(validDate));
    }

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result store(String date) {
        String validDate = date;
        if (date.length() > 9) {
            validDate = date.substring(0, 10);
        }
        if ("TOMORROW".equals(date) || !Util.isDateValid(date)) {
            DateTime today = new LocalDate().toDateTimeAtStartOfDay().plusDays(1);
            validDate = Util.sdf.format(new Date(today.getMillis()));
        }
        if (isUserAdmin()) {
            return ok(storeAdmin.render(validDate));
        } else {
            return ok(storeStrmn.render());
        }
    }

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result jsRoutes() {
        response().setContentType("text/javascript");
        return ok(
                Routes.javascriptRouter("jsRoutes",
                        routes.javascript.Items.list(),
                        routes.javascript.Items.listTentItems(),
                        routes.javascript.Items.add(),
                        routes.javascript.Items.listEventItems(),
                        routes.javascript.Items.update(),
                        routes.javascript.Items.delete(),
                        routes.javascript.Tents.getTent(),
                        routes.javascript.Events.add(),
                        routes.javascript.Events.delete(),
                        routes.javascript.Events.drag(),
                        routes.javascript.Events.getEntries(),
                        routes.javascript.Events.changeCal(),
                        routes.javascript.Events.upcomingActions(),
                        routes.javascript.Events.deleteInstl(),
                        routes.javascript.Avail.getEventsAt(),
                        routes.javascript.Avail.availability()
                )
        );
    }

    public static Result login() {
        return ok(login.render());
    }

    public static Result oAuthDenied(String provider) {
        current().flash().put("flash", Messages.get("p.accept"));
        return ok(login.render());
    }

    public static Result jsMessages() {
        return ok(messages.generate("window.Messages"));
    }
}
