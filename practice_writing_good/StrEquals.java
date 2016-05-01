
/**
 * Write a description of class StrEquals here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StrEquals
{
    public static void main(String[] argv)
    {
        System.out.println("3".equals("3"));    //true
        System.out.println("3"=="3");           //true
        System.out.println("3"=="2");           //false
        String a = new String("3");
        String b = new String("3");
        System.out.println(a==b);               //false
        a = "3";
        b = "3";
        System.out.println(a==b);               //true
    }
}
