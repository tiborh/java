
/**
 * Write a description of class count_sorted here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class count_sorted
{
    static int countSorted(int[] array){	
        int count = 1; 
        int max = 1;
        for (int k = 1; k < array.length; k++) {
            if (array[k-1] <= array[k]) {
                count++;
            } else {
                if (count > max)
                    max = count;
                count = 1;
            }
        }
        
        if (count > max)
            max = count;
        
        return max;
        //return count;
    }
    
    public static void main(String[] args)
    {
        int [] arr = {25, 7, 7, 14, 14, 14, 21, 3, 3, 3, 5, 12, 12, 13, 13};
        System.out.println(countSorted(arr));    
    }
}
