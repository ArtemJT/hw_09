package ua.ithillel.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface LogWritable {

    String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yy"));
    String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    String messageTemplate = "[%s_%s][%s][%s]\n";

    void writeLog(String message);
}
