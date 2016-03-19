package which_method;


/**
 * Student overwrites both methods in Person
 * 
 * @author UC San Diego
 * @version 0.01
 */
public class Student extends Person
{
    public void method1()
    {
        System.out.print("Student 1 ");
        super.method1();
        method2(); // "this." is implicit
    }

    public void method2()
    {
        System.out.print("Student 2 ");
    }

    public static void smain()
    {
        Student s1 = new Student();
        s1.method1();
        System.out.println();
    }
}
