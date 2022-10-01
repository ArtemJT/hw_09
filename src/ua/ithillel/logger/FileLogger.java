package ua.ithillel.logger;

public class FileLogger extends FileLogWriter {

    public static FileLogger getLogger() {
        if (sourceDir.mkdirs()) System.out.println("Log's catalog created");

        FileLogger logger = new FileLogger();
        final String logMessage = loggingLevel.getMessage();
        switch (loggingLevel) {
            case DEBUG -> logger.debug(logMessage);
            case INFO -> logger.info(logMessage);
        }
        return logger;
    }

    public void debug(String message) {
        System.out.println("DEBUG LOGGING");
        writeLog(message);
    }

    public void info(String message) {
        System.out.println("INFO LOGGING");
        writeLog(message);
    }
}
