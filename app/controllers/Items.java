package controllers;

import models.StoredItem;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.util.List;

import static play.data.Form.form;
import static play.libs.Json.toJson;

/**
 * Created by MiHu on 11.1.2015.
 */
@Security.Authenticated(LoggedStoremanOrAdmin.class)
public class Items extends Controller {

    public static Result list() {
        List<StoredItem> items = StoredItem.find.orderBy("category").findList();
        return ok(toJson(items));
    }

    public static Result add() {
        StoredItem item = form(StoredItem.class).bindFromRequest().get();
        item.save();
        return created(Messages.get("f.addItem", item.name));
    }

    public static Result imprt(long id) {
        return play.mvc.Results.TODO;
    }

    public static Result update(long id) {
        return play.mvc.Results.TODO;
    }

    public static Result delete(long id) {
        return play.mvc.Results.TODO;
    }

    public static Result export(long id) {
        return play.mvc.Results.TODO;
    }
}
