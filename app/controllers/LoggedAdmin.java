package controllers;


import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.user.AuthUser;
import models.User;
import org.json.JSONException;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static play.mvc.Http.Context.Implicit.session;


/**
 * Created by MiHu on 21.1.2015.
 */
public class LoggedAdmin extends Security.Authenticator {

    private static List<String> adminIds = Arrays.asList("104577664461666247347");
    public static final Long ACCESS_TOKEN_LIFETIME = 3_000_000l;

    @Override
    public String getUsername(final Http.Context ctx) {
        final AuthUser u = PlayAuthenticate.getUser(session());
        if (u == null) return null;
        if (isAdmin(u.getId())) {
            revokeAccessTokenIfExpired(u);
            return u.getId();
        }
        return null;
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx) {
        return redirect(routes.App.login());
    }

    public static boolean isAdmin(String id) {
        if (id == null) return false;
        return adminIds.contains(id);
    }

    public void revokeAccessTokenIfExpired(AuthUser authUser) {
        try {
            if (session().get("lastUpdate") == null) return;
            final Long lastUpdate = Long.parseLong(session().get("lastUpdate"));
            if ((new Date()).getTime() - lastUpdate < ACCESS_TOKEN_LIFETIME) return;
            final User dbUser = User.find.byId(authUser.getId());
            if (dbUser != null) {
                String accessToken = dbUser.getFreshAccessToken();
                if (accessToken != null) {
                    session().put("acessToken", accessToken);
                    session().put("lastUpdate", Long.toString(new Date().getTime()));
                }
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}