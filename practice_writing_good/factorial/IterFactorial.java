package factorial;

/**
 * This program displays as stars the execution time of 
 * factorial(n) computed in an iterative way
 * The resulting graph shows how the growth is exponential with n 
 * 
 */
public class IterFactorial {

    /**
     * Iterative factorial
     */
    public static long factorial(long n)
    {
        long result = 1;

        if (n > 1)
            for (int i = 1; i <= n; i++)
                result = result * i;
        
        return result;
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
        displayStars(n, averageTime, (int)averageTime/100, '*');
    }

    public static void main(String[] args)
    {        
        System.out.println("n"+"\t"+"time");
        for(int i=0; i<5000; i+=100)
            test(i, 20000);
    }
}
