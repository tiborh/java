package person;

import java.util.List;

/**
 * Family-like objects
 * 
 * @author tibor 
 * @version 0.01
 */
public interface Familiar
{   
    /**
     * Get the members in a List
     * 
     * @return        the members in a list
     */
    List<Person> getMembers();
    
    /**
     * Get the size of the Family
     * 
     * @return        the size of the family
     */
    int getSize();
    
    /**
     * Get the first member of the family
     * 
     * @return        a person who is the first in the family
     */
    Person getFirst();

    /**
     * Get the last member of the family
     * 
     * @return        a person who is the last in the family
     */
    Person getLast();
    
    /**
     * Add a member to the Family
     * 
     * @param   aPerson a Person to add to the family
     */
    void addMember(Person aPerson);
}
