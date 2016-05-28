package fib;


/**
 * Write a description of class Fibonacci here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fibonacci
{
    // instance variables - replace the example below with your own
    protected long[] result;
    protected int num;
    public static final int maxnum = 92;

    /**
     * Constructor for objects of class Fibonacci
     */
    public Fibonacci()
    {
        // initialise instance variables
        result = new long[maxnum+1];
        result[0] = 0;
        result[1] = 1;
        num = 1;
    }

    public long calc(int n)
    {
        assert(n>=0);
        if (n <= this.num)
            return result[n];
        else
        {
            result[n] = calc(n-1)+calc(n-2);
            num = n;
            return result[n];
        }
    }
    
    public String toString()
    {
        String outstr = "";
        for (int i = 0; i < num; ++i)
            outstr += result[i] + " ";
        return outstr;
    }
    
    /** main in Fibonacci */
    public static void main(String[] argv)
    {
        int fn; 
        if (argv.length >= 1)
            fn = Integer.parseInt(argv[0]);
        else
            fn = 10;
        assert(fn >= 0);
        Fibonacci afib = new Fibonacci();
        for (int i = 0; i < fn && i <= maxnum; ++i)
            System.out.println(i + ": " + afib.calc(i));
        System.out.println(afib);
    }
}
