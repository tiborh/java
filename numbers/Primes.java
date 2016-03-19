import java.util.LinkedList;
/**
 * To search for prime numbers. Inspired by the factoring class.
 * 
 * @author tibor
 * @version 0.0.1
 */
public class Primes
{
    // instance variables - replace the example below with your own
    private final long number_of_primes;
    private LinkedList<Long> the_primes = new LinkedList<>();

    /**
     * Constructors for objects of class Primes
     */
    public Primes()
    {
        GetInput anInput = new GetInput();
        number_of_primes = anInput.getNumber();
        fillPrimes();
    }
    
    public Primes(long the_number)
    {
        number_of_primes = the_number;
        fillPrimes();
    }

    public long getNumber()
    {
        return number_of_primes;
    }
    
    public void printList()
    {
        Common.printList(the_primes);
    }

    public boolean is_prime(long the_number)
    {
        long saved_number = the_number;
      
        for(long the_factor = 2; the_factor <= the_number / 2; the_factor++)
        {
            if (the_number % the_factor == 0)
        	{
        	    the_number /= the_factor;
        	    the_factor = 1;
        	}
        }
        
        if (saved_number == the_number)
            return true;
        else
            return false;
    }
    
    /**
     * fills in list with the desired number of primes 
     */
    private void fillPrimes()
    {
       long prime_counter = number_of_primes;
       long the_number = 2;
       
       while(prime_counter > 0)
       {           
           if (is_prime(the_number))
           {
               the_primes.add(the_number);
               prime_counter--;
           }
           the_number++;
       }
    }
    
    public static void main(String[] argv)
    {
        GetInput aNumber;
        if (argv.length > 0)
            aNumber = new GetInput(argv[0]);
        else
            aNumber = new GetInput();
        Primes aPrimeList = new Primes(aNumber.getNumber());
        aPrimeList.printList();
    }
}
