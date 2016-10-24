package date_time;

import java.time.LocalDate;
import java.time.Period;

/**
 * Write a description of class DateTimePeriods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tryPeriods
{
    public static void main(String[] argv)
    {
        System.out.println("periods");

        LocalDate firstDate = LocalDate.of(2010, 5, 17); // 2010-05-17
        System.out.println("First date: " + firstDate);
        LocalDate secondDate = LocalDate.of(2015, 3, 7); // 2015-03-07
        System.out.println("Second date: " + secondDate);
        
        Period period = Period.between(firstDate, secondDate);
        System.out.println("Period.between(firstDate, secondDate): " + period);
        
        int days = period.getDays(); // 18
        System.out.println("period.getDays(): " + days);

        int months = period.getMonths(); // 9
        System.out.println("period.getMonths(): " + months);

        int years = period.getYears(); // 4
        System.out.println("period.getYears(): " + years);

        boolean isNegative = period.isNegative(); // false
        System.out.println("period.isNegative(): " + isNegative);

        Period twoMonthsAndFiveDays = Period.ofMonths(2).plusDays(5);
        System.out.println("Period.ofMonths(2).plusDays(5): " + twoMonthsAndFiveDays);

        LocalDate sixthOfJanuary = LocalDate.of(2014, 1, 6);
        System.out.println("Starting from LocalDate: " + sixthOfJanuary);
        
        LocalDate eleventhOfMarch = sixthOfJanuary.plus(twoMonthsAndFiveDays);
        System.out.println("sixthOfJanuary.plus(twoMonthsAndFiveDays): " + eleventhOfMarch);
    }
}
