package date_time;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.Clock;

public class tryLocalTime
{
    public static void main(String[] argv)
    {
        LocalTime currentTime = LocalTime.now(); // current time
        System.out.println("Current time (LocalTime.now()): " + currentTime);

        LocalTime midday = LocalTime.of(12, 0); // 12:00
        System.out.println("Another time (LocalTime.of(12, 0)): " + midday);

        LocalTime afterMidday = LocalTime.of(13, 30, 15); // 13:30:15
        System.out.println("complete with seconds (LocalTime.of(13, 30, 15)): " + afterMidday);

        // 12345th second of day (03:25:45)
        LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);
        System.out.println("determined with dayseconds (LocalTime.ofSecondOfDay(12345)): " + 
            fromSecondsOfDay);

        // current (local) time in Los Angeles
        LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("Time in LA (LocalTime.now(ZoneId.of(\"America/Los_Angeles\"))): " +
            currentTimeInLosAngeles); 

        // current time in UTC time zone
        LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());
        System.out.println("Universal Time (LocalTime.now(Clock.systemUTC())): " + nowInUtc);

        System.out.println("\nTime information");
        LocalTime time = LocalTime.of(15, 30); // 15:30:00
        System.out.println("working with: " + time);
        int hour = time.getHour(); // 15
        System.out.println("time.getHour(): " + hour);
        int second = time.getSecond(); // 0
        System.out.println("time.getSecond(): " + second);
        int minute = time.getMinute(); // 30
        System.out.println("time.getMinute(): " + minute);
        int secondOfDay = time.toSecondOfDay(); // 55800
        System.out.println("time.toSecondOfDay(): " + secondOfDay);
    }
}
