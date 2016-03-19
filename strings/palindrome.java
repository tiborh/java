import java.util.Random;
public class palindrome
{
    // instance variables - replace the example below with your own
    private String a_word;
    private String drow_a;
    private Random r = new Random();
    private int min_word_length = 2;
    private int max_word_length = 10;

    public palindrome()
    {
        gen_word();
    }

    public void gen_word() {
        a_word = word_generator(min_word_length,max_word_length);
        drow_a = reverse(a_word);
    }
    
    
    private String word_generator(int min_length, int max_length) {
        String consonants = "bcfghjklmnpqrstvwxyz";
        String vowels = "aeiou";
        String generated_word = "";
        int word_length = r.nextInt(max_length-min_length)+min_length+1;
        int i = 0;
        boolean first_vowel = false;
        if (r.nextInt(2) == 1)
            first_vowel = true;
            
        //System.out.print("word length: " + word_length + "; ");
        while (i < word_length) {
            //System.out.println("first_vowel: " + first_vowel + "; i: " + i);
            if (first_vowel == true && i < word_length) {
                generated_word += vowels.charAt(r.nextInt(vowels.length()));
                i++;
            }
            
            first_vowel = true;

            if (i < word_length) {
                generated_word += consonants.charAt(r.nextInt(consonants.length()));
                i++;
            }
        }
        
        return generated_word;
    }
    
    public String get_word() {
        return a_word;
    }
    public String get_reversed_word() {
        return drow_a;
    }
    
    public boolean is_palindrome() {
        if (a_word.toLowerCase().compareTo(drow_a.toLowerCase()) == 0)
            return true;
        else
            return false;
    }
        
    private String reverse(String in)
    {
        if (in.length() == 0)
            return "";
        if (in.length() == 1)
            return "" + in.charAt(0);
        //System.out.println(in.charAt(in.length()-1) + in.charAt(0));    
        return in.charAt(in.length()-1) + reverse(in.substring(1,in.length()-1)) + in.charAt(0);
    }
    
    private void make_reverse() {
        drow_a = reverse(a_word);
    }
    
    public static void main (String[] args) {
        palindrome a = new palindrome();
        //int i = 10;
        while (a.is_palindrome() == false) {
            System.out.println(a.get_word() + " <-> " + a.get_reversed_word());
            a.gen_word();
        }
        System.out.println("Palindrome: " + a.get_word() + " <-> " + a.get_reversed_word());
    }
}
