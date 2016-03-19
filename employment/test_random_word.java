public class test_random_word {
    public static void main(String[] argv)
    {
         random_word a_word = new random_word();
         System.out.println("Random length words (default min/max):");
         a_word.print_word();
         for (int i = 0; i < 10; i++)
         {
             a_word.gen_word();
             a_word.print_word();
         }
         int test_word_length = 5;
         System.out.printf("Same length words (%d):\n",test_word_length);
         for (int i = 0; i < 10; i++)
         {
             a_word.gen_word(test_word_length);
             a_word.print_word();
         }
         char test_char = 'C';
         System.out.printf("Same length with same char (%c):\n",test_char);
         for (int i = 0; i < 10; i++)
         {
             a_word.gen_word(test_char,test_word_length);
             a_word.print_word();
         }
         test_char = 'Z';
         int min_word_length = 1;
         int max_word_length = 7;
         System.out.printf("Varying length (%d,%d) with same char (%c):\n",min_word_length,max_word_length,test_char);
         for (int i = 0; i < 10; i++)
         {
             a_word.gen_word(test_char,min_word_length,max_word_length);
             a_word.print_word();
         }
         test_char = 'A';
         min_word_length = 2;
         max_word_length = 8;
         System.out.printf("Varying length (%d,%d) with same char (%c):\n",min_word_length,max_word_length,test_char);
         for (int i = 0; i < 10; i++)
         {
             a_word.gen_word(test_char,min_word_length,max_word_length);
             a_word.print_word();
         }
         System.out.println("Regenerating, using same word_length and first letter");
         for (int i = 0; i < 10; i++)
         {
             a_word.regenerate_word();
             a_word.print_word();
         }
    }    
}