
/**
 * Based on an exercise in  MITx: 6.005.1x Software Construction in Java 
 * 
 * @author tibor
 * @version 0.01
 */
public class Bool
{
    /** Inner state */
    private final Boolean state;

    /**
     * Constructor for objects of class Bool
     */
    public Bool()
    {
        state = false;
    }

    /**
     * Initial state can be set with a Boolean value
     * 
     * @param initState initial state
     */
    public Bool(Boolean initState)
    {
        state = initState;
    }

    /**
     * Initial state can be set with an integer
     * 0: false
     * other values: true
     * 
     * @param initState initial state
     */
    public Bool(int initState)
    {
        state = initState == 0 ? false : true;
    }
        
    /**
     * Create and return a new Bool object
     * 
     * @return new Bool object with "true" initial state
     */
    public Bool createTrue () { return(new Bool(true)); }

    /**
     * Create and return a new Bool object
     * 
     * @return new Bool object with "false" initial state
     */
    public Bool createFalse () { return(new Bool()); }
    
    /**
     * The "and" logical operation between two Bool objects
     * 
     * @param other the other one of the compared
     * @return logical "and" result in as a Bool object
     */
    public Bool and(Bool other)
    {
        return(new Bool(state && other.state));
    }
    
    /**
     * The "or" logical operation between two Bool objects
     * 
     * @param other the other one of the compared
     * @return logical "or" result in as a Bool object
     */
    public Bool or(Bool other)
    {
        return(new Bool(state || other.state));
    }
    
    /**
     * The "not" logical operation between two Bool objects
     * 
     * @param one one of the compared
     * @return logical "or" result in as a Bool object
     */
    public Bool not()
    {
        return(new Bool(!state));
    }
    
    public String toString() { return("" + state); }
    
    public static void main (String[] argv)
    {
        Bool b1 = new Bool();
        Bool b2 = b1.createTrue();
        Bool b3 = b1.not();
        
        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);
        System.out.println("b3: " + b3);
        System.out.println("b1 or b2: " + b1.or(b2));
        System.out.println("b1 and b2: " + b1.and(b2));
        System.out.println("b1 or b2 and b3: " + b1.or(b2).and(b3));
        System.out.println("not b1: " + b1.not());
    }
}
