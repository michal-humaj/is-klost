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

    public static final String adminId = "104577664461666247347";
    private static List<String> adminIds = Arrays.asList("104577664461666247347");
    public static final Long ACCESS_TOKEN_LIFETIME = 1_500_000L;

    @Override
    public String getUsername(final Http.Context ctx) {

        final AuthUser u = PlayAuthenticate.getUser(session());
        if (u == null) return null;
        if (isAdminId(u.getId())) {
            revokeAccessTokenIfExpired(u);
            return u.getId();
        }
        return null;
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx) {
        return redirect(routes.App.login());
    }

    public static boolean isAdminId(String id) {
        if (id == null) return false;
        return adminIds.contains(id);
    }

    public static boolean isUserAdmin(){
        final AuthUser u = PlayAuthenticate.getUser(session());
        if (u == null) return false;
        if (isAdminId(u.getId())) {
            return true;
        }
        return false;
    }

    protected void revokeAccessTokenIfExpired(AuthUser authUser) {
        try {
            long lastUpdate = session().get("lastUpdate") == null ? 0L : Long.parseLong(session().get("lastUpdate"));
            if ((new Date()).getTime() - lastUpdate < ACCESS_TOKEN_LIFETIME) return;
            final User dbUser = User.find.byId(authUser.getId());
            if (dbUser != null) {
                String accessToken = dbUser.getFreshAccessToken();
                System.out.println("Access token retrieved: " + accessToken);
                if (accessToken != null) {
                    session().put("accessToken", accessToken);
                    session().put("lastUpdate", Long.toString(new Date().getTime()));
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
