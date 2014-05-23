package ua.pp.condor.students.db;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/students";

    private static final String USER = "postgres";
    private static final String PASS = "postgres";

    private static final Driver DRIVER = new Driver();

    static {
        try {
            DriverManager.registerDriver(DRIVER);
        } catch (SQLException e) {
            System.out.println("Can not register DB driver:");
            e.printStackTrace();
        }
    }

    public static boolean checkProfessor(String login, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1 FROM professor WHERE login = '" + login
                     + "' and password = '" + password + "'")) {

            return rs.next();
        } catch (SQLException e) {
            System.out.println("Can not checkProfessor:");
            e.printStackTrace();
        }
        return false;
    }

    private static List<Student> getStudents(String condition) {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, mark1, mark2 FROM student"
                + " WHERE " + condition)) {
            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString("name"));
                student.setMark1(Mark.values()[rs.getInt("mark1")]);
                student.setMark2(Mark.values()[rs.getInt("mark2")]);
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Can not getStudents:");
            e.printStackTrace();
        }
        return students;
    }

    public static List<Student> getAllStudents() {
        return getStudents("1=1");
    }

    public static List<Student> getExcellentStudents() {
        return getStudents("mark1 = " + Mark.A.ordinal()
                + " AND mark2 = " + Mark.A.ordinal());
    }

    public static List<Student> getUnsatisfactoryStudents() {
        return getStudents("mark1 = " + Mark.F.ordinal()
                + " OR mark2 = " + Mark.F.ordinal());
    }

    public static List<Student> getGeneralStudents() {
        return getStudents("mark1 < " + Mark.F.ordinal()
                + " AND  mark2 < " + Mark.F.ordinal()
                + " AND (mark1 > " + Mark.A.ordinal()
                        + " OR mark2 > " + Mark.A.ordinal() + ')');
    }
}
