package basics;

/**
 * Not functional: it can thow an exception at division by zero
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Division
{
    private static double divide(int a, int b) {
        return a/(double)b;
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
