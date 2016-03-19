
/**
 * integer division with remainder
 * 
 * @author tibor
 * @version 0.01
 */
public class int_div
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int m;
    private int n;

    /**
     * @param  divident   the divident
     * @param  divisor    the divisor
     */
    public int_div(int divident, int divisor)
    {
        // initialise instance variables
        assert(divident >= 0);
        assert(divisor > 0);
        m = divident;
        n = divisor;
        x = m;
        y = 0;
        division();
    }

    /**
     * To calculate the quotient and the remainder
     * 
     * 
     * @return     void 
     */
    private void division()
    {
        while (x >= n)
        {
            x = x - n;
            y++;
        }
    }
    
    public void print_results()
    {
        System.out.println("Quotient: " + get_quotient());
        System.out.println("Remainder: " + get_remainder());
    }
    
    public void print()
    {
        System.out.format("%d // %d == %d (%d)\n",m,n,y,x);
    }
        
    public int get_quotient()
    {
        return y;
    }
    
    public int get_remainder()
    {
        return x;
    }
}
