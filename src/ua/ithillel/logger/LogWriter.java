package ua.ithillel.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LogWriter {

    static FileLoggerConfiguration config =
            FileLoggerConfigurationLoader.loadConfig("./src/ua/ithillel/logger/logConfig.txt");
    static File sourceDir = config.FILE();
    static String fileFormat = config.FORMAT();
    static long maxFileSize = config.MAX_SIZE();
    static LoggingLevel loggingLevel = config.LOGGING_LEVEL();

    public void writeLogIntoFile(String message) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy"));
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String fstName = String.format("Log_%s", date);
        String formattedMessage = String.format("[%s_%s][%s][%s]\n", date, currentTime, loggingLevel.name(), message);

        File logFile = new File(sourceDir, fstName + fileFormat);

        long currentSize = formattedMessage.length() + logFile.length();
        if (currentSize >= maxFileSize) {
            throw new FileMaxSizeReachedException(currentSize, maxFileSize);
        }

        try (FileWriter osWriter = new FileWriter(logFile, true)) {
            osWriter.write(formattedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
