import java.util.LinkedList;
/**
 * factoring a long integer
 * 
 * @author Robert Sedgewick, modified by tibor
 * @version 0.0.1
 */
public class Factoring
{
    // the number to factor
    private final long the_number;
    private LinkedList<Long> the_factors = new LinkedList<>();

    /**
     * Get a value for the_number
     */
    public Factoring()
    {
        GetInput anInput = new GetInput();
        the_number = anInput.getNumber();
    }

    /**
     * the number to factor is the_number
     * 
     * @param input the number to factor
     */
    public Factoring(long input)
    {
        the_number = input;
    }

    public long getNumber()
    {
        return the_number;
    }
    
    public void printList()
    {
        Common.printList(the_factors);
    }
    
    /**
     * write the output int the format 
     * the_number = factor1 * factor2 * ... * factorN
     */
    public boolean factoring ()
    {    
        long tmp_number = the_number;
        //System.out.printf("%d = ",tmp_number);
        for(long the_factor = 2; the_factor <= tmp_number / 2; the_factor++)
        {
            if (tmp_number % the_factor == 0)
            {
                tmp_number /= the_factor;
                the_factors.add(the_factor);
                //System.out.printf("%d * ",the_factor);
                the_factor = 1;
            }
        }
        the_factors.add(tmp_number);
        //System.out.printf("%d\n",tmp_number);
        if (the_number == tmp_number)
            return true;
        else
            return false;
    }
    
    public static void main(String[] argv)
    {
        GetInput aNumber;
        if (argv.length > 0)
            aNumber = new GetInput(argv[0]);
        else
            aNumber = new GetInput();
        Factoring aFactoring = new Factoring(aNumber.getNumber());
        if (aFactoring.factoring() == true)
            System.out.printf("%d is a prime.",aFactoring.getNumber());
        else
            aFactoring.printList();
    }
}
