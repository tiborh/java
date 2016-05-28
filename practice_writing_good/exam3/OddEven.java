package exam3;

public class OddEven
{
    private static boolean isOdd (int n)
    {
        if (n==0)
            return false;
        else
            return isEven(n-1);
    }

    private static boolean isEven (int n)
    {
        if (n==0)
            return true;
        else
            return isOdd(n-1);
    }

    public static void main(String[] argv)
    {
        for (int i = 0; i < 10; ++i)
        {
            System.out.println("isOdd(" + i + "): " + isOdd(i));
            System.out.println("isEven(" + i + "): " + isEven(i));
        }
    }
}
