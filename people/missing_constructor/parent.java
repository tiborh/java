package missing_constructor;

/**
 * a class where the default constructor does not exist, causing possible problems in child classes
 * 
 * @author UC San Diego
 * @version 0.01
 */
public class parent
{
    private String name;
    
    public parent(String name)
    {
        super();
        this.name = name;
    }
    
    public void set_name(String name)
    {
        this.name = name;
    }
}
