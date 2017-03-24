/**
 * Not functional because of partial results are side-effected
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Addition3
{
    private static void log(String txt) {
        System.out.println(txt);
    }
    
    private static int add(int a, int b) {
        log(String.format("Adding %s and %s", a, b));
        while(b > 0) {
            ++a;
            --b;
        }
        log(String.format("Returning %s", a));
        return a;
    }
    
    public static void main(String[] argv) {
        if (argv.length < 2) {
            System.err.println("Two arguments are needed.");
            System.exit(1);
        }
        int a = Integer.parseInt(argv[0]);
        int b = Integer.parseInt(argv[1]);
        add(a,b);
    }
}
