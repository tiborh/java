/**
 * test class to study a task of week 4 quiz
 * 
 * @author tibor
 * @version 0.01
 * @since 2015-06-06
 */
public class TestLine
{
    public static void main(String[] args)
    {
        Point a = new Point(1,2);
        Point b = new Point(3,4);
        Line ab = new Line(a,b);
        System.out.println("The length of the line between points " + a + " and " + b + " is " + ab.getLineLength());
    }
}