package ua.ithillel.logger;

public enum LoggingLevel {

    INFO("[INFO MESSAGE]"),
    DEBUG(INFO.getMessage() + "[DEBUG MESSAGE]");

    private final String message;

    LoggingLevel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
