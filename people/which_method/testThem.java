package which_method;


/**
 * Test the classes from the outside
 * 
 * @author tibor
 * @version 0.01
 */
public class testThem
{
    public static void main(String[] argv)
    {
        System.out.println("As an Undergraduate:");
        UnderGrad u1 = new UnderGrad();
        u1.method1();
        System.out.println();
        System.out.println("Undergrad as a Person:");
        Person p1 = new UnderGrad();
        p1.method1();
        System.out.println();
        System.out.println("Student as a Person:");
        Person p2 = new Student();
        p2.method1();
        System.out.println();
    }
}
