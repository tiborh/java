package Arrays;

public class Array1Db extends Array1D
{
    @Override
    public int findMaxIndex()
    {
        int k = 0;
        int x = k;    
        while (k < theLength-1) {
            ++k;
            if (theArray[k] > theArray[x]) { 
                x = k;
            }
        }
        return x;
    }

    @Override
    public int findMin()
    {
        int k=1;
        int min = theArray[0];
        while (k != theLength) {
            if (theArray[k] < min)
                min = theArray[k];
            k++;            
        }
        return min;
    }

    /** in Array1Db */
    public static void main(String[] argv)
    {
        for (int i = 0; i < 10; ++i)
        {
            Array1Db testarr = new Array1Db();
            testarr.fill();
            System.out.println(testarr + "\t max: " + testarr.findMax() 
                + "\t max index: " + testarr.findMaxIndex()
                + "\t min: " + testarr.findMin());
        }
    }
}
