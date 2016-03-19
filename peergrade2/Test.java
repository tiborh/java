public class Test
{
    public static void main(String[] args)
    {

        // total salary
        double total = 0.0;

        // ManagementEmployee test
        ManagementEmployee me = new ManagementEmployee("Bill", 9);
        System.out.println(me.toString());
        System.out.println("My name is " + me.getName() + " and my salary is " + me.getSalary() + " bitcoins");
        total += me.getSalary();

        try 
        {
            System.out.println("Testing lower names limit.");
            me.setName("");
            System.out.println("New name: " + me.getName());            
        } catch (IllegalArgumentException e)
        {
            System.err.println("Name change has failed. " + e);
        }
        
        try
        {
            System.out.println("Testing with invalid dep ID.");
            me.setDep(3);
            System.out.println("New department ID: " + me.getDep());
            System.out.println("New department: " + me.getDepartment());
        } catch (IllegalArgumentException e)
        {
            System.err.println("Dep change has failed. " + e);
        }
        
        try
        {
            System.out.println("Testing dep mismatch.");
            me.setDep(2);
            System.out.println("New department ID: " + me.getDep());
            System.out.println("New department: " + me.getDepartment());
        } catch (IllegalArgumentException e)
        {
            System.err.println("Dep change has failed. " + e);
        }
        
        try 
        {
            System.out.println("Testing lower years limit.");
            me.setYears(-1);
            System.out.println("New years: " + me.getYears());            
        } catch (IllegalArgumentException e)
        {
            System.err.println("years change has failed. " + e);
        }
        
        try 
        {
            System.out.println("Testing upper years limit.");
            me.setYears(66);
            System.out.println("New years: " + me.getYears());            
        } catch (IllegalArgumentException e)
        {
            System.err.println("years change has failed. " + e);
        }
        
        try
        {
            System.out.println("Testing contract mismatch.");
            me.setContract(Employee.TRAINING);
            System.out.println("New contract ID: " + me.getContract());
        } catch (IllegalArgumentException e)
        {
            System.err.println("contract change has failed. " + e);
        }
        
        try 
        {
            System.out.println("Testing lower salary limit.");
            me.setSalary(-0.01);
            System.out.println("New salary: " + me.getSalary());            
        } catch (IllegalArgumentException e)
        {
            System.err.println("salary change has failed. " + e);
        }
        
        // total salary calculation
        System.out.println("The total salary is " + total + " bitcoins.");
    }
}