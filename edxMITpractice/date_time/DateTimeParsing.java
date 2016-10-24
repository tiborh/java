package date_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Write a description of class DateTimeParsing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DateTimeParsing
{
    public static void main(String[] argv)
    {
        System.out.println("parsing date strings:");
        String isoStr = "2014-01-20";
        System.out.println("ISO string: " + isoStr);
        LocalDate fromIsoDate = LocalDate.parse(isoStr);
        System.out.println("LocalDate.parse(isoStr): " + fromIsoDate);

        String isoWeekDayStr = "2014-W14-2";
        System.out.println("ISO string 2: " + isoWeekDayStr);
        LocalDate fromIsoWeekDate = LocalDate.parse(isoWeekDayStr, DateTimeFormatter.ISO_WEEK_DATE);
        System.out.println("LocalDate.parse(, DateTimeFormatter.ISO_WEEK_DATE): " + fromIsoWeekDate);

        String germanStr = "20.01.2014";
        System.out.println("German short: " + germanStr);
        LocalDate fromCustomPattern = LocalDate.parse(germanStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("LocalDate.parse(germanStr, DateTimeFormatter.ofPattern(\"dd.MM.yyyy\")): " + fromCustomPattern);
    }
}
