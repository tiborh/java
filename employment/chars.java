import java.util.Random;
/**
 * Just to test chars
 * and random strings
 */
public class chars
{
    static Random gen_rand = new Random();
    static final String vowels = "aeiou";
    static final String consonants = "bcdfghjklmnpqrstvwxyz";
    static final int default_min_word_length = 1;
    static final int default_max_word_length = 10;
    
    public String gen_word(){
        int word_length = gen_rand.nextInt(
            default_max_word_length - default_min_word_length) + default_min_word_length;
        return gen_word(word_length,word_length);
    }
        
    public String gen_word(int word_length){
        return gen_word(word_length,word_length);
    }

    public String gen_word(int min_length, int max_length){
        boolean is_first_vowel = (gen_rand.nextInt(2) == 1) ? true : false;
            
        return gen_word(is_first_vowel,min_length,max_length);
    }
    
    public String gen_word(boolean is_first_vowel, int min_length, int max_length){
        String the_word = "";
        
        for (int i = 0; i < 10; i++) {
            System.out.println(gen_rand.nextInt(2));
        }
        
        return the_word;
    }
    
    public String gen_word(char first_letter, int word_length){
        return gen_word(first_letter,word_length-1,word_length-1);
    }
    
    public String gen_word(char first_letter, int min_length, int max_length){
        String the_start = "" + first_letter;
        boolean is_second_vowel = vowels.contains(the_start.toLowerCase()) ? false : true;
        
        return first_letter + gen_word(is_second_vowel,min_length,max_length);
    }
    
    public static void print_chars() {
        System.out.print("       ");
        for (int i = 32; i < 127; i++) {
            System.out.printf("%3d:%2c ",i,i);
            if (i % 10 == 0)
                System.out.println();
        }
        System.out.println();        
    }
    
    /**
     * the lab
     * 
     */
    public static void main(String[] argv)
    {
        char test_char = 65;
        System.out.println("" + test_char);

        byte[] test_int_array = {65,66,67};
        String test_string = new String(test_int_array);
        System.out.println(test_string);
        System.out.println(test_string.contains(""+'C'));
        System.out.println(test_string.contains(""+'c'));

        String short_string = "A";
        System.out.println(short_string.toLowerCase());
        System.out.println(short_string.toLowerCase().charAt(0));
        System.out.println(vowels.contains(short_string.toLowerCase()));
        short_string = "D";
        System.out.println(vowels.contains(short_string.toLowerCase()));
    }
}
