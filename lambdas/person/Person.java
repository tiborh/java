package person;
/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
 
import java.util.List;
import java.util.ArrayList;
import java.time.chrono.IsoChronology;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Period;
import java.util.function.Predicate;

public class Person {
  
    public enum Sex {
        MALE, FEMALE
    }
  
    String name; 
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    private static int chapter = 0;
    
    private static void printChapter(String txt) {
        System.out.println("\n" + ++chapter + ". " + txt);
    }
  
    Person(String nameArg, LocalDate birthdayArg,
        Sex genderArg, String emailArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
    }  

    public int getAge() {
        return birthday
            .until(IsoChronology.INSTANCE.dateNow())
            .getYears();
    }

    public void printPerson() {
        System.out.println(this);
      //System.out.println(name + ", " + this.getAge());
    }
    
    public static void printPersons(
    List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                System.out.println(p);
            }
        }
    }
    
    public Sex getGender() {
        return gender;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }
    
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        String out = new String();
        out += getName() + "\t";
        out += (getGender() == Sex.MALE ? "male" : "female") + "\t";
        out += getAge() + "\t";
        out += getBirthday() + "\t";
        out += getEmailAddress();
        return out;
    }
    
    public static List<Person> createRoster() {
        LocalDate now = LocalDate.now();
        LocalDate a20 = now.minusYears(20);
        LocalDate a30 = now.minusYears(30);
        List<Person> roster = new ArrayList<>();
        roster.add(
            new Person(
            "Fred",
            IsoChronology.INSTANCE.date(1980, 6, 20),
            Person.Sex.MALE,
            "fred@example.com"));
        roster.add(
            new Person(
            "Jane",
            IsoChronology.INSTANCE.date(1990, 7, 15),
            Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
            new Person(
            "George",
            IsoChronology.INSTANCE.date(1991, 8, 13),
            Person.Sex.MALE, "george@example.com"));
        roster.add(
            new Person(
            "Bob",
            IsoChronology.INSTANCE.date(2000, 9, 12),
            Person.Sex.MALE, "bob@example.com"));
        roster.add(
            new Person(
            "Ali",
            a20,
            Person.Sex.FEMALE, "ali@example.com"));
        roster.add(
            new Person(
            "Ed",
            a30,
            Person.Sex.MALE, "ed@example.com"));
        return roster;
    }
    
    public static void printRoster(List<Person> in) {
        System.out.println("Roster size: " + in.size());
        for (Person ap : in) {
            System.out.println(ap);
        }
        System.out.println("EOL");
    }
    
    /**
     * traditional method for "older than or is" condiction
     */
    protected static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }
    
    /**
     * traditional method for age range
     */
    protected static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }    
    
    /**
     * This method checks each Person instance contained in the List parameter roster 
     * whether it satisfies the criteria specified in the Predicate parameter tester. 
     * If the Person instance does satisfy the criteria specified by tester, 
     * the method printPersron is invoked on the Person instance.
     */
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
    
    /**
     * The following method replaces the invocation p.printPerson() 
     * with an instance of Consumer<Person> that invokes the method accept:
     */
    public static void processPersons(
        List<Person> roster,
        Predicate<Person> tester,
        Consumer<Person> block) {
            for (Person p : roster) {
                if (tester.test(p)) {
                    block.accept(p);
                }
            }
    }
    
    /**
     * The following method retrieves the data specified by the parameter mapper, 
     * and then performs an action on it specified by the parameter block:
     */
    public static void processPersonsWithFunction(
        List<Person> roster,
        Predicate<Person> tester,
        Function<Person, String> mapper,
        Consumer<String> block) {
            for (Person p : roster) {
                if (tester.test(p)) {
                    String data = mapper.apply(p);
                    block.accept(data);
                }
            }
    }
    
    /**
     * he following is a generic version of it that accepts, as a parameter, 
     * a collection that contains elements of any data type:
     */
    public static <X, Y> void processElements(
        Iterable<X> source,
        Predicate<X> tester,
        Function<X, Y> mapper,
        Consumer<Y> block) {
            for (X p : source) {
                if (tester.test(p)) {
                    Y data = mapper.apply(p);
                    block.accept(data);
                }
            }
    }
        
    public static void main(String[] argv) {
        List<Person> a = createRoster();
        printChapter("The Roster");
        printRoster(a);
        
        printChapter("Older Than");
        System.out.println("Using a simple method to find person older than 30:");
        printPersonsOlderThan(a,30);
        
        printChapter("Within Age Range");
        System.out.println("Another one for age range (20 <= age < 30):");
        printPersonsWithinAgeRange(a,20,30);
        
        printChapter("Interface Implementation:");
        System.out.println("Persons eligible for service:");
        printPersons(a, new CheckPersonEligibleForSelectiveService());
        
        printChapter("Anonymous Class");
        printPersons(
            a,
            new CheckPerson() {
                public boolean test(Person p) {
                    return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
                }
            }
        );
        
        printChapter("Using functional Predicate + lambda:");
        printPersonsWithPredicate(
            a,
            p -> p.getGender() == Person.Sex.MALE
              && p.getAge() >= 18
              && p.getAge() <= 25
        );
        
        printChapter("More Lambda:");
        processPersons(
            a,
            p -> p.getGender() == Person.Sex.MALE
              && p.getAge() >= 18
              && p.getAge() <= 25,
            p -> p.printPerson()
        );
        
        printChapter("Even more lambda:");
        processPersonsWithFunction(
            a,
            p -> p.getGender() == Person.Sex.MALE
              && p.getAge() >= 18
              && p.getAge() <= 25,
            p -> p.getEmailAddress(),
            email -> System.out.println(email)
        );
        
        printChapter("More extensive use of generics:");
        /**
         * This method invocation performs the following actions:
         * 1. Obtains a source of objects from the collection source. 
         *    In this example, it obtains a source of Person objects from the collection roster. 
         *    Notice that the collection roster, which is a collection of type List, 
         *    is also an object of type Iterable.
         * 2. Filters objects that match the Predicate object tester. 
         *    In this example, the Predicate object is a lambda expression that specifies 
         *    which members would be eligible for Selective Service.
         * 3. Maps each filtered object to a value as specified by the Function object mapper. 
         *    In this example, the Function object is a lambda expression 
         *    that returns the e-mail address of a member.
         * 4. Performs an action on each mapped object as specified by the Consumer object block. 
         *    In this example, the Consumer object is a lambda expression that prints a string, 
         *    which is the e-mail address returned by the Function object.
         */
        processElements(
            a,
            p -> p.getGender() == Person.Sex.MALE
              && p.getAge() >= 18
              && p.getAge() <= 25,
            p -> p.getEmailAddress(),
            email -> System.out.println(email)
        );
        
        printChapter("Aggregate operations are used:");
        /**
         * Obtain a source of objects	                  Stream<E> stream()
         * Filter objects that match a Predicate object	  Stream<T> filter(Predicate<? super T> predicate)
         * Map objects to another value as specified 
         * by a Function object	                          <R> Stream<R> map(Function<? super T,? extends R> mapper)
         * Perform an action as specified 
         * by a Consumer object	                          void forEach(Consumer<? super T> action)

         */
        a
            .stream()
            .filter(
                p -> p.getGender() == Person.Sex.MALE
                  && p.getAge() >= 18
                  && p.getAge() <= 25
             )
            .map(p -> p.getEmailAddress())
            .forEach(email -> System.out.println(email))
        ;
    }
}