
/**
 * Write a description of class subseqLouis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class subseqLouis
{
    public static String subsequences(String word) {
        partialSubsequence = "";
        return subsequencesLouis(word);
    }

    private static String partialSubsequence = "";
    private static int depth_counter = 0;

    private static void print_tabs() {
        for (int i = 0; i < depth_counter; ++i)
            System.out.print("\t");        
    }
    
    public static String subsequencesLouis(String word) {
        print_tabs();
        ++depth_counter;
        System.out.println("word: " + word);
        if (word.isEmpty()) {
            // base case
            --depth_counter;
            print_tabs();
            System.out.println("partialSubsequence: " + partialSubsequence);
            print_tabs();
            System.out.println("will return (1): " + partialSubsequence);
            return partialSubsequence;
        } else {
            // recursive step
            String withoutFirstLetter = subsequencesLouis(word.substring(1));
            partialSubsequence += word.charAt(0);
            String withFirstLetter = subsequencesLouis(word.substring(1));
            --depth_counter;
            print_tabs();
            System.out.println("partialSubsequence: " + partialSubsequence);
            print_tabs();
            System.out.println("will return (2): " + withoutFirstLetter + "," + withFirstLetter);
            return withoutFirstLetter + "," + withFirstLetter;
        }
    }
    
    public static void main(String[] argv) {
        for (String anArg : argv) {
            subsequencesLouis(anArg);
        }
    }
}
