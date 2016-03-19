/**
 * The class for administration employees
 * 
 * @author tibor
 * @version 0.01
 * @since 2015-06-14
 */
public class AdministrationEmployee extends Employee
{
    /** the salary for an administration employee */
    static final double START_SALARY = 18000;

    /**
     * constructor for an administration employee
     * 
     * @param aName  the name of the employee
     */        
    public AdministrationEmployee(String aName)
    {
        super(aName,Employee.ADMINISTRATION,Employee.NOYEAR,Employee.TEMPORARY);
        setSalary();
    }

    /**
     * sets the salary of the employee
     */        
    void setSalary()
    {
        super.setSalary(START_SALARY);
    }
}