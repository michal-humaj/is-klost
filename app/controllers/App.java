package controllers;

import play.i18n.Messages;
import play.mvc.*;

import views.html.*;


public class App extends Controller {

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result calendar(String date) {
        return ok(calendar.render());
    }

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result store(String date) {
        return ok(store.render());
    }

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result jsRoutes() {
        return Results.TODO;
    }

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result storeStrmn() {
        return Results.TODO;
    }

    public static Result login() {
        return ok(login.render());
    }

    public static Result oAuthDenied(String provider) {
        Http.Context.current().flash().put("flash", Messages.get("p.accept"));
        return ok(login.render());
    }
}
