package date_time;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.OffsetDateTime;
import java.util.Set;

public class TimeZones
{
    public static void main(String[] argv)
    {
        ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
        System.out.println("ZoneId.of(\"America/Los_Angeles\"): " + losAngeles);
        ZoneId berlin = ZoneId.of("Europe/Berlin");
        System.out.println("ZoneId.of(\"Europe/Berlin\"): " + berlin);

        LocalDateTime dateTime = LocalDateTime.of(2014, 02, 20, 12, 0);
        System.out.println("Sample LocalDateTime: " + dateTime);

        ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, berlin);
        System.out.println("ZonedDateTime.of(dateTime, berlin): " + berlinDateTime);

        ZonedDateTime losAngelesDateTime = berlinDateTime.withZoneSameInstant(losAngeles);
        System.out.println("ZonedDateTime.of(dateTime, losAngeles): " + losAngelesDateTime);

        int offsetInSeconds = losAngelesDateTime.getOffset().getTotalSeconds(); // -28800
        System.out.println("losAngelesDateTime.getOffset().getTotalSeconds(): " + offsetInSeconds);

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();

        LocalDateTime date = LocalDateTime.of(2013, Month.JULY, 20, 3, 30);
        System.out.println("Starting from local datetime: " + date);

        ZoneOffset offset = ZoneOffset.of("+05:00");
        System.out.println("ZoneOffset.of(\"+05:00\"): " + offset);

        OffsetDateTime plusFive = OffsetDateTime.of(date, offset);
        System.out.println("OffsetDateTime.of(date, offset): " + plusFive);

        OffsetDateTime minusTwo = plusFive.withOffsetSameInstant(ZoneOffset.ofHours(-2));
        System.out.println("plusFive.withOffsetSameInstant(ZoneOffset.ofHours(-2)): " + minusTwo);
        
        System.out.println("\nA collection of all available zones");
        System.out.println("Set<String> allZoneIds = ZoneId.getAvailableZoneIds()");
        for(String aZone : allZoneIds)
            System.out.println("\t" + aZone);

    }
}
