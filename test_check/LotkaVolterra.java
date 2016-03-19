import java.util.Map;
import java.util.HashMap;
/**
 * <p>An implementation of the Predator-Prey model using the Lotka-Volterra model as defined by</p>
 * <ul>
 * <li>H[n+1] = H[n] + a1 * H[n] - a2*H[n]*L[n] = H[n] * (1 + a1 - a2*L[n]) </li>
 * <li>L[n+1] = L[n] - b1 * L[n] + b2*H[n]*L[n] = L[n] * (1 - b1 +b2*H[n])</li>
 * </ul>
 * <p>where</p>
 * <ul>
 * <li>H stands for "snowshoe hare"</li>
 * <li>L stands for lynx</li>
 * <li>[n] is the corrent population</li>
 * <li>a1*H[n] is the growth of hare population in lack of lynxes</li>
 * <li>-b1*L[n] is the decrease of lynx population in lack of hares</li>
 * <li>-a2*H[n]*L[n] primary loss of hare population is due to the predating activities of the lynx population</li>
 * <li>b2*H[n]*L[n] growth of the lynx population is due to feeding on the showshoe hare population</li>
 * </ul>
 * <p>the constants for this modelling will be:</p>
 * <ul>
 * <li>a1 = 0.1</li>
 * <li>a2 = 0.01</li>
 * <li>b1 = 0.01</li>
 * <li>b2 = 0.00002</li>
 * </ul>
 * <p>Initial state will be:</p>
 * <ul>
 * <li>Initial hare population: 300</li>
 * <li>Initial lynx population: 20</li>
 * </ul>
 * 
 * @author tibor
 * @version 0.01
 * @since 2015-05-26
 */
public class LotkaVolterra
{
    // the parameters and the initial populations
    static private final double a1 = 0.1;
    static private final double a2 = 0.01;
    static private final double b1 = 0.01;
    static private final double b2 = 0.00002;
    private double hare;
    private double lynx;

    /**
     * constructor to initialise the initial populations
     */
    public LotkaVolterra()
    {
        hare = 300;
        lynx = 20;
    }
    
    double get_hare()
    {
        return hare;
    }
    
    double get_lynx()
    {
        return lynx;
    }
    
    /**
     * The population for the next turn is calculated here.
     * 
     * @param  n          The number of periods for which the experiment runs
     * 
     */
    void preyPredLV(int n)
    {
        double new_hare;
        double new_lynx;
        for(int i = 0; i < n; ++i)
        {
            new_hare = hare + a1 * hare - a2 * hare * lynx;
            new_lynx = lynx - b1 * lynx + b2 * hare * lynx;
            hare = new_hare;
            lynx = new_lynx;
        }
    }
    
    /**
     * The population for the next turn is calculated here.
     * 
     * @param  preyPred   The initial population of snowshoe hares, preyPred[0]<br />
     *                    The initial population of lynx, preyPred[1]
     * @param  a          An array called "a" with 2 doubles containing the constants a1 and a2
     * @param  b          An array called "b" with 2 doubles containing the constants b1 and b2
     * @param  n          The number of periods for which the experiment runs
     * @return            the array "preyPred", in a way that it should contain:<br />
     *                    The population of snowshoe hares at the given number of periods "n" (H[n]) in preyPred[0]<br />
     *                    The population of lynxes at the given number of periods "n" (L[n]) in preyPred[1]
     */
    double[] preyPredLV(double[] preyPred, double[] a, double[] b, int n)
    {
        // populations should not be overwritten till the end of each round of calculations
        double[] tmp = new double[2];
        for(int i = 0; i < n; ++i)
        {
            tmp[0] = preyPred[0] + a[0] * preyPred[0] - a[1] * preyPred[0] * preyPred[1];
            tmp[1] = preyPred[1] - b[0] * preyPred[1] + b[1] * preyPred[0] * preyPred[1];
            preyPred[0] = tmp[0];
            preyPred[1] = tmp[1];
        }
        return preyPred;
    }
    
    /**
     * Prints the current populations
     */
    void print_pops()
    {
        System.out.println("Hare population: " + hare);
        System.out.println("Lynx population: " + lynx);
    }

    /**
     * Prints the populations from array
     */
    static void print_pops(double[] pops)
    {
        System.out.println("Hare population: " + pops[0]);
        System.out.println("Lynx population: " + pops[1]);
    }
    
    /**
     * Test cases
     */
    public static void main(String[] args)
    {
        //int[] test_cases = {1,1,18,80,100};
        Map<String, Integer> test_cases = new HashMap<String, Integer>() 
        {
            {
                put("one",1);
                put("two",1);
                put("20",18);
                put("100",80);
                put("200",100);
            }
            ;
        }
        ;
        
        System.out.println("After one turn:");
        LotkaVolterra t1 = new LotkaVolterra();
        t1.preyPredLV(test_cases.get("one"));
        t1.print_pops();

        System.out.println("After two turns:");
        t1.preyPredLV(test_cases.get("two"));
        t1.print_pops();

        System.out.println("After 20 turns:");
        t1.preyPredLV(test_cases.get("20"));
        t1.print_pops();
        
        System.out.println("After 100 turns:");
        t1.preyPredLV(test_cases.get("100"));
        t1.print_pops();
        
        System.out.println("After 200 turns:");
        t1.preyPredLV(test_cases.get("200"));
        t1.print_pops();
        
        
        double[] A = {a1,a2};
        double[] B = {b1,b2};
        LotkaVolterra t2 = new LotkaVolterra();
        double[] T2 = {t2.get_hare(), t2.get_lynx()};
        
        System.out.println("Initial state:");
        print_pops(T2);
        
        System.out.println("After one turn:");
        T2 = t2.preyPredLV(T2,A,B,test_cases.get("one"));
        print_pops(T2);

        System.out.println("After two turns:");
        T2 = t2.preyPredLV(T2,A,B,test_cases.get("two"));
        print_pops(T2);

        System.out.println("After 20 turns:");
        T2 = t2.preyPredLV(T2,A,B,test_cases.get("20"));
        print_pops(T2);
        
        System.out.println("After 100 turns:");
        T2 = t2.preyPredLV(T2,A,B,test_cases.get("100"));
        print_pops(T2);
        
        System.out.println("After 200 turns:");
        T2 = t2.preyPredLV(T2,A,B,test_cases.get("200"));
        print_pops(T2);
    }
}
