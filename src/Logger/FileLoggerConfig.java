package Logger;

public class FileLoggerConfig {
    private final LoggingLevel loggingLevel = LoggingLevel.INFO;
    private final String format = "%s %s %s %s";
    private final String path = ".src\\Logger\\LogFiles\\logging_test_files\\";

    public String getPath() {
        return path;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public String getFormat() {
        return format;
    }
}
