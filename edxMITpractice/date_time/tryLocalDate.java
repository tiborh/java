package date_time;

import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import org.apache.commons.lang3.StringUtils;
import java.time.temporal.TemporalAdjusters;

/**
 * Write a description of class tryLocalDate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tryLocalDate
{
    public static void main(String[] argv)
    {
        // the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date (LocalDate.now()): " + currentDate);
        System.out.print("Printing dates (with printDate): ");

        // 2014-02-10
        LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);
        System.out.println("A date as LocalDate.of(2014, Month.FEBRUARY, 10): " + tenthFeb2014);

        // months values start at 1 (2014-08-01)
        LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);
        System.out.println("Another input format LocalDate.of(2014, 8, 1): " + firstAug2014);

        // the 65th day of 2010 (2010-03-06)
        LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);
        System.out.println("Date with yearday (LocalDate.ofYearDay(2010, 65)): " + sixtyFifthDayOf2010);

        LocalDate date = LocalDate.of(2014, 2, 15); // 2014-06-15
        System.out.println("Working with date: " + date);
        boolean isBefore = LocalDate.now().isBefore(date); // false
        System.out.println("Check if before (LocalDate.now().isBefore(date)): " + isBefore);

        System.out.println("\nInformation about the month (working with (date.getMonth() " +
            "as Month february)");
        Month february = date.getMonth(); // FEBRUARY
        int februaryIntValue = february.getValue(); // 2
        System.out.println("The value of the month (february.getValue()): " + februaryIntValue);

        int minLength = february.minLength(); // 28
        System.out.println("Mininum length (february.minLength()): " + minLength);

        int maxLength = february.maxLength(); // 29
        System.out.println("Maximum length (february.maxLength()): " + maxLength);

        Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY
        System.out.println("First month of quarter (february.firstMonthOfQuarter()): " +
            firstMonthOfQuarter);

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println("Add a day: LocalDate.now().plusDays(1): " + tomorrow);

        System.out.println("\nInformation about the year");
        int year = date.getYear(); // 2014
        System.out.println("date.getYear(): " + year);
        int dayOfYear = date.getDayOfYear(); // 46
        System.out.println("date.getDayOfYear(): " + dayOfYear);
        int lengthOfYear = date.lengthOfYear(); // 365
        System.out.println("date.lengthOfYear(): " + lengthOfYear);
        boolean isLeapYear = date.isLeapYear(); // false
        System.out.println("date.isLeapYear(): " + isLeapYear);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("date.getDayOfWeek(): " + dayOfWeek);
        int dayOfWeekIntValue = dayOfWeek.getValue(); // 6
        System.out.println("dayOfWeek.getValue(): " + dayOfWeekIntValue);
        String dayOfWeekName = dayOfWeek.name(); // SATURDAY
        System.out.println("dayOfWeek.name(): " + StringUtils.capitalize(dayOfWeekName.toLowerCase()));
        String output = dayOfWeekName.substring(0, 1).toUpperCase() + 
            dayOfWeekName.substring(1).toLowerCase();
        System.out.println("Converted with built-in methods: " + output);
        int dayOfMonth = date.getDayOfMonth(); // 15
        System.out.println("date.getDayOfMonth(): " + dayOfMonth);

        System.out.println("\nWith TemporalAdjusters");
        LocalDate date2 = LocalDate.of(2014, Month.FEBRUARY, 25); // 2014-02-25

        System.out.print("first day of February 2014: ");
        LocalDate firstDayOfMonth = date2.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("date.with(TemporalAdjusters.firstDayOfMonth()): " +
            firstDayOfMonth);

        System.out.print("Last day of February 2014: ");
        LocalDate lastDayOfMonth = date2.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("date.with(TemporalAdjusters.lastDayOfMonth()): " +
            lastDayOfMonth);

    }
}
