public class week09task01
{
    public static int fl(int n)
    {
       if (n == 1)
        return 1;
        
       return n + fl(n - 1);
    }
    
    public static void main(String[] argv) {
        System.out.println(fl(4));
    }
}
