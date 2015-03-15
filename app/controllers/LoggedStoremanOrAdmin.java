package controllers;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.user.AuthUser;
import play.mvc.Http;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static play.mvc.Http.Context.Implicit.session;

/**
 * Created by MiHu on 21.1.2015.
 */
public class LoggedStoremanOrAdmin extends LoggedAdmin {

    private static List<String> storemanIds = Arrays.asList("116064143718081568408", "105229600961564914963", "105150527948667127205");

    @Override
    public String getUsername(final Http.Context ctx) {
        System.out.println("1.)check login status, access token: " + session().get("accessToken"));
        long lastUpdate = session().get("lastUpdate") == null ? 0L : Long.parseLong(session().get("lastUpdate"));
        System.out.println("2.) check login status, last update :" + new Date(lastUpdate));
        final AuthUser u = PlayAuthenticate.getUser(session());
        if (u == null || u.getId() == null) return null;
        if (storemanIds.contains(u.getId())) {
            revokeAccessTokenIfExpired(u);
            return u.getId();
        }
        return super.getUsername(ctx);
    }
}