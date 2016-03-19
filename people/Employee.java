
/**
 * Employee class to help demonstrate upcasting
 * 
 * @author University of Madrid
 * @version 0.01
 */
class Employee extends Person{
    private static int default_salary = 1000;
    private int salary;
    
    Employee(String name){
        super(name);
        salary = default_salary;
    }
    
    public int get_default_salary()
    {
        return(default_salary);
    }
    
    public int get_salary()
    {
        return(this.salary);
    }
    
    public int set_salary(int salary)
    {
        this.salary = salary;
        return(this.salary);
    }
    
    public int raise_salary(int raise)
    {
        this.salary += raise;
        return(this.salary);
    }
    
    public void monthly_statement()
    {
        System.out.println();
    }
    
    public String toString()
    {
        return super.toString() + "\t" + salary;
    }
    
}
