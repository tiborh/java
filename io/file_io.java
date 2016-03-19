import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;

/* Useful in Scanner class:
 * hasNextLine()
 * nextLine()
 * hasNext() : does the next string exist?
 * next() : returns next string
 * hasNextInt(), hasNextDouble() : does next int/double exist?
 * nextInt(), nextDouble()
*/
public class file_io {
    // instance variables - replace the example below with your own
    private String input_filename = "input.txt";
    private String output_filename = "output.txt";
    private static final int max_names = 200;
    private static final int max_name_components = 3;
    private int num_of_names = 0;
    private String[][] the_names = new String[max_names][max_name_components];
    private String output_string = "";

    /**
     * Constructor for objects of class file_io
     */
    public file_io() {}

    public void read_file() throws Exception {
        // 1. Create a File and Scanner objects
        //File input_file = new File(input_filename);
        //Scanner input = new Scanner(input_file);
        // alternatively (one line instead of two): 
        Scanner input = new Scanner(Paths.get(input_filename));
        
        // 2. read the content using a loop
        for (int i = 0; input.hasNextLine(); i++) {
            String input_student_name = input.nextLine();
            output_string += "Student #" + i + ": " + input_student_name + "\n";
            System.out.println("Student #" + i + ": " + input_student_name);
        }        
        // 3. close the file and print the result
        input.close();
    }
    
    public void read_names_to_array() throws IOException {
        File input_file = new File(input_filename);
        Scanner input = new Scanner(input_file);
        Scanner line;

        for (int i = 0; input.hasNextLine(); i++) {
            String input_name = input.nextLine();
            line = new Scanner(input_name);
            if (i >= max_names) break;
            for (int j = 0; j < max_name_components; j++)
                the_names[i][j] = (line.hasNext()) ? line.next() : "";
            output_string += "Student #" + i + ": " + input_name + "\n";
            System.out.println("Student #" + i + ": " + input_name);
            num_of_names = i;
        }        

        input.close();
    }
    
    /* Printing to a file is done with
     * print() and println()
     */
    public void print_to_file() throws Exception {
        File output_file = new File(output_filename);
        PrintWriter file_writer = new PrintWriter(output_file);
        file_writer.println(output_string);
        file_writer.close();       
    }
    
    public void print_name_array_to_file() throws IOException {
        String output_filename = "output2.txt";
        File output_file = new File(output_filename);
        PrintWriter file_writer = new PrintWriter(output_file);
        for (int i = 0; i <= num_of_names; i++) {
            if (the_names[i][2].length() > 0)
                file_writer.println(the_names[i][2].toUpperCase() + " " + the_names[i][0]  + " " + the_names[i][1]);
            else if (the_names[i][1].length() > 0)
                file_writer.println(the_names[i][1].toUpperCase() + " " + the_names[i][0]);
            else if (the_names[i][0].length() > 0)
                file_writer.println(the_names[i][0].toUpperCase());
        }
        file_writer.close();       
    }
}
