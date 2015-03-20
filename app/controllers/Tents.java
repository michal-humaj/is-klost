package controllers;

import models.Entry;
import models.Tent;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.tent.edit;
import views.html.tent.list;
import views.html.tent.neu;
import views.html.tent.neuFromTemplate;

import java.util.List;

import static play.data.Form.form;
import static play.libs.Json.toJson;
import static play.mvc.Http.Context.current;


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
        Tent tent = form(Tent.class).bindFromRequest().get();
        tent.save();
        current().flash().put("success", Messages.get("f.addTent", tent.name));
        return redirect(routes.Tents.list());
    }

    public static Result edit(long id) {
        return ok(edit.render(id));
    }

    public static Result update(long id) {
        Tent tent = Tent.find.byId(id);
        if (tent == null) {
            current().flash().put("error", Messages.get("err.tentNotFound", id));
        } else {
            tent = form(Tent.class).bindFromRequest().get();
            tent.update(id);
            current().flash().put("success", Messages.get("f.updateTent", tent.name));
        }
        return redirect(routes.Tents.list());
    }

    public static Result delete(long id) {
        Tent tent = Tent.find.byId(id);
        final List<Entry> entries = Entry.find.select("id").where().eq("item.id", id).findList();
        if (tent == null) {
            current().flash().put("error", Messages.get("err.tentNotFound", id));
        } else if (entries.size() != 0) {
            current().flash().put("error", Messages.get("err.deleteTent", tent.name));
        } else {
            String name = tent.name;
            tent.delete();
            current().flash().put("success", Messages.get("f.deleteTent", name));
        }
        return redirect(routes.Tents.list());
    }

    public static Result getTent(long id) {
        Tent tent = Tent.find.byId(id);
        if (tent == null) return notFound();
        return ok(toJson(tent));
    }

    public static Result neuFromTemplate(long id) {
        return ok(neuFromTemplate.render(id));
    }
}
