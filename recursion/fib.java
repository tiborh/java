public class fib
{
    public static int fib(int n)
    {
      if (n <= 1)
        return n;
      return fib(n-1) + fib(n-2);
    }
    
    public static void main(String[] argv) {
        for (int i = 0; i < 42; i++)
            System.out.println(i + ": " + fib(i));
    }
}
