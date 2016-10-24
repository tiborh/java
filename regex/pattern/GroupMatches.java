package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupMatches {

   private static final String REGEX = "\\bcat\\b";
   private static final String REGEX2 = "\\bcat\\B";
   private static final String INPUT = "cat cat cat cattie cat";

   public static void main( String args[] ) {
      Pattern p = Pattern.compile(REGEX);
      Pattern p2 = Pattern.compile(REGEX2);
      Matcher m = p.matcher(INPUT);   // get a matcher object
      Matcher m2 = p2.matcher(INPUT);   // get a matcher object
      int count = 0;

      System.out.println("Sample text:   " + INPUT);
      System.out.println("Regex pattern: " + REGEX);
      while(m.find()) {
         count++;
         System.out.println("Match number "+count);
         System.out.println("start(): "+m.start());
         System.out.println("end(): "+m.end());
      }
      
      System.out.println("\nThe other match:");
      System.out.println("Regex pattern: " + REGEX2);
      count = 0;
      while(m2.find()) {
         count++;
         System.out.println("Match number "+count);
         System.out.println("start(): "+m2.start());
         System.out.println("end(): "+m2.end());
      }
   }
}