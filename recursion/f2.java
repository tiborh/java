public class f2
{
    public static int f2(int a, int b)
    {
       if (b >= 1)
        return f2(a+1,b-1);
       else
        return a;
    }
    
    public static void main(String[] argv) {
        System.out.println(f2(3,2));
    }
}
