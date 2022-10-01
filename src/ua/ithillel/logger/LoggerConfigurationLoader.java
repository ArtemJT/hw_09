package ua.ithillel.logger;

public interface LoggerConfigurationLoader {

    String FILE = "FILE";
    String LEVEL = "LEVEL";
    String MAX_SIZE = "MAX-SIZE";
    String FORMAT = "FORMAT";

    LoggerConfiguration loadConfig(String path);
}
