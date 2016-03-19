import java.util.HashMap;
/**
 * A class used to produce the required output by the task.
 * 
 */
public class Staff 
{
    /** the array for the sample staff */
    static Employee[] staff;

    /**
     * the method to sum up the salaries of a given department
     * 
     * @param staff the staff array
     * @param aDep  a department code (key)
     * @return the sum of salaries at the given department
     */
    public static double giveTotal(Employee[] staff, int aDep)
    {
        /** the sum of salaries are stored in this variable */
        double theSum = 0.0;

        for (int i = 0; i < staff.length; ++i)
        {
            if (staff[i].getDep() == aDep)
                theSum+=staff[i].getSalary();
        }

        return theSum;
    }

    /**
     * the sample staff array is created here and the sample printout
     * 
     * @param args unused default parameter
     */
    public static void main(String[] args) 
    {
        /** staff array is initialised */
        staff = new Employee[6];
        staff[0] = new ManagementEmployee("Bill", 9);
        staff[1] = new EngineeringEmployee("Anna", 9, Employee.INDEFINITE);
        staff[2] = new EngineeringEmployee("John", 5, Employee.INDEFINITE);
        staff[3] = new EngineeringEmployee("Elizabeth", 3, Employee.TRAINING);
        staff[4] = new EngineeringEmployee("Michael", 2, Employee.TRAINING);
        staff[5] = new AdministrationEmployee("Albert");
          
        /** staff data is printed out */
        for (int i = 0; i < staff.length; ++i)
            System.out.println(staff[i]);
            
        /** salaries are collected in a HashMap for addition */
        HashMap<Integer,Double> sums = new HashMap<Integer,Double>();
        sums.put(Employee.MANAGEMENT,giveTotal(staff,Employee.MANAGEMENT));
        sums.put(Employee.ENGINEERING,giveTotal(staff,Employee.ENGINEERING));
        sums.put(Employee.ADMINISTRATION,giveTotal(staff,Employee.ADMINISTRATION));
        
        /** company total of salaries is calculated */
        double company_total = sums.get(Employee.MANAGEMENT) + 
                               sums.get(Employee.ENGINEERING) + 
                               sums.get(Employee.ADMINISTRATION);
        
        /** sums are printed out */
        System.out.println("MANAGEMENT TOTAL SALARY: " + sums.get(Employee.MANAGEMENT) + " bitcoins");
        System.out.println("ENGINEERING TOTAL SALARY: " + sums.get(Employee.ENGINEERING) + " bitcoins");
        System.out.println("ADMINISTRATION TOTAL SALARY: " + sums.get(Employee.ADMINISTRATION) + " bitcoins");
        System.out.println("ACME TOTAL SALARY: " + company_total + " bitcoins");
    }
}