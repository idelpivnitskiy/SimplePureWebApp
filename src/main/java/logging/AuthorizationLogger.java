package logging;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;

public class AuthorizationLogger {

    private static final String LOG_FILE = "auth.log";

    private static final Path LOG_PATH = Paths.get(LOG_FILE);

    private AuthorizationLogger() {
    }

    public static void login(String login) {
        if (login == null) {
            throw new NullPointerException("login can not be null");
        }
        if (login.trim().isEmpty()) {
            throw new IllegalArgumentException("login can not be empty");
        }
        try (BufferedWriter writer = Files.newBufferedWriter(LOG_PATH,
                StandardCharsets.UTF_8, StandardOpenOption.WRITE,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            Calendar now = Calendar.getInstance();
            String msg = now.getTime() + ": Professor '" + login
                    + "' successfully login to system\n";
            writer.write(msg);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error while logging auth information:");
            e.printStackTrace();
        }
    }

}
