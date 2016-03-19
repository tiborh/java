
/**
 * To help prepare Percolation statistics.
 * 
 * @author tibor
 * @version 0.01
 */
public class PercolationStats implements PercolateStats
{
   private final int grid_size;
   private final int nu_of_experiments;
   /** Fraction of open sites are store here at the time of percolation */
   private double[] test_results;
   /**
    * Perform T independent computational experiments on an N-by-N grid
    * 
    * @param N N-by-N sized grid is used
    * @param T T number of experiments are performed
    */
   public PercolationStats(int N, int T)
   {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException();
        else
        {
            grid_size = N;
            nu_of_experiments = T;
            test_results = new double[T];
        }   
    }
   
   /**
    * sample mean of percolation threshold
    * 
    * @return the mean value of what number was open when the system percolated
    */
   public double mean()
   {
       double sum = 0.0;
       for (double an_item : test_results)
            sum += an_item;

       return sum / nu_of_experiments;
   }
   
   /**
    * sample standard deviation of percolation threshold
    * 
    * @return the standard deviation of percolation numbers in the experiments
    */
   public double stddev()
   {
       double numerator = 0.0;
       double average = mean();

       for (double an_item : test_results)
            numerator += Math.pow((an_item - average),2);
       
       return numerator / (nu_of_experiments - 1);
   }

   /**
    * @return lower bound of the 95% confidence interval
    */
   public double confidenceLo()
   {
       return mean() - (1.96 * stddev() / Math.sqrt(nu_of_experiments));
   }
   
   /**
    * @return upper bound of the 95% confidence interval
    */
   public double confidenceHi()
   {
       return mean() + (1.96 * stddev() / Math.sqrt(nu_of_experiments));
   }
   
   /**
    * test client, description to follow later:
    */
   public static void main(String[] args)
   {
       int gridSize = Integer.parseInt(args[0]);
       int nuOfExps = Integer.parseInt(args[1]);
       PercolationStats anItem = new PercolationStats(gridSize,nuOfExps);
       System.out.format("%-23s = %lf","mean",anItem.mean());
       System.out.format("%-23s = %lf","stddev",anItem.stddev());
       System.out.format("%-23s = %lf, %lf","95% confidence interval",anItem.confidenceLo(),anItem.confidenceHi());
   }
}
