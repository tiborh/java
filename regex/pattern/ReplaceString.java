package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceString {

   private static String REGEX = "dog";
   private static String INPUT = "The dog says meow. " + "All dogs say meow.";
   private static String REPLACE = "cat";

   public static void main(String[] args) {
      Pattern p = Pattern.compile(REGEX);
      String r1;
      String r2;
      
      System.out.println("Input String:       " + INPUT);
      System.out.println("Regex String:       " + REGEX);
      System.out.println("Replacement String: " + REPLACE);
      
      // get a matcher object
      Matcher m1 = p.matcher(INPUT);
      Matcher m2 = p.matcher(INPUT);
      r1 = m1.replaceFirst(REPLACE);
      r2 = m2.replaceAll(REPLACE);
      System.out.println("After replaceFirst: " + r1);
      System.out.println("After replaceAll:   " + r2);
   }
}