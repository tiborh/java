package dump;
/**
 * Write a description of class errorCheck1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class errorCheck1
{
    public static void main(String[] argv)
    {
        int n = 5;
        if (n) { // wrong type: only boolean can appear here
            n = n + 1;
        }
    }
}
