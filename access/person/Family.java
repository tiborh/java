package person;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a family that lives in a household together.
 * A family always has at least one person in it.
 * Families are mutable.
 */
class Family {
    // the people in the family, sorted from oldest to youngest, with no duplicates.
    public List<Person> people;
    
    public Family() {
        people = new ArrayList<Person>();
    }
    
    public void addMember(Person aMember) {
        people.add(aMember);
    }
    
    /**
     * @return a list containing all the members of the family, with no duplicates.
     */
    public List<Person> getMembers() {
        return people;
    }
    
    public static void main(String[] argv) {
        Person aPerson = new Person();
        Family aFamily = new Family();
        aFamily.addMember(aPerson);
    }
}
