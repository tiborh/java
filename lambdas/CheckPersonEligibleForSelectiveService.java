
/**
 * A class to check person sex and age
 * 
 * @author Oracle The Java™ Tutorials
 * @version 2015
 */
class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}

