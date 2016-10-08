
/**
 * Write a description of class assertCheck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class assertCheck
{
    public static void main(String[] argv)
    {
        assert(1==1); // pass
        System.out.println("First assert has been passed.");
        try {
            assert(1>1);  // fail
            System.out.println("This line should not print if assert mode is on.");
        } catch (AssertionError e1) {
            System.out.println("AssertionError has been caught.");
        }
    }
}
