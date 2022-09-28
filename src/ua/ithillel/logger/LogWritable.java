package ua.ithillel.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static ua.ithillel.logger.LoggerConfigurationLoader.loadConfig;

public interface LogWritable {

    String PROPERTIES_FILE = "src/ua/ithillel/resources/logConfig.properties";
    String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy"));
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    String messageTemplate = "[%s_%s][%s][%s]\n";
    LoggerConfiguration LOGGER_CONFIG = loadConfig(PROPERTIES_FILE);

    void writeLog(String message);
}
