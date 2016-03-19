import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class buffered_read{
 
    public static void main (String args[]) {
 
    System.out.println("Echoing standard input (Press 'Enter' to exit):");
    try{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String input;
 
        while((input=br.readLine())!=null && !input.equals("")){
            System.out.println(input);
        }
 
    }catch(IOException io){
        io.printStackTrace();
    }   
  }
}