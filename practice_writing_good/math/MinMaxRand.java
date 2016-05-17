package math;

/**
 * Write a description of class MinMaxRand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinMaxRand
{
    // random value
    private double rval;

    /**
     * Constructor for objects of class MinMaxRand
     */
    public MinMaxRand()
    {
        rval = (double)(Math.round(Math.random()*100))/100;
    }
    
    public MinMaxRand(double min, double max)
    {
        rval = (double)(Math.round((Math.random() * (max - min) + min)*100))/100;
    }

    public double getVal() { return rval; }
    public String toString() { return "" + rval; }
        
    /** 
     * argv[0]: how many numbers?
     * argv[1]: minimum value
     * argv[2]: maximum value
     */
    public static void main(String[] argv)
    {
        int num = (argv.length == 0) ? 10 : Integer.parseInt(argv[0]);
        double minVal = 1.0;
        double maxVal = 10.0;
        if ( argv.length == 3 )
        {
            minVal = Integer.parseInt(argv[1]);
            maxVal = Integer.parseInt(argv[2]);
        }
        
        MinMaxRand tval;
        
        for(int i = 0; i < num; ++i)
        {
            tval = new MinMaxRand(minVal,maxVal);
            System.out.println(tval+" ");
        }
        //System.out.println();
    }
}
