import java.util.Map;
import java.util.HashMap;
/**
 * Write a description of class treasures here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class treasures
{
    public static void main(String[] argv)
    {
        Map<String, Double> treasures = new HashMap<>();
        String x = "palm";
        treasures.put("beach", 25.);
        treasures.put("palm", 50.);
        treasures.put("cove", 75.);
        treasures.put("x", 100.);
        treasures.put("palm", treasures.get("palm") + treasures.size());
        treasures.remove("beach");
        double found = 0;
        for (double treasure : treasures.values()) {
            System.out.print(treasure + " ");
            found += treasure;
        }
        System.out.println("");
        
        System.out.println("treasures.get(x) == " + treasures.get(x));
        System.out.println("treasures.get(\"x\") == " + treasures.get("x"));
        System.out.println("found == " + found);
        System.out.println("treasures.putIfAbsent(\"beach\", 25.0): " + treasures.putIfAbsent("beach", 25.0));
        System.out.println("treasures.putIfAbsent(\"beach\", 75.0): " + treasures.putIfAbsent("beach", 75.0));
    }
}
