import java.util.Scanner;
/**
 * Get input to rest of the classes
 * 
 * @author tibor
 * @version 0.0.1
 */
public class GetInput
{
    // the input the class can handle
    private long longInput;
    
    public GetInput()
    {
        longInput = readFromConsole();
    }

    public GetInput(Long input)
    {
        longInput = input;
    }

    
    public GetInput(String input)
    {
        longInput = Long.parseLong(input);
    }
    
    private long readFromConsole()
    {
        String inputStr = "";
        long theNumber = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number:");
        do 
        {
            inputStr = input.nextLine();
            try
            {
                theNumber = Long.parseLong(inputStr);
            } catch(NumberFormatException e)
            {
                System.out.println("Invalid number.");
                inputStr = "";
            }
        } while(inputStr == "");
        return theNumber;
    }
    
    /**
     * @return returns the integer
     */
    public long getNumber()
    {
        return longInput;
    }
    
    /**
     * The only purpose of main is to process the input
     * 
     * @param  argv   the integer to process
     */
    public static void main(String[] argv)
    {
        GetInput aNumber;
        if (argv.length > 0)
            aNumber = new GetInput(argv[0]);
        else
            aNumber = new GetInput();
        System.out.printf("The number: %d\n",aNumber.getNumber());
    }
}
