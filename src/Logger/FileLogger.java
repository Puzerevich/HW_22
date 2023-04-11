package Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private final FileLoggerConfig fileLoggerConfiguration;
    private final String currentPath;

    public FileLogger(FileLoggerConfig fileLoggerConfiguration) {
        this.fileLoggerConfiguration = fileLoggerConfiguration;
        currentPath = fileLoggerConfiguration.getPath() + String.format("LoggingTest_%s.txt", getDateTimeNow());

    }

    public void info(String message) {
        writeLog(message);
        System.out.println(messageTemplate(message));
    }

    private void writeLog(String message) {
        try (BufferedWriter output = new BufferedWriter(new FileWriter(currentPath, true))) {
            output.write(messageTemplate(message));
            output.newLine();
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String messageTemplate(String message) {
        return String.format(fileLoggerConfiguration.getFormat(),
                "[" + getDateTimeNow() + "]",
                "[" + fileLoggerConfiguration.getLoggingLevel() + "]",
                "Message",
                "[" + message + "]"
        );
    }

    public String getDateTimeNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd hh-mm-ss");
        return now.format(formatter);
    }
}
