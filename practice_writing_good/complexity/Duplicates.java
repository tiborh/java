package complexity;
/**
 * Main class of the Java program.
 */

public class Duplicates
{
    public static boolean existDuplicates(int[] array)
    {
        for (int i=0; i< array.length; i++)
            for (int j=i+1; j< array.length; j++)
                if (array[i] == array[j])
                    return true;
                    
        return false;
    }

    public static void main(String[] args)
    {
        // create array
        int array[] = new int[500000];
        boolean exist;

        for(int i=0; i<array.length; i++)
            array[i] = (int) ( (Math.random() + 1) *50.0);

        exist = existDuplicates(array);

        if (exist)
            System.out.println("There are duplicates");
        else
            System.out.println("There are NO duplicates");

        int previous = 0;

        for(int i=0; i<array.length; i++)
        {
            array[i] = previous + (int) ( (Math.random() + 1) *50.0);
            previous = array[i];
        }

        /** takes extremely long time: */
        exist = existDuplicates(array);

        if (exist)
            System.out.println("There are duplicates");
        else
            System.out.println("There are NO duplicates");
    }
}
