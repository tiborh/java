
/**
 * Write a description of class student4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class student4 extends Student
{
    double[] preyPredLV(double[] preyPred, double[] a, double[] b, int n)
    {
        while (n != 0)
        {
            double x = preyPred [0];
            double y = preyPred [1];
            preyPred[0] = x * (1 + a[0] - a[1] * y);
            preyPred[1] = y * (1 - b[0] + b[1] * x);
            --n;
        }
        return preyPred;
    }
}
