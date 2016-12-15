import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;
/**
 * Write a description of class setTask here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class setTask
{
    public static void main(String[] argv)
    {
        Set<String> set = new HashSet<String>();
        set = Collections.unmodifiableSet(set);
        set = Collections.singleton("glorp");
        //set = new Set<String>();
        List<String> list = set;
    }
}
