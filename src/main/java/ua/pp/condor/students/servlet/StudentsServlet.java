package ua.pp.condor.students.servlet;

import ua.pp.condor.students.db.DatabaseConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentsServlet extends HttpServlet {

    private static final long serialVersionUID = -3190091829093139724L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("excellentStudents",
                DatabaseConnector.getExcellentStudents());
        request.setAttribute("unsatisfactoryStudents",
                DatabaseConnector.getUnsatisfactoryStudents());
        request.setAttribute("generalStudents",
                DatabaseConnector.getGeneralStudents());

        getServletContext()
                .getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
