import java.util.Calendar;
/**
 * Write a description of class dayOfYear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dayOfYear
{
   public static void main(String[] argv)
   {
       Calendar calendar = Calendar.getInstance();
       int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
       System.out.println("Day of year: " + dayOfYear);
   }   
}
