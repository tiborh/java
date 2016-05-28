
/**
 * Write a description of class Hanoi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hanoi
{
    private static void moveTower(int height,String fromPole, String toPole, String withPole)
    {
        if (height >= 1)
        {
            moveTower(height-1,fromPole,withPole,toPole);
            moveDisk(fromPole,toPole);
            moveTower(height-1,withPole,toPole,fromPole);
        }
    }

    private static void moveDisk(String fp,String tp)
    {
        System.out.println("moving disk from " + fp + " to " + tp);
    }

    public static void main(String[] argv)
    {
        int num = 3;
        if (argv.length > 0)
            num = Integer.parseInt(argv[0]);
        moveTower(num,"A", "B", "C");
    }
}
