import java.util.HashMap;
/**
 * Write a description of class test_students here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test_students
{
    // the parameters and the initial populations
    static private final double a1 = 0.1;
    static private final double a2 = 0.01;
    static private final double b1 = 0.01;
    static private final double b2 = 0.00002;
    static private final double hare = 300;
    static private final double lynx = 20;
    
    /**
     * Prints the populations from array
     */
    private static void print_pops(double[] pops)
    {
        System.out.println("Hare population: " + pops[0]);
        System.out.println("Lynx population: " + pops[1]);
    }
    
    
    private static void test_engine(Student t2)
    {
        HashMap<String, Integer> test_cases = new HashMap<String, Integer>() 
        {
            {
                put("one",1);
                put("two",1);
                put("20",18);
                put("100",80);
                put("200",100);
            }
            ;
        }
        ;
        
        double[] A = {a1,a2};
        double[] B = {b1,b2};
        double[] T2 = {hare, lynx};
        
        System.out.println("Initial state:");
        print_pops(T2);
        
        System.out.println("After one turn:");
        T2 = t2.preyPredLV(T2,A,B,test_cases.get("one"));
        print_pops(T2);

        System.out.println("After two turns:");
        T2 = t2.preyPredLV(T2,A,B,test_cases.get("two"));
        print_pops(T2);

        System.out.println("After 20 turns:");
        T2 = t2.preyPredLV(T2,A,B,test_cases.get("20"));
        print_pops(T2);
        
        System.out.println("After 100 turns:");
        T2 = t2.preyPredLV(T2,A,B,test_cases.get("100"));
        print_pops(T2);
        
        System.out.println("After 200 turns:");
        T2 = t2.preyPredLV(T2,A,B,test_cases.get("200"));
        print_pops(T2);     
    }
    
    public static void main(String[] args)
    {         
        student1 a = new student1();
        System.out.println("Student1:");
        test_engine(a);
        
        student2 b = new student2();
        System.out.println("Student2:");
        test_engine(b);
        
        student3 c = new student3();
        System.out.println("Student3:");
        test_engine(c);
        
        student4 d = new student4();
        System.out.println("Student4:");
        test_engine(d);
    }
}
