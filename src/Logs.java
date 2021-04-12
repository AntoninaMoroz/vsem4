import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author Antonina Moroz
 * @version 1.0.0
 * @project vsem 4
 * @class Logs
 * @since 09.04.2021 - 13.42
 **/
public class Logs {

    public static void main(String[] args) throws IOException {

        //String logs = new String(Files.readAllBytes(Paths.get("/Users/User/Desktop/Java/logs4.txt")));
        LocalDateTime start = LocalDateTime.now();

        Files.readAllLines(Paths.get("/Users/User/Desktop/Java/logs4.txt"))
                .stream().filter(line -> line.contains("ERROR")).count();

        LocalDateTime finish = LocalDateTime.now();

        System.out.println(ChronoUnit.MILLIS.between(start, finish));

    }
}
