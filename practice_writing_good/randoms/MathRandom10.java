package randoms;


/**
 * Write a description of class MathRandom10 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MathRandom10
{
    public static void main(String[] argv)
    {
        for (int i = 0; i < 10; ++i)
            System.out.println((int)(10*Math.random())+1);
    }
}
