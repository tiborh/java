import java.text.DateFormatSymbols;
import java.util.*;
import java.util.regex.Pattern;
/**
 * just to fool around with calendar functions
 * 
 * @author Tibor
 * @version 0.1 2014-08-10
 */
public class calendar_test
{
    /**
     * Constructor for objects of class calendar_print
     * (currently, without any function
     */
    public calendar_test() {}

    /**
     * program is a static one, not object oriented
     * 
     * @param  args[0]
     * @return void
     */
    public static void main(String[] args)
    {
	if (args.length == 0)
	    System.out.println("You can specify date. eg 2014-08-10");
	else {
	    System.out.println("Num of args: " + args.length);
	    for (String an_arg : args)
		System.out.printf("\t%s\n",an_arg);
	    // if (args[0].length() >= 8) {
	    // 	System.out.println("args[0]: " + args[0]);
	    // 	System.out.printf("%c %c %c\n",args[0].charAt(4),args[0].charAt(6),args[0].charAt(7));
	    // 	if (args[0].charAt(4) == '-' && (args[0].charAt(6) == '-' || args[0].charAt(7) == '-'))
	    // 	    System.out.println("Seems to be a valid date.");
	    // 	else
	    // 	    System.out.println("Does not seem to be a valid date.");
	    
	    if (Pattern.matches("\\d{4}-\\d{1,2}-\\d{1,2}", args[0])) {
		System.out.println("Date pattern has matched.");
		String[] date_strings = args[0].split("-");
		int[] parsed_date = new int[3];
		for (int i = 0; i < 3; i++)
		    parsed_date[i] = Integer.parseInt(date_strings[i]);
		System.out.printf("Parsed date: %d/%d/%d (d/m/yyyy)\n",parsed_date[2],parsed_date[1],parsed_date[0]);
		// another possible way could be:
		// Pattern p = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
		// Matcher m = p.matcher(args[0]);
		// m.group(1) and m.group(2) and m.group(3) have the values
	    }
	    else
		System.out.println("Date pattern has not matched.");
	    // }
	}
    }
}
