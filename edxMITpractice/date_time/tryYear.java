package date_time;

import java.time.Year;
import java.time.LocalDate;

public class tryYear
{
    public static void main(String[] argv)
    {
        Year currentYear = Year.now();
        System.out.println("Year.now(): " + currentYear);
        Year twoThousand = Year.of(2000);
        System.out.println("Year.of(2000): " + twoThousand);
        boolean isLeap = currentYear.isLeap(); // false
        System.out.println(".isLeap() for current: " + isLeap);
        int length = currentYear.length(); // 365
        System.out.println(".length() of current: " + length);
        // sixtyFourth day of 2014 (2014-03-05)
        LocalDate date = Year.of(2014).atDay(64);
        System.out.println("Year.of(2014).atDay(64): " + date);
    }
}
