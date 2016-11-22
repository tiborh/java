package ps3;

import java.util.Arrays;
import java.util.List;

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
            Arrays.asList("F Sting", "G Taunt", "H Ur"), 1990);
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
    }
}
