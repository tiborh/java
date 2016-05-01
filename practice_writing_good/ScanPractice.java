import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Get user to enter valid number
 * 
 * @author t
 * @version 0.01
 */
public class ScanPractice
{
    public static void main(String args[])
    {
        Scanner reader;
        Float n = null;
        while (n == null)
        {            
            System.out.println("Enter something: ");
            reader = new Scanner(System.in);  // Reading from System.in
            try
            {
                n = reader.nextFloat();
            } catch(InputMismatchException e)
            {
                System.out.println("Float or integer is expected.");
            }
        }
        System.out.println("You have entered: "+n);
    }
}
