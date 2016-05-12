package factorial;
public class Factorial2
{
    public static void main(String[] argv)
    {
        int n = (int) (Math.random()*10);
        int result = 1;
        System.out.println("Value of n: " + n);
        while (n > 1)
        {
            result = result * n;
            n--;
        }
        System.out.println("Result: " + result);
    }
}
