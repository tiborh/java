public class strings {
    // instance variables - replace the example below with your own
    private String sample;

    private strings() {
        // initialise instance variables
        sample = "abcdef";
    }

    private void print_string() {
        // put your code here
        System.out.println(sample);
    }

    private int give_length() {
        return sample.length();
    }
    
    private void print_length() {
        System.out.println("Length: " + give_length());
    }

    private void break_down() {
        for (int i = 0; i < sample.length(); i++)
            System.out.println(sample.charAt(i));
    }
    
    private void print_substring(int from, int sub_length) {
        if (from > give_length() - 1) {
            System.out.println("Length is: " + give_length() + " but you wanted it to start from " + from); 
            return;
        }
        
        if (from + sub_length > sample.length()) {
            System.out.print("Requested length: " + sub_length);
            sub_length = give_length() - from;
            System.out.println("; Corrected length: " + sub_length);
            System.out.println("Substring: " + sample.substring(from));
        } else 
            System.out.println("Substring: ".concat(sample.substring(from,from + sub_length)));
    }
    
    private void compare_strings(String in) {
        int compared = sample.compareTo(in);
        if (compared < 0)
            System.out.print(sample + " is less than " + in);
        else if (compared == 0)
            System.out.print(sample + " is equal to " + in);
        else if (compared > 0)
            System.out.print(sample + " is greater than " + in);
        
        System.out.println(" (equals? " + sample.equals(in) + ")");
    }
    
    public void print_upper() {
        System.out.println(sample.toUpperCase());
    }
    
    public static void main(String[] args) {
        int lenOfStr = "Is it possible?".length();
        System.out.println(lenOfStr);
        strings sample1 = new strings();
        sample1.print_string();
        sample1.print_length();
        sample1.break_down();
        sample1.print_substring(2,5);
        sample1.print_substring(5,2);
        sample1.print_substring(2,3);
        sample1.print_substring(6,3);
        sample1.compare_strings("ab");
        sample1.compare_strings("abcdef");
        sample1.compare_strings("abcdefg");
        sample1.print_upper();
        String s1 = "zzz";
        String s2 = "ZZZ";
        int v1 = s1.compareTo("AAA");
        int v2 = s2.compareTo("aaa");
        System.out.print("v1: " + v1);
        System.out.println("; v2: " + v2);
    }
}
