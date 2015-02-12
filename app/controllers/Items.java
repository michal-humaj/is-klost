package controllers;

import dto.Category;
import models.StoredItem;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.util.List;

import static com.avaje.ebean.Expr.eq;
import static com.avaje.ebean.Expr.or;
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

    public static Result listTentItems() {
        List<StoredItem> items = StoredItem.find.where().not((or(eq("category", Category.PB), eq("category", Category.CARPET)))).orderBy("category").findList();
        return ok(toJson(items));
    }

    public static Result add() {
        StoredItem item = form(StoredItem.class).bindFromRequest().get();
        item.save();
        return list();
    }

    public static Result update(long id) {
        StoredItem item = StoredItem.find.byId(id);
        if (item == null) return notFound();
        item = form(StoredItem.class).bindFromRequest().get();
        item.update(id);
        return list();
    }

    //TODO ked sa deletuje polozka ktora sa nachadza v stane alebo v evente
    public static Result delete(long id) {
        StoredItem item = StoredItem.find.byId(id);
        if (item == null) {
            return notFound();
        } else {
            item.delete();
            return list();
        }
    }
}
