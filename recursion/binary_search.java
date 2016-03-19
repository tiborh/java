import java.util.Random;
import java.util.Arrays;
public class binary_search
{
    /**
      * @param data input array
      * @param lower lower bound index
      * @param upper upper bound index
      * @param value value to search for
      * @return index if found, otherwise return -1
      */
    public static int binSearch(int[] data, int lower, int upper, int value)
    {
        int middle = (lower + upper) / 2;

        if (data[middle] == value)
            return middle;
    
        else if (lower >= upper)
            return -1;
    
        else if (value < data[middle])
            return binSearch(data, lower, middle-1, value);
    
        else
            return binSearch(data, middle+1, upper, value);
    }
    public static void print_array(int[] in_array) {
        for (int i = 0; i < in_array.length; i++)
            System.out.print(in_array[i] + ", ");
        System.out.println();
    }        
    
    public static void main(String[] argv)
    {
        int[] numbers = new int[15];
        Random rand_source = new Random();
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = rand_source.nextInt(1000);
        print_array(numbers);
        Arrays.sort(numbers);
        print_array(numbers);
        System.out.println("search for 2nd value: " + binSearch(numbers,0,14,numbers[1]));
        int rand_value = rand_source.nextInt(1000);
        System.out.println("search for random value(" + rand_value + "): " + binSearch(numbers,0,14,rand_value));
    }
}
