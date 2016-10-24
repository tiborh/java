package date_time;

import java.time.LocalDateTime;
import java.time.Month;

public class tryLocalDateTime
{
    public static void main(String[] argv) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current DateTime (LocalDateTime.now()): " + currentDateTime);

        // 2014-10-02 12:30
        LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);
        System.out.println("Another Date and Time (LocalDateTime.of(2014, 10, 2, 12, 30)): " +
            secondAug2014);

        // 2014-12-24 12:00
        LocalDateTime xmas2014 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);
        System.out.println("Christmas of 2014 (LocalDateTime.of(2014, Month.DECEMBER, 25, 12, 0)): " +
            xmas2014);

        LocalDateTime dateTime = LocalDateTime.now().minusHours(5).minusMinutes(30);
        System.out.println("Substract some time from now: " 
            + "LocalDateTime.now().minusHours(5).minusMinutes(30):\n\t"
            + dateTime);
    }
}
