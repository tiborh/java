package date_time;

import java.time.Instant;
import java.time.Duration;

/**
 * Write a description of class tryDurations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tryDurations
{
    public static void main(String[] argv)
    {
        System.out.println("durations");

        Instant firstInstant= Instant.ofEpochSecond( 1294881180 ); // 2011-01-13 01:13
        System.out.println("First Instant: Instant.ofEpochSecond(1294881180): " + firstInstant);
        Instant secondInstant = Instant.ofEpochSecond(1294708260); // 2011-01-11 01:11
        System.out.println("Second Instant: Instant.ofEpochSecond(1294708260): " + secondInstant);

        Duration between = Duration.between(firstInstant, secondInstant);
        System.out.println("Duration.between(firstInstant, secondInstant): " + between);

        long seconds = between.getSeconds();
        System.out.println("between.getSeconds(): " + seconds);

        long absoluteResult = between.abs().toMinutes();
        System.out.println("between.abs().toMinutes(): " + absoluteResult);

        long twoHoursInSeconds = Duration.ofHours(2).getSeconds();
        System.out.println("Duration.ofHours(2).getSeconds(): " + twoHoursInSeconds);
    }
}
