
/**
 * Write a description of class ConstructorReference here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConstructorReference
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ConstructorReference
     */
    public ConstructorReference()
    {
        System.out.println("No arg");
    }
    
    public ConstructorReference(String one)
    {
        this();
        System.out.println(one);
    }
}
