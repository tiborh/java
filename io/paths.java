import java.util.Scanner;
import java.nio.file.*;
import java.net.URI;
/**
 * to study how paths are handled
 * 
 * @author tibor 
 * @version 0.01
 */
public class paths
{
    // user home
    private static Path home_path;
    // the following does not work, need to figure out how to add or append paths
    //private static Path lat_path = home_path + Paths.get("home","etibhar","lat");

    /**
     * Constructor for objects of class path
     */
    public paths()
    {
        home_path = Paths.get(System.getProperty("user.home"));
    }

    private void endit()
    {
        System.out.println("That's all. Exiting...");
        System.exit(0);
    }
    
    private void path_tester()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Path tester:");
        String input_line = ".";
        while (!input_line.equals(""))
        {
            input_line = input.nextLine();
            try
            {
                Path test_path = Paths.get(input_line);
                System.out.println(test_path);
            }
            catch(InvalidPathException pe)
            {
                System.out.println("That was an illegal path string.");
            }
        }
        input.close();
        endit();
    }
    
    private static void path_tester(String in_path)
    {
        try
        {
            Path test_path = Paths.get(in_path);
            System.out.println(test_path);
        }
        catch(InvalidPathException pe)
        {
            System.out.println("That was an illegal path string.");
        }
    }
    
    private void home_folder_tests()
    {
        System.out.println("Home path:");
        System.out.println(home_path);
        
        System.out.format("toString: %s%n", home_path.toString());
        System.out.format("getFileName: %s%n", home_path.getFileName());
        System.out.format("getName(0): %s%n", home_path.getName(0));
        System.out.format("getNameCount: %d%n", home_path.getNameCount());
        System.out.format("subpath(0,2): %s%n", home_path.subpath(0,2));
        System.out.format("getParent: %s%n", home_path.getParent());
        System.out.format("getRoot: %s%n", home_path.getRoot());
        System.out.format("toUri: %s%n", home_path.toUri());
    }
    
    public static void main (String[] argv)
    {
        if (argv.length > 0)
        {
            System.out.println("Testing first argument for path");
            path_tester(argv[0]);
        }
        paths test_item = new paths();
        test_item.home_folder_tests();
        Path p2 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));
        System.out.println("From URI: " + p2);
        //this must be the last one as it exits the program:
        test_item.path_tester();
    }
}
