package fib;


/**
 * Write a description of class Fibonacci2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fibonacci2 extends Fibonacci
{
    private long fib(int n, long x, long y)
    {
        if (n==0) return x;
        if (n==1) return y;
        else return fib(n-1,y,x+y);
    }
    
    @Override
    public long calc(int n)
    {
        assert(n>=0);
        return fib(n,0,1);
    }
    
    /** main in Fibonacci2 */
    public static void main(String[] argv)
    {
        int fn; 
        if (argv.length >= 1)
            fn = Integer.parseInt(argv[0]);
        else
            fn = 10;
        assert(fn >= 0);
        Fibonacci2 afib = new Fibonacci2();
        for (int i = 0; i < fn && i <= maxnum; ++i)
            System.out.println(i + ": " + afib.calc(i));
    }
}
