import java.util.List;
import java.util.LinkedList;
//import org.apache.commons.lang3.math.NumberUtils;
/**
 * Example code (slightly modified) from  MITx: 6.005.1x Software Construction in Java 
 * 
 * @author MIT and Tibor
 * @version 0.01
 */
public class Hailstone
{
    // instance variables - replace the example below with your own
    private final List<Integer> list;

    /**
     * Constructor for objects of class Hailstone
     * Initialising Hailstone container as empty
     */
    public Hailstone()
    {
        list = new LinkedList<Integer>();
    }

    /**
     * Constructor for objects of class Hailstone initialising the sequence starting with an input number
     * @param startNum  Starting number in the hailstone sequence.  Assumes startNum > 0.
     * 
     */
    public Hailstone(final int startNum)
    {
        this();
        calculate(startNum);
    }
    
    /**
     * Constructor for objects of class Hailstone initialising the sequence starting with the number parsed from an input string.
     * @param inStr  Starting number as string in the hailstone sequence.  Assumes isNumeric(inStr).
     * 
     */
    public Hailstone(final String inStr)
    {
        this();
        assert(isNumeric(inStr));
        int startNum;
        double interNum = 1.0;
        try {
            startNum = Integer.parseInt(inStr);
        }catch(NumberFormatException e1) {
            System.out.println("Input (" + inStr + ") cannot be parsed as an Integer");
            try {
                interNum = Double.parseDouble(inStr);
                System.out.println("Casting it to Integer.");
            } catch(NumberFormatException e2) {
                System.out.println("Input (" + inStr + ") cannot be parsed as a Double");
                System.out.println("Changing value to 1");
            }
            startNum = (int)(interNum);
        }        
        calculate(startNum);
    }
    
    /**
     * Calculates the items of the hailstone sequence
     * @param startNum the number to start with, the first member of the sequence. Assumes num > 0.
     * 
     */
    public void calculate(final int startNum)
    {
        assert(startNum > 0);
        int num = startNum;
        while (num != 1) {
            list.add(num);
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = 3 * num + 1;
            }
        }
        list.add(num);
    }
    
    /**
     * Prints out the hailstone sequence.
     */
    public void print()
    {
        if (list.size() == 0)
            System.out.println("Empty list.");
        list.forEach(item->System.out.print(" " + item));
        System.out.println("");
    }
    
    /**
     * Finds the maximum element of the hailstone sequence
     * @return macimum element of the list
     */
    public int getMax()
    {
        int max = 0;
        for (int x : list) {
            max = Math.max(x, max);
        }
        return(max);
    }
    
    /**
     * Checks if an input string is numeric
     * @param s input string
     * @return true if numeric, false if not numeric 
     */
    private static boolean isNumeric(final String s)
    {
        if (!s.matches("[-+]?\\d*\\.?\\d+"))
        {
            System.err.println("Not a numeric input: " + s);
            return(false);
        } else
        return(true);  
    }
    
    /**
     * Checks command line input for valid starting numbers
     * @param argv input strings
     */
    public static void main(String[] argv)
    {
        if (argv.length > 0)
            for (String aNum : argv)
            {
                System.out.println("=====\n" + aNum + ":\n=====");
                Hailstone hs1 = new Hailstone(aNum);
                hs1.print();
                System.out.println("Max: " + hs1.getMax());
            }
    }
}
