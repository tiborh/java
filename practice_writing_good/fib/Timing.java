package fib;


/**
 * Write a description of class Timing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timing
{
    public static void main(String[] argv)
    {
        Fibonacci fib1 = new Fibonacci();
        Fibonacci fib2 = new Fibonacci2();
        
        double startfib1 = System.nanoTime();
        fib1.calc(90);
        double endfib1 = System.nanoTime();
        
        System.out.println("fib1.calc(90) takes:"+ (endfib1 - startfib1) + " nanosecs"); 
        
        double startfib2 = System.nanoTime();
        fib2.calc(90);
        double endfib2 = System.nanoTime();
        
        System.out.println("fib2.calc(90) takes:"+ (endfib2 - startfib2) + " nanosecs");
        
        startfib1 = System.nanoTime();
        fib1.calc(45);
        endfib1 = System.nanoTime();
        
        System.out.println("fib1.calc(45) takes:"+ (endfib1 - startfib1) + " nanosecs"); 
        
        startfib2 = System.nanoTime();
        fib2.calc(45);
        endfib2 = System.nanoTime();
        
        System.out.println("fib2.calc(45) takes:"+ (endfib2 - startfib2) + " nanosecs");
    }
}
