package myr.edu.moroz;

/**
 * @author Antonina Moroz
 * @version 1.0.0
 * @project vsem 4
 * @class LogsService
 * @since 13.04.2021 - 16.55
 **/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

// Create a class that manages logs in this file.

public class LogsService {

    private String file;

    public LogsService() {
    }

    public LogsService(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    //Create a method that finds all the ERROR logs for a specific date
    // and write them into a specific file (name = ERROR  + Date  + .log)

    public static void getLogsByDateToFile(String file, LocalDate date) throws IOException {

        String dateAsString = date.toString();

        String str = "";

        StringBuilder sb = new StringBuilder(str);

        Files.lines(Paths.get(file))
                .filter(log -> log.contains(dateAsString))
                .filter(log -> log.contains("ERROR"))
                .forEach(log -> sb.append(log + '\n'));


        String fileOutput = "C:\\Users\\User\\Desktop\\Java" + "ERROR" + dateAsString + ".log";

        Files.write(Paths.get(fileOutput), sb.toString().getBytes());


    }

}
