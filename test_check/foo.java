
/**
 * Write a description of class foo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class foo
{
    static int foo(int n)
    {
        if (n < 1){
            return 0;
        } else { 
            return 1 + foo(n / 10);
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println("0: " + foo(0));
        System.out.println("1: " + foo(1));
        System.out.println("10: " + foo(10));
        System.out.println("234: " + foo(234));
        System.out.println("1234: " + foo(1234));
        System.out.println("10000: " + foo(10000));
    }
}
