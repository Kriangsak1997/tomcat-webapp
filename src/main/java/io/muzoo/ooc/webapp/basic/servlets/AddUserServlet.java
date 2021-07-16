package io.muzoo.ooc.webapp.basic.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends AbstractRoutableHttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = request.getParameter("error");
        request.setAttribute("error", error);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/add_user.jsp");
        requestDispatcher.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (securityService.isAuthorized(request)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String display_name = request.getParameter("display_name");
            if (!userService.checkIfUserExists(username)) {
                userService.addUser(username, password, display_name);
                response.sendRedirect("/");
            } else {
                String e = "Username already existed";
                request.setAttribute("error", e);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/add_user.jsp");
                requestDispatcher.include(request, response);
            }
        } else {
            response.sendRedirect("/user");
        }
    }

    @Override
    public String getPattern() {
        return "/add_user";
    }

}
