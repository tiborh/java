/**
 * Interface to Union Find Classes
 * 
 * @author tibor
 * @version 0.01
 */
public interface UF
{
    /**
     * add connection between p and q
     * 
     * @param  p   one of the points to connect
     * @param  q   the other point to connect
     */
    public void union(int p, int q);
    
    /**
     * are p and q in the same component?
     * 
     * @param p one of the points to test
     * @param q the other points to test
     * @return true if p and q are connected, false otherwise
     */
    boolean connected(int p, int q);
    
    /**
     * gets element number i
     * 
     * @param i the index of the element
     * @return element number i
     */
    int get_id_i(int i);
        
    /**
     * sets element number i to val
     * 
     * @param i the index of the element to set
     * @param val the value to which the element is to be set
     */
    void set_id_i(int i, int val);
    
    /**
     * component identifier for p (0 to N – 1)
     * 
     * @param p find a component
     * @return index of the object
     */
    int find(int p);
    
    /**
     * number of components
     * 
     * @return the number of components
     */
    int count();

}
