package ua.pp.condor.students.servlet;

import ua.pp.condor.students.db.DatabaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 6532031168994475289L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute(LoginServlet.AUTH_SESSION_ATTRIBUTE) != null) {
            session.removeAttribute(LoginServlet.AUTH_SESSION_ATTRIBUTE);
            session.invalidate();
            getServletContext()
                    .getRequestDispatcher("/logout.jsp").forward(request, response);
        } else {
            response.sendRedirect("/");
        }
    }

}
