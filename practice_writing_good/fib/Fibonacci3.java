package fib;


/**
 * Write a description of class Fibonacci3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fibonacci3 extends Fibonacci
{
    @Override
    public long calc(int n)
    {
        double sqrt5 = Math.sqrt(5);
        return
        ((long)((Math.pow(1+sqrt5,n+1)-Math.pow(1-sqrt5,n+1))/
        (Math.pow(2,n+1)*sqrt5)));
    }
    
    /** main in Fibonacci3 */
    public static void main(String[] argv)
    {
        int fn; 
        if (argv.length >= 1)
            fn = Integer.parseInt(argv[0]);
        else
            fn = 10;
        assert(fn >= 0);
        Fibonacci3 afib = new Fibonacci3();
        for (int i = 0; i < fn && i <= maxnum; ++i)
            System.out.println(i + ": " + afib.calc(i));
    }
}
