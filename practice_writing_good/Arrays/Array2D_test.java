package Arrays;
/**
 * Write a description of class Array2D_test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Array2D_test
{
    private static void printArr(int[][] a)
    {
        for (int[] a1: a)
        {
            for(int d1: a1)
                System.out.print(d1);
            System.out.println();
        }
    }

    public static void main(String[] argv)
    {
        Array2D a1 = new Array2D();
        System.out.println(a1);
        a1.fill(3);
        System.out.println(a1);
        a1.fill();
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
        a1.unsafefill(arr1);
        System.out.println(a1);
        
        arr1[0][0] = 0;
        System.out.println(a1);
        
        int testsize = 3;
        a1 = new Array2D(testsize);
        a1.fill(testsize);
        int[][] A1 = a1.get();
        printArr(A1);
        int[][] A2 = new int[testsize][testsize];
        for (int i = 0; i < testsize; ++i)
            for( int j = 0; j < testsize; ++j)
                A2[i][j] = A1[i][j];
        printArr(A2);

    }
}
