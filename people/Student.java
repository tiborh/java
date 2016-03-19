public class Student extends Learner
{
    private static int counter = 0;
    private int id;
    private double gpa;
   
    public Student(String name)
    {
        super(name);
        id = counter;
        counter++;
        gpa = 0.0;
    }
    
    public Student()
    {
        this("Student");
        super.set_name("Student " + id);
    }
    
    public double get_gpa()
    {
        return(this.gpa);
    }
    
    public double set_gpa(double gpa)
    {
        this.gpa = gpa;
        return(this.gpa);
    }
    
    public String toString()
    {
        return super.toString() + "\t" + id + "\t" + gpa;
    }
    
    public static void main(String[] args)
    {
        Student s1 = new Student("Abe");
        Student s2 = new Student("Eve");
        Student s3 = new Student("Joe");
        assert(s1.get_gpa() == 0.0);
        s1.set_gpa(5.4);
        assert(s1.get_gpa() == 5.4);
        s2.set_gpa(3.9);
        s3.set_gpa(6.8);
        Student s4 = new Student();
        //System.out.println("s4: " + s4.get_name());
        assert(new String("Student 3").equals(s4.get_name()));
        System.out.println("name:   \t" + s1.get_name() + "\t" + s2.get_name() + "\t" + s3.get_name());
        System.out.println("id:     \t" + s1.id + "\t" + s2.id + "\t" + s3.id);          
        System.out.println("counter:\t" + s1.counter + "\t" + s2.counter + "\t" + s3.counter);
        System.out.println("gpa:    \t" + s1.get_gpa() + "\t" + s2.get_gpa() + "\t" + s3.get_gpa());
    } 
}