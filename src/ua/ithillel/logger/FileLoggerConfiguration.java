package ua.ithillel.logger;

import java.io.File;

public record FileLoggerConfiguration(File FILE, LoggingLevel LOGGING_LEVEL, long MAX_SIZE, String FORMAT) {
}
