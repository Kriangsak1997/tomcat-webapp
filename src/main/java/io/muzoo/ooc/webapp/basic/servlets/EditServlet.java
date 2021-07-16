package io.muzoo.ooc.webapp.basic.servlets;

import io.muzoo.ooc.webapp.basic.security.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends AbstractRoutableHttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (securityService.isAuthorized(request)) {
            String username = request.getParameter("username");
            User currentUser = userService.getUser(username);
            request.setAttribute("currentUser", currentUser);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/edit.jsp");
            requestDispatcher.include(request, response);
        } else {
            response.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String display_name = request.getParameter("display_name");
        userService.editUser(username, password, display_name);
        response.sendRedirect("/user");
    }

    @Override
    public String getPattern() {
        return "/edit";
    }
}
