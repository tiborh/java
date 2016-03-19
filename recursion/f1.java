
/**
 * Write a description of class f1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class f1
{
    public static int f1(int n) {

        if (n > 1)
            return f1(n - 1) + f1(n - 2);
        else
            return 1;
    }
    
    public static int f2(int a, int b) {
        if (b == 0)
            return 1;
        else {
            return a * f2(a, b - 1);
        }
    }
    
    public static String f3(String s, int length) {
        
       if (length == 0)
            return "";
            
       return s.charAt(length - 1) + f3(s, length - 1);
    }
    
    public static String f4(int n) {

        if (n == 0) return "0";
        if (n == 1) return "1";
        
        return f4(n / 2) + (n % 2);
    }
    
    public static String f5(int n) {
        
        if (n == 0) return "0";
        
        return n + f5(n - 1) + n;
    }
    
    public static void main(String[] argv)
    {
        System.out.println("f1(3): " + f1(3));
        System.out.println("f2(2,5)..f2(2,0)");
        System.out.println(f2(2,5));
        for (int i = 4; i >= 0; i--) {
            System.out.println(f2(2,i));    
        }
        System.out.println("f3(\"tsukh\", 5): " + f3("tsukh", 5));
        System.out.println("f4(0)..f4(15)");
        for (int i = 0; i <= 15; i++)
            System.out.println(f4(i));
        System.out.println("f5(3): " + f5(3));
    }
}
