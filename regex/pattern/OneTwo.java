package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class OneTwo {
   private static final String BASIC_BLOCK = "one";
   private static final String REGEX = "\\b" + BASIC_BLOCK + "\\b";
   private static final int HOW_MANY_TIMES = 10;
   private static final String REPLACE = "two";
   
   private static String aStr = StringUtils.repeat(BASIC_BLOCK + " ", HOW_MANY_TIMES);

   public static void main( String args[] ) {
      Pattern p = Pattern.compile(REGEX);
      Matcher m = p.matcher(aStr);

      System.out.println(aStr);
      
      while(m.find()) {
          aStr = m.replaceFirst(REPLACE);
          System.out.println(aStr);
          m = p.matcher(aStr);
      }      
   }
}