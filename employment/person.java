/**
 * Person object, based on Core Java, Vol 1, Inheritance
 * 
 * @author tibor
 * @version 0.1
 */
public class person
{
    private String first_name = "Joe";
    private String surname = "Doe";
    
    public person(){}
    
    public person(String fname, String sname)
    {
        first_name = fname;
        surname = sname;
    }
    
    public String[] get_name_array()
    {
        String[] name = {surname, first_name};
        return name;
    }

    public String get_name_string()
    {
        String name = surname + ", " + first_name;
        return name;
    }

    
    public String get_surname()
    {
        return surname;
    }
    
    public String get_firstname()
    {
        return first_name;
    }
    
    public static void main(String[] argv)
    {
        person a_person = new person();
        System.out.println(a_person.get_name_string());
    }
}
