package ua.ithillel.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileLoggerConfigurationLoader implements LoggerConfigurationLoader {

    @Override
    public LoggerConfiguration loadConfig(String path) {
        if (path == null) return null;

        File sourceDir = null;
        LoggingLevel loggingLevel = null;
        long maxFileSize = 0;
        String fileFormat = "";

        try (InputStream inputStream = new FileInputStream(path)) {
            Properties prop = new Properties();
            prop.load(inputStream);
            sourceDir = new File(prop.getProperty(FILE));
            String lvlProp = prop.getProperty(LEVEL);
            loggingLevel = !lvlProp.isEmpty() ? LoggingLevel.valueOf(lvlProp) : LoggingLevel.INFO;
            maxFileSize = Long.parseLong(prop.getProperty(MAX_SIZE));
            fileFormat = prop.getProperty(FORMAT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LoggerConfiguration(sourceDir, loggingLevel, maxFileSize, fileFormat);
    }
}
