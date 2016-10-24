package date_time;

import static java.time.temporal.TemporalAdjusters.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;

public class tryTemporalAdjusters
{
    public static void main(String[] argv)
    {
        System.out.println("TemporalAdjusters, staticly imported");
        LocalDate date = LocalDate.of(2014, Month.FEBRUARY, 25);
        
        System.out.print("last day of 2014: ");
        LocalDate lastDayOfYear = date.with(lastDayOfYear());
        System.out.println("date.with(lastDayOfYear()): " + lastDayOfYear);
        DayOfWeek dayOfLastDay = date.getDayOfWeek();
        System.out.println("Day of that day: " + dayOfLastDay.name());

        System.out.print("first day of next month: ");
        LocalDate firstDayOfNextMonth = date.with(firstDayOfNextMonth());
        System.out.println("date.with(firstDayOfNextMonth()): " + firstDayOfNextMonth);

        System.out.print("next sunday: ");
        LocalDate nextSunday = date.with(next(DayOfWeek.SUNDAY));
        System.out.println("date.with(next(DayOfWeek.SUNDAY)): " + nextSunday);
    }
}
