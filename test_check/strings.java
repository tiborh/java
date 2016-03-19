
/**
 * Write a description of class strings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class strings
{
    public static void main(String[] args)
    {
        String s1=new String ("I'm learning how to compare Strings");
        String s2=new String ("I'm learning how to compare Strings");
        if (s1 == s2) {
            System.out.println ("s1 and s2 are the same");
        }else{
            System.out.println ("s1 and s2 are different");
        }

        String s11="I'm learning how to compare Strings";
        String s21="I'm learning how to compare Strings";
        if (s11 == s21) {
            System.out.println ("s1 and s2 are the same");
        }else{
            System.out.println ("s1 and s2 are different");
        }

        String literal = "This is a literal";
        System.out.println(literal.substring(5, 9));
        System.out.println(literal.substring(10));
        System.out.println(literal.substring(15, 16));
        System.out.println(" This is a literal ".length());
        System.out.println("This is a literal".indexOf('i', 3));
        System.out.println("This is a literal".compareTo("These are not literals"));
        System.out.println("This is a literal".compareTo("This is a literals"));
        System.out.println("This is a literal".compareTo("This is a litera"));

        String a=new String ("abcdefg");
        String b=new String ("ABCDEFG");
        String c=new String ("AbcdefG");
        String d=new String ("cde");
        
        System.out.println (a.equals(b));
        System.out.println (a.equalsIgnoreCase(b));
        System.out.println (c.substring(2,4));
    }
}
