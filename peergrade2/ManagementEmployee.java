/**
 * The class for management employees
 *
 * @author tibor
 * @version 0.01
 * @since 2015-06-14
 */
public class ManagementEmployee extends Employee
{
    /** starting salary for a management employee */
    static final double START_SALARY = 40000;
    /** yearly increase of a management employee's salary */
    static final double YEARLY_RAISE = 6000;
    
    /**
     * constructor for a management employee
     * 
     * @param aName  the name of the employee
     * @param aYears the number of years the employee has been working for the company
     */
    public ManagementEmployee(String aName, int aYears)
    {
        super(aName,Employee.MANAGEMENT,aYears,Employee.INDEFINITE);
        setSalary();
    }
    
    /**
     * sets the salary of the employee based on starting salary and yearly increase
     */
    void setSalary()
    {
        double theSalary = START_SALARY + super.getYears() * YEARLY_RAISE;
        super.setSalary(theSalary);
    }
}
