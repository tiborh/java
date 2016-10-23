
/**
 * Write a description of class staticError here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class staticError
{
    public static String none() {
        return null;          // (1)
    }

    public static void main(String[] args) {
        String a = none();    // (2)
        String b = null;      // (3)
        if (a.length() > 0) { // (4) dynamic error: NullPointerException
            b = a;            // (5)
        }
        //return b;             // (6) static error
    }
}
