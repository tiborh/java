package date_time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

/**
 * Write a description of class tryConversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tryConversions
{
    public static void main(String[] argv)
    {
        System.out.println("LocalDate/LocalTime <-> LocalDateTime");

        LocalDate date = LocalDate.now();
        System.out.println("LocalDate.now(): " + date);
        LocalTime time = LocalTime.now();
        System.out.println("LocalTime.now(): " + time);
        LocalDateTime dateTimeFromDateAndTime = LocalDateTime.of(date, time);
        System.out.println("LocalDateTime.of(date,time): " + dateTimeFromDateAndTime);
        LocalDate dateFromDateTime = LocalDateTime.now().toLocalDate();
        System.out.println("LocalDateTime.now().toLocalDate(): " + dateFromDateTime);
        LocalTime timeFromDateTime = LocalDateTime.now().toLocalTime();
        System.out.println("LocalDateTime.now().toLocalTime(): " + timeFromDateTime);
        
        System.out.println("\nInstant <-> LocalDateTime");

        Instant instant = Instant.now();
        System.out.println("Instant.now(): " + instant);

        LocalDateTime dateTimeFromInstant = 
            LocalDateTime.ofInstant(instant, ZoneId.of("America/Los_Angeles"));
        System.out.println("LocalDateTime.ofInstant(instant, ZoneId.of(\"America/Los_Angeles\")" +
            dateTimeFromInstant);

        Instant instantFromDateTime = LocalDateTime.now().toInstant(ZoneOffset.ofHours(-2));
        System.out.println("LocalDateTime.now().toInstant(ZoneOffset.ofHours(-2)): " +
            instantFromDateTime);
        
        System.out.println("\nConvert old date/calendar/timezone classes");

        Instant instantFromDate = new Date().toInstant();
        System.out.println("new Date().toInstant(): " + instantFromDate);
        Instant instantFromCalendar = Calendar.getInstance().toInstant();
        System.out.println("Calendar.getInstance().toInstant(): " + instantFromCalendar);

        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println("TimeZone.getDefault().toZoneId(): " + zoneId);

        ZonedDateTime zonedDateTimeFromGregorianCalendar = 
            new GregorianCalendar().toZonedDateTime();
        System.out.println("new GregorianCalendar().toZonedDateTime(): " + 
            zonedDateTimeFromGregorianCalendar);

        System.out.println("\nConvert to old classes");

        Date dateFromInstant = Date.from(Instant.now());
        System.out.println("Date.from(Instant.now()): " + dateFromInstant);

        TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles"));
        System.out.println("TimeZone.getTimeZone(ZoneId.of(\"America/Los_Angeles\"): " +
            timeZone);

        GregorianCalendar gregorianCalendar = GregorianCalendar.from(ZonedDateTime.now());
        System.out.println("GregorianCalendar.from(ZonedDateTime.now()): " + 
            gregorianCalendar);
    }
}
