package complexity;

/**
 * Class that compares the execution time of the linear and binary search algorithms 
 * when:
 * Searching for the first element, an element at the middle and the last element
 */
public class SearchComp
{
    private static int num;

    public static void clearNum(){ num = 0; }

    public static int getNum(){ return num; }

    public static int linear(int[] array, int search)
    {    
        for (int i=0; i<array.length; i++)
        {
            num++;
            if(array[i]==search)
                return i;
        }

        return -1;
    }

    public static int binary(int[] array, int search)
    {        
        int low = 0;
        int high = array.length - 1;

        while(high >= low)
        {
            num++;
            int middle = (low + high) / 2;
            if(array[middle] == search)
                return middle;
            else 
            if(array[middle] < search)
                low = middle + 1;
            else
            // enter here if array[middle] > search 
                high = middle - 1;
        }

        return -1;
    }

    public static void main(String[] args)
    {    
        // create sorted array
        int array[] = new int[10000];
        int previous = 0;

        for(int i=0; i<array.length; i++)
        {
            array[i] = previous+(int) ((Math.random() +1.0)*5.0);
            previous = array[i];
        }

        int toSearch;
        int nLinear, nBinary;

        System.out.format("%25s %20s %20s\n","Case", "Iter Linear", "Iter Binary");

        // Search first element
        toSearch = array[0];
        clearNum();
        linear(array, toSearch);
        nLinear = getNum();

        clearNum();
        binary(array, toSearch);
        nBinary = getNum();

        System.out.format("%25s %20d %20d\n","First element", nLinear,nBinary);
        // Search an element in the middle
        toSearch = array[(int)array.length/2];

        clearNum();
        linear(array, toSearch);
        nLinear = getNum();

        clearNum();
        binary(array, toSearch);
        nBinary = getNum();

        System.out.format("%25s %20d %20d\n","Element in the middle", nLinear,nBinary);

        // Search for the last element
        toSearch = array[array.length-1];

        clearNum();
        linear(array, toSearch);
        nLinear = getNum();

        clearNum();
        binary(array, toSearch);
        nBinary = getNum();
        System.out.format("%25s %20d %20d\n","Last element", nLinear,nBinary);

    }
}
