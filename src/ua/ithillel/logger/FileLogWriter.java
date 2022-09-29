package ua.ithillel.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogWriter implements LogWritable {

    protected static String PROPERTIES_FILE = "src/ua/ithillel/resources/logConfig.properties";
    protected static LoggerConfiguration LOGGER_CONFIG = new FileLoggerConfigurationLoader().loadConfig(PROPERTIES_FILE);

    protected static File sourceDir = LOGGER_CONFIG.FILE();
    protected static String fileFormat = LOGGER_CONFIG.FORMAT();
    protected static long maxFileSize = LOGGER_CONFIG.MAX_SIZE();
    protected static LoggingLevel loggingLevel = LOGGER_CONFIG.LOGGING_LEVEL();


    @Override
    public void writeLog(String message) {
        String fileName = String.format("Log_%s", date);
        String formattedMessage = String.format(messageTemplate, date, currentTime, loggingLevel, message);

        File[] fileList = sourceDir.listFiles();
        int count = 0;
        File logFile;
        if ((fileList != null ? fileList.length : 0) > 0) {
            count = fileList.length;
            logFile = fileList[count - 1];
        } else {
            logFile = new File(sourceDir, fileName + fileFormat);
        }

        if (formattedMessage.length() + logFile.length() >= maxFileSize) {
            logFile = new File(sourceDir, String.format("%s_%s%s", fileName, count, fileFormat));
        }

        try (FileWriter osWriter = new FileWriter(logFile, true)) {
            osWriter.write(formattedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
