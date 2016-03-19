import java.util.Stack;
/**
 * Write a description of class quiz_tests here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class quiz_tasks
{
    private static int x = 10;

    static int f9()
    {
        int a = 1;
        int b = 2;
        int c = 3;
        
        if ( b > a ) {
            a = b;				
                if ( c > a ) {
                    a = c;
                }
        } else if ( a == c ) {
            a = 0;
        }
        return a;
    }
    
    static int f8()
    {
        int counter = 0;
  
        for (int i = 0; i < 10; i++)
        {
            System.out.print(i + ": ");
            for (int j = 0; j < i; j++)
            {
                counter = counter + 1;
                System.out.print(counter + " ");
            }
            System.out.println();
        }
                
        return counter;
    }
    
    static int[] f7()
    {
        int i = 0;
        int j = 0;
          
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (j == 1)
                    break;
            }
        }
        int ij[] = {i,j};
        return ij;
    }
    
    static int f6()
    {
        int y = 1;
  
        do {          
                y += y;
                System.out.println(y);
        } while (y < 126);
        
        return y;
    }
    
    static int f5()
    {
        Stack<Integer> s = new Stack<Integer>();
        s.push(9);
        s.push(2);
        s.push(7);
        
        int a = s.pop();
        int b = s.pop();
        int c = s.pop();
        
        return a + b * c;
    }
    
    static int f4()
    {
        int[] numbers = {9, 2, 8, 1, 4};
        int x = 0;
        
        for (int i = 0; i < 5; i++) {
            if (numbers[i] % 2 == 0) continue;
            x += numbers[i];
            System.out.printf("numbers[%d]: %d\n",i,numbers[i]);
        }
        return x;
    }
    
    static int f3(int value) {
    
        if (value == 0) return 0;
        return 1 * f3(value - 2);
    }
    
    public static int f2() {
        int result = 1;
        int[] array = {2, 3, 4};

        for (int x = 0; x < array.length - 1; x++) {
            System.out.println(x);
            result *= array[x];
        }

        System.out.println(x);
        result *= x;
        System.out.println(result);
        return result;
    }
    
    public static int foo(int v) 
    {
        //System.out.println(v);
        if (v == 0)
        {
            System.out.println("v == 0, returning 1");
            return 1;
        } else if (v == 1)
        {
            System.out.println("v == 1, returning 0");
            return 0;
        } else if (v % 2 == 0)
        {
            System.out.println("v % 2 == 0 returning " + 1+foo(v/2));
            return 1+foo(v/2);
        } else
        {
            System.out.println("catchall else, returning " + foo(v/2));
            return foo(v/2);
        }
    }
    
    public static void f1(int x, int y, int z)
    {
        if ( x > y )
            if ( z > x)
                x = 1;
            else
                x = 3;    
        System.out.println(x);
    }
    
    public static void main(String[] argv)
    {
       System.out.println("Fine.");
       System.out.println(3 % 2 * 2 + 3 * - 1 / 3);
       System.out.println(- 1 / 3);
       System.out.println(3 * - 1 / 3);
       int x = 1;
       int y = x++;
       int z = ++y;
       y = z++;
       z = ++z;
       System.out.println(z);
       double d = 2;
       double d2 = 2.0f;
       char grade = 'A';
       int score = 99;
  
       switch(score/10) {
           case 10: grade = 'A'; 
           case 8: grade = 'C'; 
           case 9: grade = 'B';  
           default: grade = 'F'; 
        }
       System.out.println(grade);
       f1(2,4,6);
       f1(6,4,2);
       f1(4,2,6);
       
       int i;
       for ( i = 0; i < 4; i++ ); {
           i = i + 2;
       }
       System.out.println(i);
       System.out.println(x);
       System.out.println(f2());

       String str = "HKUST";  

       System.out.println("1: " + str.charAt(2));                 // (1)
       System.out.println("2: " + str.charAt(3));                 // (2)
       System.out.println("3: " + str.substring(2,3).charAt(0));  // (3)
       System.out.println("4: " + "HKUST".charAt(3));             // (4)
    }
}
