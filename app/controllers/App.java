package controllers;

import play.Routes;
import play.i18n.Messages;
import play.mvc.*;

import views.html.*;

import static controllers.LoggedAdmin.isUserAdmin;


public class App extends Controller {

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result calendar(String date) {
        return ok(calendar.render());
    }

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result store(String date) {

        if( isUserAdmin() ){
            return ok(storeAdmin.render());
        }else{
            return ok(storeStrmn.render());
        }
    }

    @Security.Authenticated(LoggedStoremanOrAdmin.class)
    public static Result jsRoutes() {
        response().setContentType("text/javascript");
        return ok(
                Routes.javascriptRouter("jsRoutes",
                        routes.javascript.Items.list()
                )
        );
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
