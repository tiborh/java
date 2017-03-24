/**
 * Functional but not elegant, and not correct with zero division
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Division2
{
    private static int divide(int a, int b) {
        return((int) (a/(double)b));
    }
    
    public static void main(String[] argv) {
        if (argv.length < 2) {
            System.err.println("Two arguments are needed.");
            System.exit(1);
        }
        int a = Integer.parseInt(argv[0]);
        int b = Integer.parseInt(argv[1]);
        System.out.println(a + " / " + b + " == " + divide(a,b));
    }
}
