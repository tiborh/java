
/**
 * Write a description of class student3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class student3 extends Student
{
    /**
     * @author Jim Ryals <jwryals@gmail.com>
     * @version 1.0 
     * @since May 20, 2015
     * <p>
     * calculates the change in populations of hares and lynxes
     * <p>
     * for loop iterates through the formula for change in population of each of hare and lynx
     * <p>
     * @param hare is a temporary variable to hold outcome formula for lynx population
     * @param lynx is a temporary variable to hold outcome of formula for hare population
     * all other params are as described in assignment Week 3 Peer Review
     */
    double[] preyPredLV(double [] preyPred, double[] a, double[] b, int n){
        for (int i = 1; i<= n; i++){
            double hare = preyPred[0] * (1 + a[0] - a[1] * preyPred[1]);
            double lynx = preyPred[1] * (1 - b[0] + b[1] * preyPred[0]);
            preyPred[0] = hare;
            preyPred[1] = lynx;

        }
        return preyPred;
    }
}
