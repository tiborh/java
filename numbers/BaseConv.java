
/**
 * Write a description of class BaseConv here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BaseConv
{
    public static void main(String[] argv)
    {
         for (String anInput : argv)
         {
             System.out.println("Raw input: " + anInput);
             try
             {
                 Integer parsedInt = Integer.parseInt(anInput,8);
                 System.out.println("Parsed input: " + Integer.toString(parsedInt,16));
             }
             catch (NumberFormatException e)
             {
                 System.out.println("Not an octal input: " + e);
             }
                          
         }
    }
}
