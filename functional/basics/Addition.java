package basics;

/**
 * Trying Functonal programming style with recursion 
 * (does not work with great numbers: e.g. b > 17500)
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Addition
{
    private static int add(int a, int b) {
        if (b == 0) return a;
        return(add(a+1,b-1));
    }
    
    public static void main(String[] argv) {
        if (argv.length < 2) {
            System.err.println("Two arguments are needed.");
            System.exit(1);
        }
        int a = Integer.parseInt(argv[0]);
        int b = Integer.parseInt(argv[1]);
        System.out.println(a + " + " + b + " == " + add(a,b));
    }
}
