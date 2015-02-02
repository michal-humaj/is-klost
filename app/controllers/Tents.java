package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.tent.*;


/**
 * Created by MiHu on 11.1.2015.
 */
public class Tents extends Controller {

    public static Result list() {
        return ok(list.render());
    }

    public static Result neu() {
        return play.mvc.Results.TODO;
    }

    public static Result add() {
        return play.mvc.Results.TODO;
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
