public class f3
{
    public static int f3(int n)
    {
       if (n == 0)
        return 1;
       else if (n < 10 && n > -10)
        return 0;
       else
        return f3(n/10) + f3(n%10);
    }
    
    public static void main(String[] argv) {
        System.out.println(f3(10200));
    }
}
