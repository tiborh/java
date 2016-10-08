package dump;
import java.util.List;
import java.util.LinkedList;
/**
 * Write a description of class Hailstone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hailstone2
{
    // instance variables - replace the example below with your own
    private List<Integer> list;

    /**
     * Constructor for objects of class Hailstone
     */
    public Hailstone2()
    {
        list = new LinkedList<Integer>();
    }

    public Hailstone2(int startNum)
    {
        this();
        calculate(startNum);
    }
    
    public Hailstone2(String inStr)
    {
        this();
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
    
    public void calculate(int startNum)
    {
        while (startNum != 1) {
            list.add(startNum);
            if (startNum < 0) {
                System.out.println("Negative numbers are invalid input. Inverting input.");
                startNum = -startNum;
            } else if (startNum == 0) {
                System.out.println("Zero is an invalid input. Using 1 instead.");
                startNum = 1;
            } else if (startNum % 2 == 0) {
                startNum = startNum / 2;
            } else {
                startNum = 3 * startNum + 1;
            }
        }
        list.add(startNum);
    }
    
    public void print()
    {
        list.forEach(item->System.out.print(" " + item));
        System.out.println("");
    }
    
    public int getMax()
    {
        int max = 0;
        for (int x : list) {
            max = Math.max(x, max);
        }
        return(max);
    }
    
    public static void main(String[] argv)
    {
        if (argv.length > 0)
            for (String aNum : argv)
            {
                System.out.println("=====\n" + aNum + ":\n=====");
                Hailstone2 hs1 = new Hailstone2(aNum);
                hs1.print();
                System.out.println("Max: " + hs1.getMax());
            }
    }
}
