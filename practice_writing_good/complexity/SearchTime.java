package complexity;

/**
 * Class that compares the execution time of the linear and binary search algorithms 
 * when:
 * Searching for the first element, an element at the middle and the last element
 */
 public class SearchTime {
    
    public static int linear(int[] array, int search)
    {
        
        for (int i=0; i<array.length; i++)
            if(array[i]==search)
                return i;

        return -1;
    }
    
    public static int binary(int[] array, int search)
    {    
        int low = 0;
        int high = array.length - 1;
        
        while(high >= low)
        {
            int middle = (low + high) / 2;
            if(array[middle] == search)
                return middle;
            else if(array[middle] < search)
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
        
        long startTime, endTime; 
        float timeLinear, timeBinary;
        int toSearch;
        int times = 10000;
        
        System.out.format("%25s %20s %20s\n","Case", "Ex. time Linear", "Ex. time Binary");
        
        // Search first element
        toSearch = array[0];
        
        startTime= System.nanoTime();
        for(int i=0; i < times; i++)
            linear(array, toSearch);

        endTime = System.nanoTime();
        
        timeLinear = ((float) (endTime-startTime))/times;
        
        startTime= System.nanoTime();
        for(int i=0; i<times; i++)
            binary(array, toSearch);

        endTime = System.nanoTime();
        
        timeBinary = ( (float) (endTime-startTime))/times;
        
        System.out.format("%25s %20f %20f\n","First element", timeLinear,timeBinary);
        
        // Search an element in the middle
        toSearch = array[(int)array.length/2];
        
        startTime= System.nanoTime();
        for(int i=0; i < times; i++)
            linear(array, toSearch);

        endTime = System.nanoTime();
        
        timeLinear = ((float) (endTime-startTime))/times;
        
        startTime= System.nanoTime();
        for(int i=0; i<times; i++)
            binary(array, toSearch);

        endTime = System.nanoTime();
        
        timeBinary = ( (float) (endTime-startTime))/times;
        
        System.out.format("%25s %20f %20f\n","Element in the middle", timeLinear,timeBinary);
        
        // Search for the last element
        toSearch = array[array.length-1];
        
        startTime= System.nanoTime();
        for(int i=0; i<times; i++)
            linear(array, toSearch);

        endTime = System.nanoTime();
        
        timeLinear = ((float) (endTime-startTime))/times;
        
        startTime= System.nanoTime();
        for(int i=0; i<times; i++)
            binary(array, toSearch);

        endTime = System.nanoTime();
        
        timeBinary = ( (float) (endTime-startTime))/times;
        
        System.out.format("%25s %20f %20f\n","Last element", timeLinear,timeBinary);        
    }
}
