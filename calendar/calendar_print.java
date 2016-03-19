import java.text.DateFormatSymbols;
import java.util.*;
import java.util.regex.Pattern;
/**
 * Prints one month of a Gregorian Calendar
 * 
 * @author Gary Cornell (modified by Tibor)
 * @version 1.5 2014-08-10
 */
public class calendar_print
{
    /**
     * Constructor for objects of class calendar_print
     * (currently, without any function
     */
    public calendar_print() {}

    /**
     * program is a static one, not object oriented
     * 
     * @param  argv[0]
     * @return void
     */
    public static void main(String[] argv)
    {
	// setting the date to current date
	//Locale.setDefault(Locale.UK);
	Locale.setDefault(Locale.JAPAN);
	GregorianCalendar the_date = new GregorianCalendar();
	// if valid input is found, then argv[0]
	if (argv.length > 0) {
	    if (Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2}", argv[0])) {
		String[] date_strings = argv[0].split("-");
		int[] parsed_date = new int[3];
		for (int i = 0; i < 3; i++)
		    parsed_date[i] = Integer.parseInt(date_strings[i]);
		the_date = new GregorianCalendar(parsed_date[0],parsed_date[1]-1,parsed_date[2]);
	    } else {
		System.out.println("Wrong date format. Should be: YYYY-MM-DD (using numbers)");
		//System.exit(1);
		System.out.println("Current date is used.");
	    }
	} else {
	    System.out.println("Current date is used.");
	}
	System.out.println("Initialised to: " + the_date.getTime());

	int today = the_date.get(Calendar.DAY_OF_MONTH);
	int month = the_date.get(Calendar.MONTH);
 
	// set the date to the start date of the month
	the_date.set(Calendar.DAY_OF_MONTH,1);

	int weekday = the_date.get(Calendar.DAY_OF_WEEK);

	// get first day of week (typically, Sunday or Monday)
	int first_day_of_week = the_date.getFirstDayOfWeek();

	// determine the required indentation for the first line
	int indent = 0;
	while (weekday != first_day_of_week) {
	    indent++;
	    the_date.add(Calendar.DAY_OF_MONTH,-1);
	    weekday = the_date.get(Calendar.DAY_OF_WEEK);
	}

	// print out week number heading
	System.out.print("週 | ");
	// print weekday names
	String[] weekday_names = new DateFormatSymbols().getShortWeekdays();
	do {
	    System.out.printf("%3s",weekday_names[weekday]);
	    the_date.add(Calendar.DAY_OF_MONTH,1);
	    weekday = the_date.get(Calendar.DAY_OF_WEEK);
	} while (weekday != first_day_of_week);
	System.out.println();

	the_date.set(Calendar.DAY_OF_MONTH,1);
	int first_week_of_month = the_date.get(Calendar.WEEK_OF_YEAR);
	System.out.printf("%2s | ",first_week_of_month);
	for (int i = 1; i <= indent; i++)
	    System.out.print("    ");

	do {
	    int day = the_date.get(Calendar.DAY_OF_MONTH);
	    // week number is needed if first day of week and not first week of month
	    if (weekday == first_day_of_week && first_week_of_month != the_date.get(Calendar.WEEK_OF_YEAR))
		System.out.printf("%2s | ",the_date.get(Calendar.WEEK_OF_YEAR));
	    // start marker of today
	    if (day == today) 
		System.out.print("<");
	    else System.out.print(" ");

	    // print day
	    System.out.printf("%2d", day);

	    // end marker of today
	    if (day == today) 
		System.out.print(">");
	    else System.out.print(" ");

	    // advance the date to the next day
	    the_date.add(Calendar.DAY_OF_MONTH,1);
	    weekday = the_date.get(Calendar.DAY_OF_WEEK);

	    // start a new line at the start of the week
	    if (weekday == first_day_of_week)
		System.out.println();
	} while (the_date.get(Calendar.MONTH) == month);

	// print final end of line if necessary
	if (weekday != first_day_of_week)
	    System.out.println();
    }
}
