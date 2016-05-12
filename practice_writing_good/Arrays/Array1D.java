package Arrays;

import java.util.Random;
/**
 * Write a description of class Array1D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Array1D
{
    private int minL = 5;
    private int maxL = 10;
    private int maxnum = 100;
    protected int[] theArray;
    protected int theLength;

    Array1D()
    {
        theLength = (int)((maxL - minL)*Math.random())+minL+1;
        theArray = new int[theLength];
    }

    void fill()
    {
        Random randomGenerator = new Random();
        for (int i = 0; i < theLength; ++i)
            theArray[i] = randomGenerator.nextInt(maxnum);
    }

    public int findMax()
    {
        int theMax = theArray[0];

        for (int i = 1; i < theLength; ++i)
            if (theArray[i] > theMax)
                theMax = theArray[i];

        return theMax;
    }

    public int findMin()
    {
        int theMin = theArray[0];

        for (int i = 1; i < theLength; ++i)
            if (theArray[i] < theMin)
                theMin = theArray[i];

        return theMin;
    }

    public int findMaxIndex()
    {
        int theMaxIndex = 0;

        for (int i = 1; i < theLength; ++i)
            if (theArray[i] > theArray[theMaxIndex])
                theMaxIndex = i;

        return theMaxIndex;     
    }

    public int findMinIndex()
    {
        int theMinIndex = 0;

        for (int i = 1; i < theLength; ++i)
            if (theArray[i] < theArray[theMinIndex])
                theMinIndex = i;

        return theMinIndex;     
    }

    public String toString()
    {
        String printStr = "";
        for (int i : theArray)
            printStr += i + " ";

        return printStr;
    }

    /** in Array1D */
    public static void main(String[] argv)
    {
        for (int i = 0; i < 10; ++i)
        {
            Array1D testarr = new Array1D();
            testarr.fill();
            System.out.println(testarr);
            System.out.println("\t min: " + testarr.findMin() 
                             + "\t min index: " + testarr.findMinIndex());
            System.out.println("\t max: " + testarr.findMax() 
                             + "\t max index: " + testarr.findMaxIndex());            
        }
    }
}
