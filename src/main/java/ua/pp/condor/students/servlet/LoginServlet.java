package ua.pp.condor.students.servlet;

import logging.AuthorizationLogger;
import ua.pp.condor.students.db.DatabaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -4941061759303508333L;

    public static final String AUTH_SESSION_ATTRIBUTE = "auth";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (DatabaseConnector.checkProfessor(login, password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute(AUTH_SESSION_ATTRIBUTE, true);
            AuthorizationLogger.login(login);
            response.sendRedirect("/");
        } else {
            request.setAttribute("error", true);
            getServletContext()
                    .getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute(AUTH_SESSION_ATTRIBUTE) != null) {
            response.sendRedirect("/");
        } else {
            request.setAttribute("error", false);
            getServletContext()
                    .getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}
