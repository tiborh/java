
/**
 * Write a description of class Jumping here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jumping
{
    public static void main(String[] argv)
    {
        int t = (int) (Math.random() *100) + 1;
        System.out.println("The number is: "+t);
        int result = 1;
        for (int i = t/2; i > 1; --i)
        {
            if(t%i==0)
            {
                result = i;
                i = 1;
            }
        }
        System.out.println("The greatest divisor is: "+ result);
    }
}
