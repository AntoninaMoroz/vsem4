package myr.edu.moroz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1. Parse the file logs.txt.  Extract to a separate file all the logs.

        System.out.println( "---- Use String.split ----");

        LocalDateTime start = LocalDateTime.now();

        String logs = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\Desktop\\Java\\logs.txt")));

        //2. Calculate the total number of logs (lines).

        final String[] lines = logs.split("\n");

        System.out.println("The total number of logs: " + lines.length);

        // 3. Calculate the total  number of  ERROR logs. Use previous skills - String.split

        int counter = 0;

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("ERROR"))
                counter++;
        }

        System.out.println("NUMBER OF ERRORS: " + counter);

        LocalDateTime finish = LocalDateTime.now();

        System.out.println("Duration using String.split: " + ChronoUnit.MILLIS.between(start, finish));

       // 4.  Calculate the total number of ERROR logs. Use Files.lines. (2 ways)

        System.out.println( "\n ---- Use Files.lines ----");

        // Way 1

       start = LocalDateTime.now();

        System.out.println("\n Way 1 "+ "\n NUMBER OF ERRORS: " + Files.readAllLines(Paths.get("C:\\Users\\User\\Desktop\\Java\\logs.txt"))
                .stream().filter(line -> line.contains("ERROR")).count());

        finish = LocalDateTime.now();

        System.out.println("Duration " + ChronoUnit.MILLIS.between(start, finish));

     // Way 2

        start = LocalDateTime.now();

        final List<String> linesList = Files.readAllLines(Paths.get("C:\\Users\\User\\Desktop\\Java\\logs.txt"));

        System.out.println("\n Way 2 "+ "\n NUMBER OF ERRORS: " + linesList.stream().filter(line -> line.contains("ERROR")).count());

        finish = LocalDateTime.now();

        System.out.println("Duration " + ChronoUnit.MILLIS.between(start, finish));

        // 5. Compare two results.

 /* results

 ---- Use String.split ----

The total number of logs: 2845607
NUMBER OF ERRORS: 361
Duration using String.split: 163142

 ---- Use Files.lines ----

 Way 1
 NUMBER OF ERRORS: 361
Duration 137352

 Way 2
 NUMBER OF ERRORS: 361
Duration 112045

 So,for this example, it is better to use Files.lines
 because it takes less time and less computer memory.
  */

    }
}


