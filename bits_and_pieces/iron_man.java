import comp102x.IO;
/**
 * Expected output when the main method is invoked
 * you can assume the code in the main method is correct
 * 
 * This is: Mark ?
 * This is: Mark 42
 * You must be joking +_+
 * 3 ... 2 ... 1 ... BOOM!
 */
public class iron_man
{
    private String id = "?";
    private String name = "Joe";
    
     /**
     * Constructor for objects of class iron_man
     */
    public void iron_man() {}
    
    private void dance() {
        IO.outputln("You must be joking +_+");
    }
    
    public void clean_slate_protocol() {
        IO.outputln("3 ... 2 ... 1 ... BOOM!");
    }
    
    public void setName(String givenName) {
        name = givenName;
    }
    
    public void setID(String givenId) {
        id = givenId;
    }
    
    public String get_name() {
        // ("Mark " + id) concatenates "Mark " and id to form a character string
        return name + " " + id;
    }

    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(String[] args)
    {
        // construct an IronMan using the default constructor
        iron_man default_iron_man = new iron_man();
        String name = default_iron_man.get_name();
        IO.outputln("This is: " + name);
        
        // construct an iron_man using the constructor with argument
        iron_man mark42 = new iron_man();
        mark42.setName("Mark");
        mark42.setID("42");
        IO.outputln("This is: " + mark42.get_name());
        mark42.clean_slate_protocol();
    }
}
