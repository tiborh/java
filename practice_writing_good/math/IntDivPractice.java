package math;
/**
 * Write a description of class IntDivPractice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntDivPractice
{
    static int[] divisions(int number, int[] array){   
        int [] arrayResults = new int[array.length];
        for (int k = 0; k < array.length; k++) {
            try 
            {
                arrayResults[k] = number/array[k];
            } catch (java.lang.ArithmeticException e)
            {
                System.err.println("Elem " + k+1 + " is null, so result is also 0.");
                //arrayResults[k] = 0; // done automatically by previous
            }
        }
        return arrayResults;
    }

    static void pa(int[] array)
    {
        int xmax = array.length;
        for (int i = 0; i < xmax; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    
    public static void main(String[] argv)
    {
        int [] arr = {5,12,1};
        int [] array = divisions(154, arr);
        pa(arr);
        pa(array);
        int [] arr1 = {5,12,0,1};
        pa(arr1);
        int [] array1 = divisions(154, arr1); //java.lang.ArithmeticException
        pa(array1);
        int [] arr2 = {};
        int [] array2 = divisions(154, arr2);
        pa(array2);
    }
}
