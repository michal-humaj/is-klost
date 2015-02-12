package controllers;

import models.Tent;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.tent.list;
import views.html.tent.neu;

import java.util.List;

import static play.data.Form.form;


/**
 * Created by MiHu on 11.1.2015.
 */
@Security.Authenticated(LoggedStoremanOrAdmin.class)
public class Tents extends Controller {

    public static Result list() {
        List<Tent> tentList = Tent.find.all();
        return ok(list.render(tentList));
    }

    public static Result neu() {
        return ok(neu.render());
    }

    public static Result add() {
        final Tent tent = form(Tent.class).bindFromRequest().get();
        tent.save();
        return redirect(routes.Tents.list());
    }

    public static Result edit(long id) {
        return play.mvc.Results.TODO;
    }

    public static Result update(long id) {
        return play.mvc.Results.TODO;
    }

    public static Result delete(long id) {
        return play.mvc.Results.TODO;

    }
}
