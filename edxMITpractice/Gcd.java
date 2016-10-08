
/**
 * Write a description of class gcd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gcd
{
    private final int _gcd;
    
    public Gcd(int a, int b) {
        _gcd = gcd(a,b);
    }
    
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b,a%b); 
    }
    
    public int getGcd() { return _gcd; }
    
    public static void main(String[] argv) {
        if (argv.length < 2)
            System.out.println("Two integer arguments are needed.");
        else {
            int a = Integer.parseInt(argv[0]);
            int b = Integer.parseInt(argv[1]);
            System.out.println("gcd: " + gcd(a,b));
        }
    }
}
