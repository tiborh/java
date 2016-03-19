import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;
/**
 * Example from Core Java Fundamentals 9th edition
 * 
 * @author Cay S. Horstmann (with some modifications by Tibor)
 * @version 0.1
 */
public class person_test
{
    static final int max_names = 200;
    private int nu_of_names = 0;
    private String[] the_names = new String[max_names];
    private String in_filename = "firstnames.txt";
    
    public person_test() throws IOException
    {
        read_names(in_filename);
    }
    
    private String[] read_names(String input_filename) throws IOException
    {
        Scanner fh = new Scanner(Paths.get(input_filename));
        for (int i = 0; fh.hasNextLine(); i++) {
            String input_name = fh.nextLine();
            if (input_name.length() > 0) {
                the_names[i] = input_name;
                nu_of_names++;
            }
        }
        fh.close();
        return the_names;
    }
    
    public void print_names()
    {
        for (int i = 0; i < nu_of_names; i++)
            if (the_names[i] != null)
                System.out.println(the_names[i]);
    }
    
    public String[] get_names()
    {
        String[] out_array = new String[nu_of_names];
        System.arraycopy(the_names,0,out_array,0,nu_of_names);
        return out_array;
    }
    
    public int get_number_of_names()
    {
        return nu_of_names;
    }
    
    public static void main(String[] argv) throws IOException
    {
        // fill the staff array with employee objects
        person_test name_list = new person_test();
        String[] first_names = name_list.get_names();
        String[] surnames = new String[first_names.length];
        random_word a_surname = new random_word();
        person[] the_group = new person[first_names.length];
        for (int i = 0; i < first_names.length; i++)
        {
            a_surname.gen_word(first_names[i].charAt(0),first_names[i].length());
            surnames[i] = a_surname.get_word();
            the_group[i] = new person(first_names[i],surnames[i]);
            System.out.println(the_group[i].get_surname().toUpperCase() + "\t" + the_group[i].get_firstname());
        }
    }
}

