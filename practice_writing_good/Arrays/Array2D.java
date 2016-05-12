package Arrays;
import java.util.Random;

/**
 * Write a description of class Array2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Array2D
{
    protected int fmax;
    protected int smax;
    protected int[][] d2;
    
    Array2D()
    {
        this(3,4);
    }
    
    Array2D(int size)
    {
        this(size,size);
    }
    
    Array2D(int first, int second)
    {
        fmax = first;
        smax = second;
        d2 = new int[fmax][smax];
    }
    
    void fill()
    {
        Random randomGenerator = new Random();
        for (int i = 0; i < fmax; ++i)
            for (int j = 0; j < smax; ++j)
                d2[i][j] = randomGenerator.nextInt(100);
    }
    
    void fill(int a)
    {
        for (int i = 0; i < fmax; ++i)
            for (int j = 0; j < smax; ++j)
                d2[i][j] = a;
    }
    
    // Giving access to a private variable: vulnerability
    void fill(int[][] a)
    {
        if (a.length == fmax && a[0].length == smax)
            d2 = a;
    }
    
    int getFirst() { return d2.length; }
    int getSecond() { return d2[0].length; }
    
    public String toString()
    {
        String outstr = "";
        for (int i = 0; i < fmax; ++i)
        {
            for (int j = 0; j < smax; ++j)
            {
                outstr += d2[i][j];
                outstr += " ";
            }
            outstr += "\n";
        }
        return outstr;
    }
    
    public static void main(String[] argv)
    {
        Array2D a1 = new Array2D();
        System.out.println(a1);
        a1.fill(3);
        System.out.println(a1);
        a1.fill();  //Fill with random numbers
        System.out.println(a1);
        int myf = a1.getFirst();
        int mys = a1.getSecond();
        System.out.println(myf);
        System.out.println(mys);

        int[][] arr1 = new int[myf][mys];
        for (int i = 0; i < myf; ++i)
            for (int j = 0; j < mys; ++j)
                arr1[i][j] = 1;
        
        a1.fill(arr1);
        System.out.println(a1);
        
        arr1[0][0] = 0;
        System.out.println(a1);
        
        a1.d2[0][0] = 1;
        System.out.println(a1);
    }
}
