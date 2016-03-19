import comp102x.IO;
/**
 * Expected output when the main method is invoked
 * you can assume the code in the main method is correct
 * 
 * This is: Joe ?
 * This is: Mark 42
 * This is: Marcus 34
 * You must be joking +_+
 * 3 ... 2 ... 1 ... BOOM!
 */
public class iron_man2
{
    private String id = "?";
    private String name = "Joe";
    
     /**
     * Constructor for objects of class iron_man2
     */
    public iron_man2() {}
    
     /**
     * Another constructor for objects of class iron_man2
     */
    public iron_man2(String ini_name, String ini_id) {
        name = ini_name;
        id = ini_id;
    }
    
     /**
     * a private method
     */
    private void dance() {
        IO.outputln("You must be joking +_+");
    }
    
     /**
     * method to call a private method
     */
    public void clean_slate_protocol() {
        dance();
        IO.outputln("3 ... 2 ... 1 ... BOOM!");
    }
    
     /**
     * Sets the name
     */
    public void setName(String givenName) {
        name = givenName;
    }
    
     /**
     * sets the ID
     */
    public void setID(String givenId) {
        id = givenId;
    }
    
     /**
     * gets name and ID
     */
    public String get_name() {
        // ("Mark " + id) concatenates "Mark " and id to form a character string
        return name + " " + id;
    }

    
    /**
     * The main method
     * 
     * @param   arguments: not used
     * @return  void method 
     */
    public static void main(String[] args)
    {
        // construct an IronMan using the default constructor
        iron_man2 default_iron_man = new iron_man2();
        String name = default_iron_man.get_name();
        IO.outputln("This is: " + name);
        
        // construct an iron_man using the constructor with argument
        iron_man2 mark42 = new iron_man2("Mark","42");
        IO.outputln("This is: " + mark42.get_name());
        
        //changing data
        mark42.setName("Marcus");
        mark42.setID("34");
        IO.outputln("This is: " + mark42.get_name());
        mark42.clean_slate_protocol();
    }
}
