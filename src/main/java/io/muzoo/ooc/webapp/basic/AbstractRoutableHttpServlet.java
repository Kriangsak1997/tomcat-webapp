package io.muzoo.ooc.webapp.basic;

import io.muzoo.ooc.webapp.basic.security.SecurityService;
import io.muzoo.ooc.webapp.basic.security.UserService;

import javax.servlet.http.HttpServlet;

public abstract class AbstractRoutableHttpServlet extends HttpServlet implements Routable {

    protected SecurityService securityService;
    protected UserService userService;

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
