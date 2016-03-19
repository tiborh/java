/**
 * to test how abstract classes work
 * 
 * @author tibor
 * @version 0.01
 * @since 2015-06-08
 */
public class test_toys
{
    public static void main(String[] args)
    {
        Toy a = new TeddyBear();
        a.play();
        Toy b = new ToyCar();
        b.play();
    }
}
