package person;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a family that lives in a household together.
 * A family always has at least one person in it.
 * Families are mutable.
 */
public class FamilySet implements Familiar
{
    // the people in the family
    public SortedSet<Person> people;

    public FamilySet() { people = new TreeSet<Person>(); }
    public void addMember(Person aMember) { people.add(aMember); }
    public int getSize() { return people.size(); }
    public Person getLast() { return people.last(); }
    public Person getFirst() { return people.first(); }

    /**
     * @return a list containing all the members of the family, with no duplicates.
     */
    public List<Person> getMembers() { return new ArrayList<>(people); }
}
