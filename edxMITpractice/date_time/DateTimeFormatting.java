package date_time;

import java.time.Month;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Write a description of class tryFormatting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DateTimeFormatting
{
    public static void main(String[] argv)
    {
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.APRIL, 1, 10, 45);
        System.out.println("dateTime: " + dateTime);
        
        String asBasicIsoDate = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("dateTime.format(DateTimeFormatter.BASIC_ISO_DATE): " + asBasicIsoDate);

        String asIsoWeekDate = dateTime.format(DateTimeFormatter.ISO_WEEK_DATE);
        System.out.println("dateTime.format(DateTimeFormatter.ISO_WEEK_DATE): " + asIsoWeekDate);

        String asIsoDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("dateTime.format(DateTimeFormatter.ISO_DATE_TIME): " + asIsoDateTime);

        String asCustomPattern = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("dateTime.format(DateTimeFormatter.ofPattern(\"dd/MM/yyyy\")): " + 
            asCustomPattern);

        String frenchDate = dateTime.format(DateTimeFormatter.ofPattern("d. MMMM yyyy", 
            new Locale("fr")));
        System.out.println("dateTime.format(DateTimeFormatter.ofPattern(\"d. MMMM yyyy\", " +
            "new Locale(\"fr\")): " + frenchDate);

        DateTimeFormatter formatter = 
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("de"));
        System.out.println("Setting up formatter");
        System.out.println("DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)" +
            ".withLocale(new Locale(\"de\"))");

        String germanDateTime = dateTime.format(formatter);
        System.out.println("Using formatter: " + dateTime.format(formatter));
    }
}
