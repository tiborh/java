
/**
 * Write a description of class find_in_array here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class find_in_array
{
    static int foo(int[] array, int num)
    {
        int i = array.length - 1;
        while (i >= 0)
        {
            if (array[i] > num)
                return i;
            i--;
        }
        return i;
    }

    public static void main(String[] args)
    {
        int[] sample1 = {1,2,3,4,5,6};
        int[] sample2 = {6,5,4,3,2,1,0,-1};
        int[] sample3 = {-6,-5,-4,-3,-2,-1};
        int[] sample4 = {-6,-5,-4,0,-2,-1};
        int samplen1 = 0;
        System.out.println(foo(sample1,samplen1));
        System.out.println(foo(sample2,samplen1));
        System.out.println(foo(sample3,samplen1));
        System.out.println(foo(sample4,samplen1));        
    }
}
