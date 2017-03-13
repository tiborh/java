package pattern;


/**
 * Write a description of class StringReplace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringReplace
{    
    public static void main(String[] main)
    {
        String input = "The <b>Good</b>, the <i>Bad</i>, and the <strong>Ugly</strong>";
        String regex = "</?[a-z]+>";
        String output = input.replaceAll(regex, "");
        System.out.println("input:");
        System.out.println(input);
        System.out.println("output:");
        System.out.println(output);
    }
}
