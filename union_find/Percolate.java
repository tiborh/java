
/**
 * Interface to assignment Percolation
 * 
 * @author Tibor
 * @version 0.01
 */
public interface Percolate
{   
    public void open(int i, int j);             // open site (row i, column j) if it is not already
    
    public boolean isOpen(int i, int j);        // is site (row i, column j) open?
    
    public boolean isFull(int i, int j);        // is site (row i, column j) full?
        
    public boolean percolates();                // does the system percolate?
    
}
