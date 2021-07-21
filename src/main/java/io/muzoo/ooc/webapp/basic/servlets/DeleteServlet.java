package io.muzoo.ooc.webapp.basic.servlets;

import io.muzoo.ooc.webapp.basic.AbstractRoutableHttpServlet;
import io.muzoo.ooc.webapp.basic.security.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteServlet extends AbstractRoutableHttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (securityService.isAuthorized(request)) {
            String username = securityService.getCurrentUsername(request);
            String toDelete = request.getParameter("username");
            if (username.equals(toDelete)) {
                request.setAttribute("currentUser", userService.getUser(username));
                String error = "Cannot remove your own account";
                request.setAttribute("error", error);
                List<User> users =  userService.getUsers();
                request.setAttribute("users", users);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/user.jsp");
                requestDispatcher.include(request, response);
                return;
            }
            userService.removeUser(toDelete);
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    public String getPattern() {
        return "/delete";
    }
}
