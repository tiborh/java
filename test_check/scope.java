
/**
 * Write a description of class scope here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class scope
{
    // instance variables - replace the example below with your own
    //private int x;

    /**
     * Constructor for objects of class scope
     */
    public scope()
    {
        // initialise instance variables
        //x = 0;
    }

    
    static void foo(String x, String y, int number){
        x = x + y;
        number++;
    }
    
    static void bar(){
        String s = "Hello";
        String who = "John";
        int number = 6;
        System.out.println("s: " + s + "; who: " + who + "; number: " + number);
        foo(s, who, number);
        System.out.println("s: " + s + "; who: " + who + "; number: " + number);
    }
    
    static void main(String[] argv)
    {
        bar();
    }
}
