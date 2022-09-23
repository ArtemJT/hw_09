package ua.ithillel.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration loadConfig(String path) {

        if (path == null) return null;

        File filesDir = null;
        LoggingLevel loggingLevel = null;
        long size = 0;
        String format = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String input = reader.readLine();
                if (input.contains("FILE")) {
                    filesDir = new File(input.replaceAll("FILE: ", ""));
                }
                if (input.contains("DEBUG")) {
                    loggingLevel = LoggingLevel.DEBUG;
                }
                if (input.contains("INFO")) {
                    loggingLevel = LoggingLevel.INFO;
                }
                if (input.contains("MAX-SIZE")) {
                    try {
                        size = Integer.parseInt(input.replaceAll("MAX-SIZE: ", ""));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                if (input.contains("FORMAT")) {
                    format = input.replaceAll("FORMAT: ", "");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileLoggerConfiguration(filesDir, loggingLevel, size, format);
    }
}
