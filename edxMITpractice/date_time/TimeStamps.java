package date_time;

import java.time.Instant;

public class TimeStamps
{
    public static void main(String[] argv)
    {
        Instant now = Instant.now();
        System.out.println("current time: Instant.now(): " + now);

        long unixTimestamp = Instant.now().getEpochSecond();
        System.out.println("unix seconds: Instant.now().getEpochSecond(): " + unixTimestamp);
        
        Instant fromUnixTimestamp = Instant.ofEpochSecond(unixTimestamp);
        System.out.println("from unix timestamp: Instant.ofEpochSecond(unixTimestamp): " +
            fromUnixTimestamp);

        long unixTime = System.currentTimeMillis();
        System.out.println("unix milliseconds: System.currentTimeMillis(): " + unixTime);
        
        Instant fromEpochMilli = Instant.ofEpochMilli(unixTime);
        System.out.println("same time in millis: Instant.ofEpochMilli(unixTime): " + fromEpochMilli);

        String inputStr = fromEpochMilli.toString();
        Instant fromIso8601 = Instant.parse(inputStr);
        System.out.println("parsing from ISO 8601: Instant.parse(inputStr): " + fromIso8601);       

        String toIso8601 = now.toString();
        System.out.println("now.toString(): " + toIso8601);

        long toEpochMillis = now.toEpochMilli();
        System.out.println("now.toEpochMilli(): " + toEpochMillis);

        Instant nowPlusTenSeconds = now.plusSeconds(10);
        System.out.println("plus and minus also work: now.plusSeconds(10): " + nowPlusTenSeconds);
    }
}
