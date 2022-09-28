package ua.ithillel.logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoggerConfigurationLoader {

    public static LoggerConfiguration loadConfig(String path) {
        if (path == null) return null;

        File sourceDir = null;
        LoggingLevel loggingLevel = null;
        long maxFileSize = 0;
        String fileFormat = "";

        try (InputStream inputStream = new FileInputStream(path)) {
            Properties prop = new Properties();
            prop.load(inputStream);
            sourceDir = new File(prop.getProperty("FILE"));
            loggingLevel = LoggingLevel.valueOf(prop.getProperty("LEVEL"));
            maxFileSize = Long.parseLong(prop.getProperty("MAX-SIZE"));
            fileFormat = prop.getProperty("FORMAT");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LoggerConfiguration(sourceDir, loggingLevel, maxFileSize, fileFormat);
    }
}
