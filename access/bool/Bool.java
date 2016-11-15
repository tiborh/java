package bool;

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
     * Initial state can be set with another Bool object
     * 
     * @param another Bool object
     */
    public Bool(Bool other)
    {
        state = other.isTrue();
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

    /**
     * Get information about the state.
     * 
     * @return boolean value reflecting the state of the Bool object
     */
    public Boolean isTrue() { return state == true; }

    public Bool clone() { return new Bool(this); }
    
    /**
     * Get the state as a string.
     * 
     * @return state as a string
     */
    public String toString() { return("" + state); }

    public boolean equals(Object obj)
    {
        if (this == null && obj == null)
        {
            return true;
        }
        if (obj == null || this == null)
        {
            return false;
        }
        if (!Bool.class.isAssignableFrom(obj.getClass()))
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        final Bool other = (Bool) obj;
        if (this.isTrue() != other.isTrue()) {
            return false;
        }
        return true;
    }

    /**
     * A few simple operations to show how the object can be used.
     * 
     * @param argv arguments are not used
     */
    public static void main (String[] argv)
    {
        Bool b1 = new Bool();
        Bool b2 = new Bool(true);
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
