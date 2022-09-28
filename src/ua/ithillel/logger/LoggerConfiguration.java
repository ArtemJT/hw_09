package ua.ithillel.logger;

import java.io.File;

public record LoggerConfiguration(File FILE, LoggingLevel LOGGING_LEVEL, long MAX_SIZE, String FORMAT) {
}
