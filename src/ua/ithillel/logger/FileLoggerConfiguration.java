package ua.ithillel.logger;

import java.io.File;

public record FileLoggerConfiguration(File FILE, LoggingLevel LOGGING_LEVEL, int MAX_SIZE, String FORMAT) {
}
