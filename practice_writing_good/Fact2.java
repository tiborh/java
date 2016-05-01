
/**
 * Write a description of class Fact2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fact2 extends Factorial
{
    public Fact2 (int number)
    {
        n = number;
    }
    
    @Override
    public int factorial (int number)
    {
        int factorial = 1;
        if (number > 9) return 1;
        while (number>=1) {
            factorial=factorial*number;
            number--;
        }
        return factorial;
    } 
    
    /** Fact2 */
    public static void main(String[] argv)
    {
        Fact2 five = new Fact2(5);
        five.fact();
        System.out.println(five);
        Fact2 ten = new Fact2(10);
        ten.fact();
        System.out.println(ten);
    }
}
