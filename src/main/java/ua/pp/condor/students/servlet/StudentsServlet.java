package ua.pp.condor.students.servlet;

import ua.pp.condor.students.db.DatabaseConnector;
import ua.pp.condor.students.db.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = DatabaseConnector.getStudents();
        request.setAttribute("students", students);
        getServletContext()
                .getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
