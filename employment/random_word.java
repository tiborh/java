import java.util.Random;
/**
 * Generates a random word
 * 
 * @author Tibor
 * @version 0.1
 */
public class random_word
{   
    private static Random gen_rand = new Random();
    static final String vowels = "aeiou";
    static final String consonants = "bcdfghjklmnpqrstvwxyz";
    static final int default_min_word_length = 1;
    static final int default_max_word_length = 10;

    private String the_word = "";
    private int word_length = the_word.length();
    private char first_letter = 0;

    public random_word()
    {
        gen_word();
    }

    public random_word(int min_length, int max_length)
    {
        gen_word(min_length,max_length);
    }
    
    public random_word(int word_length)
    {
        gen_word(word_length);
    }
    
    public random_word(char first_letter, int min_length, int max_length)
    {
        gen_word(first_letter,min_length,max_length);
    }
    
    public random_word(char first_letter, int word_length)
    {
        gen_word(first_letter,word_length);
    }
    
    public void gen_word()
    {
        int min_length = default_min_word_length;
        int max_length = default_max_word_length;

        gen_word(min_length,max_length);
    }

    public void regenerate_word()
    {
        if (first_letter != 0)
            gen_word(first_letter,word_length);
        else
            gen_word(word_length);
    }
    
    public void gen_word(int word_length)
    {
        gen_word(word_length,word_length);
    }

    public void gen_word(int min_length, int max_length)
    {
        boolean is_first_vowel = (gen_rand.nextInt(2) == 1) ? true : false;            
        gen_word(is_first_vowel,min_length,max_length);
    }

    public void gen_word(char first_letter, int word_length)
    {
        boolean is_second_vowel = is_vowel(first_letter) ? false : true;
        gen_word(is_second_vowel, word_length - 1);
        set_word(first_letter + the_word, word_length);
        set_first_letter(first_letter);
    }
    
    public void gen_word(char first_letter, int min_length, int max_length)
    {
        boolean is_second_vowel = is_vowel(first_letter) ? false : true;
        gen_word(is_second_vowel,min_length - 1, max_length - 1);
        set_word(first_letter + the_word, word_length + 1);
        set_first_letter(first_letter);
    }
    
    private void gen_word(boolean is_first_vowel, int min_length, int max_length)
    {
        gen_word(is_first_vowel,gen_rand.nextInt(max_length + 1 - min_length) + min_length);
    }
        
    private void gen_word(boolean is_first_vowel, int word_length)
    {
        reset_word();
        this.word_length = word_length;
        for (int i = 0; i < word_length; i++)
        {
            if (is_first_vowel)
            {
                the_word += "" + select_vowel();
                is_first_vowel = false;
            } else 
            {
                the_word += "" + select_consonant();
                is_first_vowel = true;
            }
        }
    }
    
    private void reset_word()
    {
        the_word = "";
        word_length = 0;
        first_letter = 0;
    }
    
    private void set_first_letter(char a_letter) {
        first_letter = a_letter;
    }
    
    private void set_word(String the_word, int the_length)
    {
        this.the_word = the_word;
        word_length = the_length;
    }
    
    private boolean is_vowel(char a_char)
    {
        String test_string = "" + a_char;
        return vowels.contains(test_string.toLowerCase());
    }
    
    private char select_vowel()
    {
        return vowels.charAt(gen_rand.nextInt(vowels.length()));
    }

    private char select_consonant()
    {
        return consonants.charAt(gen_rand.nextInt(consonants.length()));
    }
    
    public String get_word()
    {
        return the_word;
    }
    
    public void print_word()
    {
        System.out.println(get_word());
    }
    
    public static void main(String[] argv)
    {
         random_word a_word = new random_word();
         a_word.print_word();
    }
}
