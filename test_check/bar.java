import java.util.Arrays;
/**
 * Write a description of class bar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bar
{
    /** Precondition: array contains only positive values. 
     * @param num a positive int
     */
    static int[] bar(int[] array, int num, int lim){
        int i = 0;
        int v = 0;
        int countA = 0;
        int countB = 0;
        while ((i < array.length) && (array[i] + num < lim)){
            if (array[i] <= array[v]){
                v = i; /* Statement A */
                ++countA;
                //System.out.println("/* Statement A */");
            }  
            i++; /* Statement B */
            ++countB;
            //System.out.println("/* Statement B */");
        }
        //System.out.println(v);
        int[] retval = {countA,countB};
        return retval;
    }

    public static void main(String[] args)
    {
        int case502 = 0;
        int case200 = 0;
        int case8310 = 0;
        for (int i = 1; i < 12; ++i)
        {
            for (int k=0; k < 1000000; ++k)
            {
                int[] sample = new int[i];
                for(int j = 0; j < i; ++j)
                {
                    sample[j] = (int)(Math.random() * 4);
                }
                int num = (int)(Math.random() * 4);
                //System.out.println("Array: " + Arrays.toString(sample));
                //System.out.println("Num: " + num);
                int[] tres1 = bar(sample,num,5);
                if (tres1[0] == 0 && tres1[1] == 2)
                    ++case502;
                    //System.out.println(5 + "<>" + tres1[0] + "<>" + tres1[1] + "<>" + Arrays.toString(sample));
                int[] tres2 = bar(sample,num,2);
                if (tres2[0] == 0 && tres2[1] == 0)
                    ++case200;
                    //System.out.println(2 + "<>" + tres2[0] + "<>" + tres2[1] + "<>" + Arrays.toString(sample));
                int[] tres3 = bar(sample,num,8);
                if (tres3[0] == 3 && tres3[1] == 10)
                    ++case8310;
                    //System.out.println(8 + "<>" + tres3[0] + "<>" + tres3[1] + "<>" + Arrays.toString(sample));

            }
        }
        System.out.println("5 0 2: " + case502);
        System.out.println("2 0 0: " + case200);
        System.out.println("8 3 10: " + case8310);
    }
}
