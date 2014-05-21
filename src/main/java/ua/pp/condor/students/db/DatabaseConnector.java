package ua.pp.condor.students.db;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
