public class handshake
{
    public static int handshake(int n)
    {
       if (n <= 2)
        return 1;
       else
        return handshake(n-1) + (n - 1);
    }
    
    public static void main(String[] argv) {
        System.out.println(handshake(4));
    }
}