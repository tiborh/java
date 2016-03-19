package employee;

public class testEmployees
{
    public static void main(String[] args)
    {
        System.out.println("Single variables as types Employee:");
        Employee e1 = new Employee();
        e1.speak();
        Employee e2 = new MarketingEmployee();
        e2.speak();
        Employee e3 = new PublicRelationsEmployee();
        e3.speak();

        System.out.println();
        
        Employee[] emps = new Employee[3];
        emps[0] = new Employee();
        emps[1] = new MarketingEmployee();
        emps[2] = new PublicRelationsEmployee();
        
        System.out.println("Three different in an Employee array:");
        for (int i = 0; i < emps.length; ++i)
            emps[0].speak();           
    }
}
