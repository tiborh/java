
/**
 * Teacher class
 * 
 * @author tibor 
 * @version 0.02
 */
public class Teacher extends Employee
{
    private String ID = "unset";

    /**
     * Constructor for objects of class Teacher
     */
    public Teacher(String name)
    {
        super(name);
    }
    
    public Teacher(String name, String ID)
    {
        this(name);
        this.ID = ID;
    }

    public String set_id(String ID)
    {
        this.ID = ID;
        return this.ID;
    }
    
    public String get_id()
    {
        return this.ID;
    }

    public String toString()
    {
        return super.toString() + "\t" + ID;
    }
}
