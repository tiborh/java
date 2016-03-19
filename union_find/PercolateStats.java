
/**
 * To help implement requirements of percolation statistics to assignment
 * 
 * @author tibor
 * @version 0.01
 */
public interface PercolateStats
{
   public double mean();                     // sample mean of percolation threshold
   public double stddev();                   // sample standard deviation of percolation threshold
   public double confidenceLo();             // returns lower bound of the 95% confidence interval
   public double confidenceHi();             // returns upper bound of the 95% confidence interval
}
