
/**
 * Test class to help demonstrate upcasting
 * 
 * @author University of Madrid
 * @version 0.01
 */
public class test_people
{
    public static void main(String[] args){
        // mixed group, so superclass needs to be used:
        Person[] people = new Person[9];
        people[0] = new Learner("Juan");
        people[1] = new Teacher("Carlos");
        people[2] = new Learner("Ana");
        people[3] = new Learner("Ivan");
        people[4] = new Learner("Mike");
        people[5] = new Teacher("Iria");
        people[6] = new Learner("Elisa");
        people[7] = new Teacher("Carmen");
        people[8] = new Student("Elmer");
        
        assert(((Learner)people[0]).is_enrolled() == false);
        
        for (Person person:people){
            System.out.print("person: " + person.get_name());
            if (person instanceof Student)
            {
                System.out.print(" is a student");
            } else if (person instanceof Teacher)
            {
                System.out.print(" is a teacher");
            } else if (person instanceof Learner)
            {
                ((Learner)person).enroll();
                System.out.print(" is a learner");
            }
            System.out.println();
        }
        for (Person person:people)
        {
            /* no need to cast as toString() is defined in Person with same signature as in children
             * classes (compiler sees it, runtime interprets it specifically
             */
            System.out.println(person);
        }
        /* Casting is necessary when method is not in Person: compiler does not see it. */
        assert(((Teacher)people[1]).get_salary() == ((Teacher)people[1]).get_default_salary());
        ((Teacher)people[1]).raise_salary(1000);
        assert(((Teacher)people[1]).get_salary() == ((Teacher)people[1]).get_default_salary()+1000);
        assert(((Learner)people[0]).is_enrolled() == true);
        assert(((Student)people[8]).is_enrolled() == false);
        ((Learner)people[8]).enroll();
        assert(((Student)people[8]).is_enrolled() == true);
        System.out.println(people[8].toString());
        assert(new String(people[8].toString()).equals("Elmer\tenrolled\t0\t0.0"));
        assert(people[0].compareTo(people[1]) > 0);
    }
}
