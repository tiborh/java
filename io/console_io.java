import java.io.File;
import java.io.PrintWriter;
import java.io.Console;
import java.util.Scanner;
import java.io.IOException;

public class console_io extends file_io {
    private String output_string;
    private String user_name;
    private char[] passwd;
    
    public console_io() throws IOException {
        read_system_console();
    }

    //throws nullPointerException in Eclipse and in BlueJ but works fine on the command line
    public void read_system_console() throws IOException {
        Console cons = System.console();
        user_name = cons.readLine("User name: ");
        passwd = cons.readPassword("Password: ");
    }
    
    public void read_from_console() throws IOException {
        // 1. Connect to STDIN
        Scanner input = new Scanner(System.in);
        int student_num = 0;
        // 2. read the content using a loop
        System.out.println("Enter student names:");
        while(true) {
            String input_student_name = input.nextLine();
            if (input_student_name.equals("")) break;
            output_string += "Student #" + student_num + ": " + input_student_name + "\n";
            System.out.println("Student #" + student_num + ": " + input_student_name);
            student_num++;
        }        
    }
    
    public static void main(String[] args) throws IOException {
        console_io a = new console_io();
    }
}
