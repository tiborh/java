import comp102x.IO;
/**
 * Write a description of class math_test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class math_test
{
    public static void main(String[] args)
    {
        IO.output("Enter a number: ");
        double my_number = IO.inputDouble( );
        double my_sqrt = Math.sqrt(my_number);
        IO.outputln("Square root: " + my_sqrt);
    }
}
