import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
/**
 * The main class which implements all the necessary methods and 
 * defines all the necessary parameters
 * 
 * @author tibor
 * @version 0.01
 * @since 2015-06-14
 */
public class Employee implements Employed
{
    /** a contract type **/
    public static final int TEMPORARY = 0;
    /** a contract type **/
    public static final int TRAINING = 1;
    /** a contract type **/
    public static final int INDEFINITE = 2;
        
    /** contract types mapping**/
    public static final Map<Integer,String> contracts;
    static {
        contracts = new HashMap<Integer, String>();
        contracts.put(TEMPORARY, "temporary");
        contracts.put(TRAINING, "training");
        contracts.put(INDEFINITE, "indefinite");
    }

    /** a department */
    public static final int MANAGEMENT = 0;
    /** a department */
    public static final int ENGINEERING = 1;
    /** a department */
    public static final int ADMINISTRATION = 2;
    
    /** department mapping */
    public static final Map<Integer,String> deps;
    static {
        deps = new HashMap<Integer, String>();
        deps.put(MANAGEMENT, "manager");
        deps.put(ENGINEERING, "engineering");
        deps.put(ADMINISTRATION, "administration");
    }

    /** the name of the employee */
    private String name;

    /** the type of contract */
    private int contract;

    /** number of years in the company */
    private int years;

    /** default when no year has been given */
    public static final int NOYEAR = 0;
    /** default when no salary has been given */    
    public static final double NOSALARY = 0.0;

    /** department to which he/she belongs */
    private String department;
    private int dep;

    /** the salary of the employee */
    private double salary;

    /**
     * The only constructor of the employee class.
     * 
     * @param aName     the name of the new employee
     * @param sDep      the department code of the new employee, see 'deps' for valid codes
     * @param aYears    number of years in employment
     * @param aContract the ID of the contract type, see 'contracts' for valid codes
     */
    public Employee(String aName, int aDep, int aYears, int aContract)
    {
        setName(aName);
        setDepartment(aDep);
        setDep(aDep);
        setYears(aYears);
        setContract(aContract);
        setSalary();
    }

    /**
     * when no salary value is given, salary defaults to NOSALARY
     */
    private void setSalary()
    {
        salary = NOSALARY;
    }

    /**
     * method to set salary
     * 
     * @param aSalary the new salary value
     */
    public void setSalary(double aSalary)
    {
        if (aSalary < NOSALARY)
        {
            System.err.println("Salary cannot smaller than " + NOSALARY + ".");
            throw new IllegalArgumentException();
        }
        else
            salary = aSalary;
    }

    /**
     * get the current salary of the employee
     * 
     * @return salary salary value
     */
    public double getSalary() { return salary; }

    /**
     * get the employee's name
     * 
     * @return name the employee's name
     */    
    public String getName() { return name; }

    /**
     * get the name of the department where the employee works
     * 
     * @return department the name of the department
     */    
    public String getDepartment() { return department; }

    /**
     * get the department code of the department where the employee works
     * 
     * @return dep the department code
     */    
    public int getDep() { return dep; }

    /**
     * get the number of years for which the employee works for the company
     * 
     * @return years the number of employment years
     */    
    public int getYears() { return years; }

    /**
     * get the contract code of the employee
     * 
     * @return contract the contract ID (key)
     */    
    public int getContract() { return contract; }

    /**
     * sets the employee's name
     * 
     * @param aName the name string
     */
    public void setName(String aName) 
    { 
        if(aName.length() < 1)
        {
            System.err.println("Name must be at least one char long.");
            throw new IllegalArgumentException();
        }
        else
            name = aName; 
    }

    /**
     * checks whether the department code and the class type match
     * 
     * @param aDep a department ID (key)
     */    
    private boolean checkDepMatch (int aDep)
    {
        if ((this.getClass().getName().equals("ManagementEmployee")) && aDep != MANAGEMENT )
            return false;
        
        if ((this.getClass().getName().equals("EngineeringEmployee")) && aDep != ENGINEERING )
            return false;
            
        if ((this.getClass().getName().equals("AdministrationEmployee")) && aDep != ADMINISTRATION )
            return false;

        return true;
    }
    
    /**
     * checks whether the contract code and the class type match
     * 
     * @param aCont a contract ID (key)
     */
    private boolean checkContMatch (int aCont)
    {
        if ((this.getClass().getName().equals("ManagementEmployee")) && aCont != INDEFINITE )
            return false;
        
        if ((this.getClass().getName().equals("AdministrationEmployee")) && aCont != TEMPORARY )
            return false;

        return true;
    }
    
    /**
     * sets the employee's department (string)
     * 
     * @param aDep a department ID (key)
     */    
    public void setDepartment(int aDep) 
    { 
        //System.out.println("Class: " + this.getClass().getName());
        if (!deps.containsKey(aDep))
        {
            System.err.println("Invalid department: " + aDep);
            throw new IllegalArgumentException();
        }
        else if (!checkDepMatch(aDep))
        {
            System.err.println("Mismatch between class and department code.");
            throw new IllegalArgumentException();
        }
        else 
        {
            department = deps.get(aDep);
            if (!deps.get(aDep).equals(department))
                setDep(aDep);
        }
    }

    /**
     * sets the employee's department (ID)
     * 
     * @param aDep a department ID (key)
     */    
    public void setDep(int aDep)
    { 
        if (!deps.containsKey(aDep))
        {
            System.err.println("Invalid department key: " + aDep);
            throw new IllegalArgumentException();
        }
        else
        {
            dep = aDep;
            if (!deps.get(aDep).equals(department))
                setDepartment(dep);
        }
    }

    /**
     * sets the years for which employee has been working for the company
     * 
     * @param aYears number of years
     */    
    public void setYears(int aYears) 
    { 
        if (aYears < 0)
        {
            System.err.println("years cannot be smaller than zero");
            throw new IllegalArgumentException();
        } 
        else if (aYears > 65)
        {
            System.err.println(name + " should be in retirement already");
            throw new IllegalArgumentException();
        }
        else
            years = aYears;
    }

    /**
     * sets the employee's contract type (by ID)
     * 
     * @param aCont a contract ID (key)
     */        
    public void setContract(int aCont) 
    { 
        if (!contracts.containsKey(aCont))
        {
            System.err.println("Invalid contract key: " + aCont);
            throw new IllegalArgumentException();
        }
        else if (!checkContMatch(aCont))
        {
            System.err.println("Mismatch between class and contract code.");
            throw new IllegalArgumentException();
        }
        else 
            contract = aCont; 
    }

    /**
     * returns employee data in a string
     * 
     * @return a String (sentence) with employee data
     */    
    public String toString()
    {
        String outstring = name + ": " + department + " department, " + contracts.get(contract) + " contract, " + years + " years in the company, salary of " + salary + " bitcoins";
        return outstring;
    }
}