package which_method;


/**
 * UnderGrad redefines only method2 of Student
 * 
 * @author UC San Diego
 * @version 0.01
 */
public class UnderGrad extends Student
{
    public void method2()
    {
        System.out.print("UnderGrad 2 ");
    }
    
    public static void umain()
    {
        System.out.println("As an Undergraduate:");
        UnderGrad u1 = new UnderGrad();
        u1.method1();
        System.out.println();
        System.out.println("As a Person:");
        Person p1 = new UnderGrad();
        p1.method1();
        System.out.println();
    }
}
