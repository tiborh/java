package Arrays;

public class Array1DSortable extends Array1D
{
    void swap(int i, int j) {
        int temp = theArray[i];
        theArray[i] = theArray[j];
        theArray[j] = temp;
    }

    void sort() {
        int n = theLength;
        for(n = theLength; n > 0; --n)
        {
            int k = 1;
            while (k != n)  {
                if (theArray[k-1] > theArray[k])
                    swap(k-1, k);
                k = k+1;
            }
        }
    }

    /** in Array1DbSortable */
    public static void main(String[] argv)
    {
        Array1DSortable testarr = new Array1DSortable();
        testarr.fill();
        System.out.println(testarr);
        testarr.sort();
        System.out.println(testarr);
    }
}
