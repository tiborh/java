
/**
 * Write a description of class student1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class student1 extends Student
{
    /**
     * @param preyPred
     * @param a
     * @param b
     * @param n
     * @return
     */
    double[] preyPredLV(double [] preyPred, double[] a, double[] b, int n)
    {
        // Snowshoe hare population
        double h;
        // Lynx population
        double l;
        // loop variable
        int x = 1;
        while (x <= n)
        {
            h = preyPred[0];
            l = preyPred[1];

            // Lotka-Volterra model
            preyPred[0] = (1+a[0]-a[1]*l)*h;
            preyPred[1] = (1-b[0]+b[1]*h)*l;

            x++;
        }
        return preyPred;
    }
}
