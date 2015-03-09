package controllers;

import jsmessages.JsMessages;
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
        if("TODAY".equals(date) || !Util.isDateValid(date)){
            String todayDate = Util.sdf.format(new Date(1427583600000l)); //TODO bacha na casovu zonu na serveri
            return ok(calendar.render(todayDate));
        }
        return ok(calendar.render(date));
    }

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result store(String date) {

        if (isUserAdmin()) {
            return ok(storeAdmin.render());
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
                        routes.javascript.Events.drag()


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
