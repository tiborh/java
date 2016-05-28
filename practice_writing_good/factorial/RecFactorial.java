package factorial;

/**
 * This program displays as stars the execution time of 
 * factorial(n) computed with the non-tail linear recursion
 * The resulting graph shows how the growth with n 
 * 
 */
public class RecFactorial
{    
    /**
     * Non-tail linear recursion
     */
    public static long factorial(long n)
    {
        if (n<=1)
            return 1;
        else
            return n*factorial(n-1);
    }
     
    /** 
     * Displays a line of stars.
     * The length of the line is proportional to the average execution time
     * of the algorithm
     * 
     */
    private static void displayStars(long n, long averageTime, int stars, char c)
    {    
        System.out.print(n+"\t"+averageTime+"\t");
        
        for(long i=0; i<stars; i++)
            System.out.print(c);
        
        System.out.println();
    }
    
    /** 
     * Test method: calls factorial(n) the number of 
     * given by times
     */
    public static void test(long n, long times)
    {
        long startTime = System.nanoTime();

        for(long i=0; i<times; i++)
            factorial(n);

        long averageTime = (System.nanoTime()-startTime)/times;
        displayStars(n, averageTime, (int)Math.log(averageTime), '*');
    }
    
    public static void main(String[] args)
    {        
        System.out.println("n"+"\t"+"time");
        /** going for stack overvlow */
        for(int i=0; i<41000; i+=1000)
            test(i, 10000);        
    }
}