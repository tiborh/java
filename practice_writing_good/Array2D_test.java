
/**
 * Write a description of class Array2D_test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Array2D_test
{
    public static void main(String[] argv)
    {
        Array2D a1 = new Array2D();
        System.out.println(a1);
        a1.fill2D(3);
        System.out.println(a1);
        a1.fill2D();
        System.out.println(a1);
        int myf = a1.getFirst();
        int mys = a1.getSecond();
        System.out.println(myf);
        System.out.println(mys);

        int[][] arr1 = new int[myf][mys];
        for (int i = 0; i < myf; ++i)
            for (int j = 0; j < mys; ++j)
                arr1[i][j] = 1;
        
        System.out.println("Exploiting a vulnerability in array setting:");
        a1.fill2D(arr1);
        System.out.println(a1);
        
        arr1[0][0] = 0;
        System.out.println(a1);
    }
}
