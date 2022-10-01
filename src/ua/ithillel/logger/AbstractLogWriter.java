package ua.ithillel.logger;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AbstractLogWriter {

    protected static String PROPERTIES_FILE = "./resources/logConfig.properties";

    protected static LoggerConfiguration LOGGER_CONFIG = new FileLoggerConfigurationLoader().loadConfig(PROPERTIES_FILE);
    protected static File sourceDir = LOGGER_CONFIG.FILE();
    protected static String fileFormat = LOGGER_CONFIG.FORMAT();
    protected static long maxFileSize = LOGGER_CONFIG.MAX_SIZE();
    protected static LoggingLevel loggingLevel = LOGGER_CONFIG.LOGGING_LEVEL();

    protected final String DATE = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy"));
    protected final String CURRENT_TIME = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    protected final String MESSAGE_TEMPLATE = "[%s_%s][%s]%s\n";


    public abstract void writeLog(String message);
}
