package ua.pp.condor.students.servlet;

import ua.pp.condor.students.db.DatabaseConnector;
import ua.pp.condor.students.db.Mark;
import ua.pp.condor.students.db.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfessorServlet extends HttpServlet {

    private static final long serialVersionUID = -2091928511179840568L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setMark1(Mark.values()[Integer.parseInt(request.getParameter("mark1"))]);
        student.setMark2(Mark.values()[Integer.parseInt(request.getParameter("mark2"))]);
        try {
            String msg = DatabaseConnector.addStudent(student) ?
                    "Student successfully added to database" :
                    "Can not add student";
            request.setAttribute("msg", msg);
        } catch (IllegalStateException e) {
            request.setAttribute("msg", e.getMessage());
        }
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("marks", Mark.values());
        getServletContext()
                .getRequestDispatcher("/add.jsp").forward(request, response);
    }
}
