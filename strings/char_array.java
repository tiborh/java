public class char_array {
    // instance variables - replace the example below with your own
    private char[] char_array = {'a','b','c','d','e','f'};

    private char_array() {
        // initialise instance variables       
    }
    
    private void print_char_array() {
        // put your code here
        System.out.println(char_array);
    }

    private int give_length() {
        return char_array.length;
    }
    
    private void print_length() {
        System.out.println("Length: " + give_length());
    }
    
    private void break_down() {
        for (int i = 0; i < char_array.length; i++)
            System.out.println(char_array[i]);
    }
    
    public static void main(String[] args) {
        char_array sample1 = new char_array();
        sample1.print_char_array();
        sample1.print_length();
        sample1.break_down();
    }
}
