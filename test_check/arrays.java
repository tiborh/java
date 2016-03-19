
/**
 * Write a description of class arrays here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class arrays
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class arrays
     */
    public arrays()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }

    public static void main(String[] argv)
    {
        int[] anArray = new int[10];

        for (int i = 0; i < anArray.length; ++i)
            anArray[i] = i;

        for (int i = 0; i < anArray.length; ++i)
            System.out.println(anArray[i]);

        System.out.println("");

        String[] arrTwo = {"one","two","three"};
        for (int i = 0; i < arrTwo.length; ++i)
            System.out.println(arrTwo[i]);

        System.out.println("");

        char[] arrThree;
        arrThree = new char[]{'a','b','c'};
        for (int i = 0; i < arrThree.length; ++i)
            System.out.println(arrThree[i]);

        System.out.println("");

        for (int elem: anArray)
            System.out.println(elem);

        System.out.println("");

        {
            int[] array = new int[] {11, 22, 33, 44, 55};
            double average = 0;
            for (int element : array){
                average += element;
            }
            if (array.length > 0){
                average = average / array.length;
            }
            System.out.println("Avarage: " + average);
        }
        System.out.println("");        

        {
            int[] array = new int[] {11, 22, 33, 44, 44};
            double average = 0;
            double sum = 0;
            int count = 0;
            for (int element : array){
                if (element % 2 != 0) {
                    count++;
                    sum += element;
                }
            }
            if (count > 0){
                average = sum / count;
            }
            System.out.println("Avarage: " + average);
        }

    }
}
