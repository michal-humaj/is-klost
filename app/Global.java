import com.avaje.ebean.Ebean;
import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.PlayAuthenticate.Resolver;
import com.feth.play.module.pa.exceptions.AccessDeniedException;
import com.feth.play.module.pa.exceptions.AuthException;
import models.StoredItem;
import play.Application;
import play.GlobalSettings;
import play.i18n.Messages;
import play.libs.Akka;
import play.libs.F;
import play.libs.Yaml;
import play.mvc.Call;
import play.mvc.Http;
import play.mvc.Result;
import scala.concurrent.duration.Duration;
import services.Cron;
import controllers.routes;

import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static play.mvc.Results.*;

/**
 * Created by MiHu on 21.1.2015.
 */
public class Global extends GlobalSettings {


    public void onStart(final Application app) {

        if (Ebean.find(StoredItem.class).findRowCount() == 0) {
            Ebean.save((List) Yaml.load("initial-data.yml"));
        }

        System.setProperty("user.timezone", "Europe/Warsaw");
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Warsaw"));

        Akka.system().scheduler().schedule(
                Duration.create(25, TimeUnit.MINUTES),
                Duration.create(25, TimeUnit.MINUTES),
                new Cron(),
                Akka.system().dispatcher()
        );

        PlayAuthenticate.setResolver(new Resolver() {
            @Override
            public Call login() {
                return routes.App.login();
            }

            @Override
            public Call afterAuth() {
                return routes.App.calendar("TODAY");
            }

            @Override
            public Call afterLogout() {
                Http.Context.current().flash().put("flash", Messages.get("p.logout"));
                return routes.App.login();
            }

            @Override
            public Call auth(final String provider) {
                return com.feth.play.module.pa.controllers.routes.Authenticate.authenticate(provider);
            }

            @Override
            public Call onException(final AuthException e) {
                if (e instanceof AccessDeniedException) {
                    return routes.App.oAuthDenied(((AccessDeniedException) e)
                            .getProviderKey());
                }

                return super.onException(e);
            }

            @Override
            public Call askLink() {
                return null;
            }

            @Override
            public Call askMerge() {
                return null;
            }
        });
    }

    public F.Promise<Result> onError(Http.RequestHeader request, Throwable t) {
        return F.Promise.<Result>pure(internalServerError(
                views.html.error500.render()
        ));
    }

    public F.Promise<Result> onHandlerNotFound(Http.RequestHeader request) {
        return F.Promise.<Result>pure(notFound(
                views.html.error404.render()
        ));
    }

    public F.Promise<Result> onBadRequest(Http.RequestHeader request, String error) {
        return F.Promise.<Result>pure(badRequest(
                views.html.error404.render()
        ));
    }
}