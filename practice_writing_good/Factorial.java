
/**
 * Write a description of class factorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Factorial
{
    int f = 0;
    int n = 0;
    
    public Factorial ()
    {
        n = 1;
    }
    
    public Factorial (int number)
    {
        n = number;
    }

    public void fact() { f = factorial(n); }
    
    public int factorial (int number)
    {
        if (number==0 || number>9)
            return 1;
        else
            return number * factorial(number-1);

    }
    
    public String toString()
    {
        return ""+f;
    }
    
    public static void main(String[] argv)
    {
        Factorial five = new Factorial(5);
        five.fact();
        System.out.println(five);
        Factorial ten = new Factorial(10);
        ten.fact();
        System.out.println(ten);
    }
}
