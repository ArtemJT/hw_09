package ua.ithillel.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogWriter extends AbstractLogWriter {

    @Override
    public void writeLog(String message) {
        String fileName = String.format("Log_%s", DATE);
        String formattedMessage = String.format(MESSAGE_TEMPLATE, DATE, CURRENT_TIME, loggingLevel, message);

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
