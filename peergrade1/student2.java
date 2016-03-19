
/**
 * Write a description of class student2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class student2 extends Student
{
    /**
     * @param preyPred array consists of preyPred[0] and preyPred[1] which is the initial population of Snowhares and Lynx respectively
     * @param a is an array of double type
     * @param b is an array of double type
     * @param n is an integer (has positive value greater than 0)
     * Method Returns totalCount array that has the population of Lynx and Snowhare after 'n' time period 
     * tempVar is an array that is a temporary storage to keep the last iteration result
     */
    double[] preyPredLV(double [] preyPred, double[] a, double[] b, int n){

        double[] tempVar = new double[2];
        tempVar[0]=0; 
        tempVar[1]=0;

        double[] totalCount = new double[2];
        totalCount[0] = 0; 
        totalCount[1] = 0;

        totalCount[0] = preyPred[0]*(1+ a[0]-a[1]*preyPred[1]);
        totalCount[1] = preyPred[1]*(1- b[0]+b[1]*preyPred[0]);

        for(int i=1;i<n;i++)
        {
            tempVar[0] = totalCount[0];
            tempVar[1] = totalCount[1];

            totalCount[0] = tempVar[0]*(1+ a[0]-a[1]* tempVar[1]);
            totalCount[1] = tempVar[1]*(1- b[0]+b[1]* tempVar[0]);

        }

        return totalCount;
    }
}
