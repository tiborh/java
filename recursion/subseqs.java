
/**
 * Write a description of class subseqs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class subseqs
{
    private static String subsequences(String word) {
        if (word.isEmpty()) {
            return ""; // base case
        } else {
            char firstLetter = word.charAt(0);
            String restOfWord = word.substring(1);

            String subsequencesOfRest = subsequences(restOfWord);

            String result = "";
            for (String subsequence : subsequencesOfRest.split(",", -1)) {
                result += "," + subsequence;
                result += "," + firstLetter + subsequence;
            }
            result = result.substring(1); // remove extra leading comma
            return result;
        }
    }
    
    public static String subsequences2(String word) {
        if (word.isEmpty()) {
            return ""; // base case
        } else {
            char firstLetter = word.charAt(0);
            String restOfWord = word.substring(1);

            String subsequencesOfRest = subsequences(restOfWord);

            String result = "";
            String[] splinters = subsequencesOfRest.split(",", -1);
            for(int i = splinters.length - 1 ; i >=0;--i) {
                result += "," + firstLetter + splinters[i];
                result += "," + splinters[i];
            }
            result = result.substring(1); // remove extra leading comma
            return result;
        }
    }
    
    public static String sequence(String s) { return sequence(s, "", 0); }
    public static String sequence(String s, String result, int index) {
        if (index == s.length()) {
            return result;
        }
        return sequence(s, result + s.charAt(index), index + 1) + ", " + sequence(s, result, index + 1);
    }
    
    public static String subseqs(String word) {
        String result = subsequences(word);
        return new StringBuilder(result).reverse().toString();
    }
    
    public static void main(String[] argv) {
        System.out.println(subseqs(argv[0]));
        System.out.println(subsequences2(argv[0]));
        System.out.println(sequence(argv[0]));
    }
}
