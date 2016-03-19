
/**
 * Write a description of class recursion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class recursion
{
    /** @param x an integer such that x >= 0
    */
    public static void generate(int x)
    {
        System.out.print(x % 10);
        if ((x / 10) != 0) {
            generate(x / 10);
        }
        System.out.print(x % 10);
    }
    
    public static void main(String[] args)
    {
        generate(Integer.parseInt(args[0]));
    }
}
