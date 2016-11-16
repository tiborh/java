import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 * Write a description of class SetTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SetTest
{
    Set<String> set = new HashSet<String>();
    
    /**
     * Constructor for objects of class SetTest
     */
    public SetTest()
    {
        set = Collections.unmodifiableSet(set);
    }

    public void makeSingleton() {
        set = Collections.singleton("glorp");
    }
    
}
