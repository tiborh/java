package which_method;


/**
 * A top class. Interesting stuff happens in sub classes
 * 
 * @author UC San Diego
 * @version 0.01
 */
public class Person
{
    public void method1()
    {
        System.out.print("Person 1 ");
    }
        
    public static void pmain()
    {
        Person p1 = new Person();
        p1.method1();
        System.out.println();
    }
}
