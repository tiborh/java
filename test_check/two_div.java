
/**
 * Write a description of class two_div here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class two_div
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class two_div
     */
    public two_div()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }

    public static void main(String[] argv)
    {
        int num = 13 * 7 * 23;
        int a = 2;
        System.out.println("num: " + num + " a: " + a);
        while (a <= num/2) {
            if (num%a == 0) {
                //System.out.print(a + " ");
                num /= a;
            } else {
                System.out.println("(" + (num % a) + ")");
                num -= num%a;
            }
            System.out.println("num: " + num);
        }
        System.out.println(" ");

    }
}
