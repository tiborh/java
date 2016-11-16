package person;

/**
 * Write a description of class ClientMethods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClientMethods {
    //implementation dependent
    void client1(FamilyList f) {
        // get youngest person in the family
        Person baby = f.people.get(f.people.size()-1);
        System.out.println("Baby: " + baby);
    }

    //originally implementation dependent, but made implementation independent
    void client2(Familiar f) {
        // get youngest person in the family
        Person baby = f.getLast();
        System.out.println("Baby: " + baby);
    }
    
    //implementation independent
    void client3(Familiar f) {
        // get size of the family
        int familySize = f.getSize();
        System.out.println("Size of the family: " + familySize);
    }
    
    void client4(Familiar f) {
        // get any person in the family
        Person anybody = f.getMembers().get(0);
        System.out.println("First member of the family: " + anybody);
    }
    
    public static void main(String[] argv) {
        FamilyList aFamily = new FamilyList();
        aFamily.addMember(new Person());
        aFamily.addMember(new Person(100));
        aFamily.addMember(new Person(10));
        ClientMethods cm1 = new ClientMethods();        
        cm1.client1(aFamily);
        cm1.client2(aFamily);        
        cm1.client3(aFamily);
        cm1.client4(aFamily);
        
        FamilySet aFamily2 = new FamilySet();
        aFamily2.addMember(new Person());
        aFamily2.addMember(new Person(100));
        aFamily2.addMember(new Person(10));
        ClientMethods cm2 = new ClientMethods();
        //cm2.client2(aFamily2); // no such element exception if no addMember
        cm2.client2(aFamily2); // classCastException, if addMember in Family2
        cm2.client3(aFamily2);
    }
}
