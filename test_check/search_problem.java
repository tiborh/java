
/**
 * Write a description of class search_problem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class search_problem
{
    /** 
     * @param array an array of sorted (ascending order) int values that contains no duplicates
     * @param iMin an int value such that 0 <= iMin < array.length
     * @param iMax an int value such that iMin - 1 < iMax < array.length
     * @param key an int value 
     */
    static int foo(int array[], int key, int iMin, int iMax){
        if (iMin > iMax){
            return -1;
        } else{
            int midPoint = (iMax + iMin) / 2;
            if (array[midPoint] == key){
                return midPoint;
            } else if (array[midPoint] > key){
                return foo(array, key, iMin, midPoint - 1);
            } else {
                return foo(array, key, midPoint + 1, iMax);
            }
        }
    }
    
    public static void main(String[] args)
    {
        int[] sample = {1, 3, 5, 7, 9, 11};
        System.out.println(foo(sample, 11, 0, sample.length-2));
        System.out.println(foo(sample, 11, 0, sample.length-1));
    }
}
