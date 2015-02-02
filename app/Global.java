import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.PlayAuthenticate.Resolver;
import com.feth.play.module.pa.exceptions.AccessDeniedException;
import com.feth.play.module.pa.exceptions.AuthException;
import play.Application;
import play.GlobalSettings;
import play.i18n.Messages;
import play.mvc.Call;
import play.mvc.Http;
import controllers.routes;

;

/**
 * Created by MiHu on 21.1.2015.
 */
public class Global extends GlobalSettings {


    public void onStart(final Application app) {

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

  /*  public Promise<Result> onError(RequestHeader request, Throwable t) {
        return Promise.<Result>pure(internalServerError(
                views.html.error500.render()
        ));
    }

    public Promise<Result> onHandlerNotFound(RequestHeader request) {
        return Promise.<Result>pure(notFound(
                views.html.error404.render()
        ));
    }

    public Promise<Result> onBadRequest(RequestHeader request, String error) {
        return Promise.<Result>pure(badRequest(
                views.html.error404.render()
        ));
    }*/
}