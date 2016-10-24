package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppendReplace
{
   private static String REGEX = "a*b";
   private static String INPUT = "aabfooaabfooabfoob";
   private static String REPLACE = "-";
   
   public static void main(String[] args) {
      Pattern p = Pattern.compile(REGEX);
      
      // get a matcher object
      Matcher m = p.matcher(INPUT);
      StringBuffer sb = new StringBuffer();
      
      System.out.println("Original String: " + INPUT);
      System.out.println("Regex pattern:   " + REGEX);
      System.out.println("Replacement:     " + REPLACE);
      System.out.println("While starts.");
      while(m.find()) {
         m.appendReplacement(sb, REPLACE);
         System.out.println("StringBuffer:    " + sb.toString());
      }
      System.out.println("While ends.");
      sb = m.appendTail(sb);
      System.out.println("Final String:    " + sb.toString());
   }
}
