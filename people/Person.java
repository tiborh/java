
/**
 * person super class to help demonstrate upcasting
 * 
 * @author University of Madrid
 * @version 0.02
 */
abstract class Person implements Comparable<Person>
{
    private String name;
    private static final String default_name = "Doe";
 
    Person(String name)
    {
        this.name = name;
    }
    
    Person()
    {
        this(default_name);
    }
        
    String get_name()
    {
        return name;
    }
    
    String set_name(String name)
    {
        this.name = name;
        return(this.name);
    }
    
    void print()
    {
        System.out.print("My name is " + name);
    }
    
    @Override
    public int compareTo(Person o)
    {
        return this.get_name().compareTo(o.get_name());
    }
    
    public abstract void monthly_statement();
    
    public String toString()
    {
        return name;
    }
}
