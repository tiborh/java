public class MinMax
{
    public static void main(String[] argv)
    {
        int array[] = {81,13,10,34,23,234,8,33};
        int value = array[0]; 
        int value2 = value;
        int loop_counter = 0;
        for (int element : array){
            ++loop_counter;
            if (element > value){
                value = element;
            }
            if (element < value2){
                value2 = element;
            }
        }
        System.out.println("Min (value2): "+value2+" Max (value): "+value);
        System.out.println("Loop counter: "+loop_counter);
        System.out.println("Number of elements: "+array.length);
    }
}
