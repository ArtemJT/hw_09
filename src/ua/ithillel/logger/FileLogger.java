package ua.ithillel.logger;

public class FileLogger extends LogWriter {

    public static FileLogger getLogger() {
        if (sourceDir.mkdirs()) System.out.println("Log's catalog created");

        FileLogger logger = new FileLogger();
        switch (loggingLevel) {
            case DEBUG: {
                logger.debug("DEBUG MESSAGE");
                loggingLevel = LoggingLevel.INFO;
            }
            case INFO: logger.info("INFO MESSAGE");
        }
        return logger;
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
