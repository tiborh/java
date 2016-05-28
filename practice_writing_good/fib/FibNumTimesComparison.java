package fib;

/**
 * Write a description of class Comp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
/**
 * Fibonacci series, three implementations: cascade non-linear recursion, 
 * tail linear recursion (faster) and direct (fastest).
 */

public class FibNumTimesComparison 
{
    private static int invoked = 0;
    protected static long[] result;
    protected static int num;
    public static final int maxnum = 92;

    public static void clearInvoked(){ invoked = 0; }

    public static int getInvoked(){ return(invoked); }

    public static void init()
    {
        result = new long[maxnum+1];
        result[0] = 0;
        result[1] = 1;
        num = 1;        
    }
    
    /**
     * Cascade recursion implementation: fib(n) = fib(n-1)+fib(n-2)
     */
    public static long recursive(int n)
    {
        invoked++;
        if (n <= num)
            return result[n];
        else
        {
            result[n] = recursive(n-1)+recursive(n-2);
            num = n;
            return result[n];
        }
    }

    /**
     * Linear Tail recursion implementation
     */
    private static long fibAux(int n, int x, int y)
    {    
        invoked++;
        if (n==0) return x;
        if (n==1) return y;
        return fibAux(n-1, y, x+y);   
    }

    public static long recursive2(int n) {
        return fibAux(n, 0, 1);
    }  

    /**
     * Direct implementation
     */
    public static long direct(int n)
    {
        invoked++;
        double goldenRatio = (1 + Math.sqrt(5)) / 2;

        double f1 = Math.pow(goldenRatio, n);
        double f2 = Math.pow(-goldenRatio, -n);
        return (long) ((f1-f2)/Math.sqrt(5));
    }

    /**
     * Calls the three implementations and compares the average time
     */
    public static void test(int n)
    {        
        long result;

        System.out.println("TEST CASE: n="+n);

        System.out.format("%-25s %20s %20s\n","Used Algorithm", "Result", "Times Invoked");

        clearInvoked();
        result = recursive(n);
        System.out.format("%-25s %20d %20d\n","Cascade recursion", result, getInvoked());

        clearInvoked();
        result = recursive2(n);
        System.out.format("%-25s %20d %20d\n","Linear Tail recursion", result, getInvoked());

        clearInvoked();
        result = direct(n);
        System.out.format("%-25s %20d %20d\n","Direct", result, getInvoked());

        System.out.println("========");
    }

    public static void main(String[] args)
    {
        // test set
        // test set
        init();
        test(1);
        test(2);
        test(3);
        test(4);
        test(10);
        test(20);
        test(30);
        test(40);
    }
}