/**
 * The class for engineering employees
 * 
 * @author tibor
 * @version 0.01
 * @since 2015-06-14
 */
public class EngineeringEmployee extends Employee
{
    /** starting salary for an engineering employee */
    static final double START_SALARY = 25000;
    /** yearly increase of an engineering employee's salary */
    static final double YEARLY_RAISE = 2500;
    
    /**
     * constructor for an engineering employee
     * 
     * @param aName  the name of the employee
     * @param aYears the number of years the employee has been working for the company
     */    
    public EngineeringEmployee(String aName, int aYears, int aContract)
    {
        super(aName,Employee.ENGINEERING,aYears,aContract);
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