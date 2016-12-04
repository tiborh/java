package ps3;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * to try out a few things in objects with printing
 * 
 * @author tibor
 * @version 
 */
public class Experimenter
{
    public static void main(String[] argv)
    {
        Book aBook = new Book("Fantastic", 
            Arrays.asList("F Sting", "G Taunt", "H Url"), 1990);
        System.out.println(aBook);
        
        try {
            Book wrongBook = new Book("", Arrays.asList(""), -1);
        } catch (AssertionError e) {
            System.out.println("Wrong book could not be created for error.");
        }
        
        List<String> auths = aBook.getAuthors();
        auths.add("second");
        System.out.println("Authors list modified: " + auths);
        System.out.println("Check auths in object: " + aBook.getAuthors());
        aBook.getAuthors().add("something");
        BookCopy aCopy = new BookCopy(aBook);
        System.out.println("BookCopy printed out: " + aCopy);
               
        Set<BookCopy> copySet = new HashSet<BookCopy>(Arrays.asList(aCopy));
        assert(copySet.equals(new HashSet<BookCopy>(Arrays.asList(aCopy))));
        
        Library aLib = new SmallLibrary();
        aLib.buy(aBook);
        Set<BookCopy> allCopies = aLib.allCopies(aBook);
        System.out.println("Size of allCopies: " + allCopies.size());
        System.out.println("Content of allCopies: " + allCopies);
        for (BookCopy loopCopy : allCopies) {
            System.out.println("loopCopy equals aCopy: " + loopCopy.equals(aCopy));
        }
        System.out.println("allCopies:\n" + allCopies);
        System.out.println("new HashSet<BookCopy>(Arrays.asList(aCopy))):\n" + 
            new HashSet<BookCopy>(Arrays.asList(aCopy)));
        assert(allCopies.equals(new HashSet<BookCopy>(Arrays.asList(aCopy))));
        
        aLib.buy(aBook);
        allCopies = aLib.allCopies(aBook);
        System.out.println("All copies after second purchase: " + allCopies);
        System.out.println("Size of number of copies: " + allCopies.size());
    }
}
