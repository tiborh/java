
/**
 * Teacher class to help demonstrate upcasting
 * 
 * @author University of Madrid
 * @version 0.02
 */
class Learner extends Person{
    private boolean enrolled;
    
    Learner(String name)
    {
        super(name);
        enrolled = false;
    }
    
    boolean is_enrolled()
    {
        return(enrolled);
    }
    
    void enroll()
    {
        enrolled = true;
    }
    
    public void monthly_statement()
    {
        System.out.println();
    }
    
    public String toString()
    {
        String enroll_string;
        if (this.is_enrolled())
            enroll_string = new String("enrolled");
        else
            enroll_string = new String("unenrolled");
        return super.toString() + "\t" + enroll_string;
    }
}
