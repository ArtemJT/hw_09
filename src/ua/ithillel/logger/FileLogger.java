package ua.ithillel.logger;

public class FileLogger implements Loggable {

    public static void getLogger() {
        if (sourceDir.mkdirs()) System.out.println("Log's catalog created");

        switch (loggingLevel) {
            case DEBUG -> new FileLogger().debug("DEBUG MESSAGE");
            case INFO -> new FileLogger().info("INFO MESSAGE");
        }
    }

    public void debug(String message) {
        System.out.println("DEBUG LOGGING");
        writeLogIntoFile(message);
    }

    public void info(String message) {
        System.out.println("INFO LOGGING");
        writeLogIntoFile(message);
    }
}
