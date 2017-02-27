
/**
 * Write a description of class stringValue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class string_value
{
    /**
     * @param n integer to convert to string
     * @param base base for the representation. Requires 2<=base<=10.
     * @return n represented as a string of digits in the specified base, with 
     *           a minus sign if n<0.  No unnecessary leading zeros are included. 
     */
    public static String stringValue(int n, int base) {
        if (n < 0) { return "-" + stringValue(-n, base); } 
        else if (n == 0) { return ""; }
        else { return stringValue(n/base, base) + "0123456789".charAt(n%base); }
    }
    
    public static void main(String[] argv) {
        assert(argv.length == 2);
        int num = Integer.parseInt(argv[0]);
        int base = Integer.parseInt(argv[1]);
        assert(base >= 2);
        assert(base <= 10);
        System.out.println("Result: " + stringValue(num,base));
    }
}
