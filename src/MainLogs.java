import myr.edu.moroz.LogsService;
import myr.edu.moroz.MyThread;

/**
 * @author Antonina Moroz
 * @version 1.0.0
 * @project vsem 4
 * @class MainLogs
 * @since 14.04.2021 - 13.42
 **/

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class MainLogs {

    public static void main(String[] args) throws IOException {

        System.out.println("-------Method that finds all the ERROR logs and write them into a specific file-------");

    //develop a functionality to create 5 such a files for 5 different days.
        // Launch them in consistent way (one after another).

        LocalDateTime start = LocalDateTime.now();

        LocalDate date = LocalDate.of(2020, Month.AUGUST, 10);

        for (int i = 0; i < 5 ; i++) {

            LogsService.getLogsByDateToFile("C:\\Users\\User\\Desktop\\Java\\logs.txt", date.plusDays(i));
        }

        LocalDateTime finish = LocalDateTime.now();

        System.out.println(ChronoUnit.MILLIS.between(start, finish) + " MILLIS");

        //Repeat the above task in parallel way. Multi-threading.

        System.out.println("-------Multi-threading-------");

       start =LocalDateTime.now();

        for (int i = 0; i < 5; i++) {

           new MyThread (date.plusDays(i)).start();

        }
        finish =LocalDateTime.now();

    }
}

/*result:
-------Method that finds all the ERROR logs and write them into a specific file-------
28361 MILLIS         (+ 5 generated files from August 10 to 14 with errors)

-------Multi-threading------- (+ 5 generated files from August 10 to 14 with errors)

Thread-0 has been started at 2021-04-16T16:53:08.465
Thread-2 has been started at 2021-04-16T16:53:08.611
Thread-3 has been started at 2021-04-16T16:53:08.611
Thread-1 has been started at 2021-04-16T16:53:08.612
Thread-4 has been started at 2021-04-16T16:53:08.615
Thread-3 has been finished at 2021-04-16T16:53:13.247
Thread-3 Duration is 4636
Thread-0 has been finished at 2021-04-16T16:53:13.248
Thread-0 Duration is 4783
Thread-4 has been finished at 2021-04-16T16:53:13.258
Thread-4 Duration is 4643
Thread-1 has been finished at 2021-04-16T16:53:13.289
Thread-1 Duration is 4677
Thread-2 has been finished at 2021-04-16T16:53:13.300
Thread-2 Duration is 4689

So,each of the threads took about 4650 MILLIS,
but it took more than 4835 MILLIS to create 5 threads
from the beginning of the first to the end of the fifth.
In comparison with consistent way (one after another) which took 28361 MILLIS.

Conclusion: Using Multi-trends will help save processing time,
but determining the order is almost impossible.
 */