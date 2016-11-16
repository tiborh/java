package person;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a family that lives in a household together.
 * A family always has at least one person in it.
 * Families are mutable.
 */
class FamilyList implements Familiar
{
    // the people in the family, sorted from oldest to youngest, with no duplicates.
    public List<Person> people;
    
    public FamilyList() { people = new ArrayList<Person>(); }   
    public void addMember(Person aMember) { people.add(aMember); }    
    public int getSize() { return people.size(); }

    public Person getFirst()
    {
        assert(people.size() > 0);
        return people.get(0);
    }
    
    public Person getLast()
    {
        assert(people.size() > 0);
        return people.get(people.size()-1);
    }
    
    /**
     * @return a list containing all the members of the family, with no duplicates.
     */
    public List<Person> getMembers() { return people; }
    
    public static void main(String[] argv)
    {
        Person aPerson = new Person();
        FamilyList aFamily = new FamilyList();
        aFamily.addMember(aPerson);
        List<Person> theMembers = aFamily.getMembers();
        System.out.println("Number of familty members: " + theMembers.size());
        System.out.println("First member: " + theMembers.get(0));
    }
}
