package services;

import com.feth.play.module.pa.providers.oauth2.OAuth2AuthInfo;
import com.feth.play.module.pa.providers.oauth2.OAuth2AuthUser;
import com.feth.play.module.pa.providers.oauth2.google.GoogleAuthUser;
import com.feth.play.module.pa.service.UserServicePlugin;
import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;
import com.feth.play.module.pa.user.NameIdentity;
import models.User;
import play.Application;

import java.util.Date;

import static play.mvc.Http.Context.Implicit.session;

/**
 * Created by MiHu on 21.1.2015.
 */
public class MyUserServicePlugin extends UserServicePlugin {

    public MyUserServicePlugin(Application app) {
        super(app);
    }

    @Override
    public Object save(AuthUser authUser) {
        userDataToSession(authUser);
        if (authUser instanceof OAuth2AuthUser) {
            final OAuth2AuthInfo authInfo = ((OAuth2AuthUser) authUser).getOAuth2AuthInfo();
            if (authInfo.getRefreshToken() != null) {
                new User(authUser.getId(), authInfo.getRefreshToken()).save();
            }
        }
        return authUser;
    }

    @Override
    public AuthUser update(final AuthUser knownUser) {
        userDataToSession(knownUser);
        if (knownUser instanceof OAuth2AuthUser) {
            final OAuth2AuthInfo authInfo = ((OAuth2AuthUser) knownUser).getOAuth2AuthInfo();
            if (authInfo.getRefreshToken() != null) {
                User u = User.find.ref(knownUser.getId());
                u.refreshToken = authInfo.getRefreshToken();
                u.update();
            }
        }
        return knownUser;
    }

    @Override
    public Object getLocalIdentity(AuthUserIdentity authUserIdentity) {
        return User.find.byId(authUserIdentity.getId());
    }

    @Override
    public AuthUser merge(AuthUser authUser, AuthUser authUser2) {
        return null;
    }

    @Override
    public AuthUser link(AuthUser authUser, AuthUser authUser2) {
        return null;
    }

    private void userDataToSession(AuthUser authUser) {
        if (authUser instanceof OAuth2AuthUser) {
            final String picture = ((GoogleAuthUser) authUser).getPicture();
            if (picture != null) {
                session().put("picture", picture);
            }
        }

        if (authUser instanceof NameIdentity) {
            final String name = ((NameIdentity) authUser).getName();
            if (name != null) {
                session().put("username", name);
            }
        }

        if (authUser instanceof OAuth2AuthUser) {
            final OAuth2AuthInfo authInfo = ((OAuth2AuthUser) authUser).getOAuth2AuthInfo();
            if (authInfo.getAccessToken() != null) {
                session().put("accessToken", authInfo.getAccessToken());
                session().put("lastUpdate", Long.toString(new Date().getTime()));
            }
        }
    }
}