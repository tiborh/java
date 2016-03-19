
/**
 * Write a description of class calcs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class calcs
{
    public static void main(String[] args)
        {
            int i = 1234567890;
            float f = i;
            int result = i - (int)f;
            int conv_back = (int)f;
            
            System.out.println(i);
            System.out.println(f);
            System.out.println(result);
            System.out.println(conv_back);
        }
}