import java.util.Scanner;
import java.io.IOException;
public class console_io_scanner
{
    private String output_string;
    
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

}
