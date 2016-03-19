import java.util.ArrayList;
import java.net.MalformedURLException;
import java.io.IOException;
/**
 * an example use of searching for city
 * 
 * @author tibor 
 * @version 0.01
 */
public class LinearSearch
{
    // instance variables - replace the example below with your own
    ArrayList<Airport> airports = new ArrayList<Airport>();

    /**
     * Constructor for objects of class searchCity
     */
    public LinearSearch() throws MalformedURLException,IOException
    {
        WorkFromFile wff = new WorkFromFile();
        wff.fillData();
        airports = wff.getAirports();
    }

    public void linearSearch(String sstr)
    {
        int listLength = airports.size();
        System.out.println("Searching in " + listLength + " records");
        for (int i = 0; i < listLength; ++i)
        {
            if (airports.get(i).getCity().equals(sstr))
                System.out.println(airports.get(i));
        }
    }
    
    public String findAirportCode(String st)
    {
        int listLength = airports.size();
        System.out.println("Searching in " + listLength + " records");
        for (int i = 0; i < listLength; ++i)
        {
            if (airports.get(i).getCity().equals(st))
                if (airports.get(i).getCode3().length() != 0)
                    return airports.get(i).getCode3();
        }
        return "No Data";
    }
    
    public void printTop(int nu)
    {
        int listLength = airports.size();
        for (int i = 0; i < listLength && i < nu; ++i)
            System.out.println(airports.get(i));
    }
    
    public static void main(String[] argv) throws MalformedURLException,IOException
    {
        LinearSearch ls = new LinearSearch();
        String apc = new String();
        if (argv.length > 0)
        {
            ls.linearSearch(argv[0]);
            apc = ls.findAirportCode(argv[0]);
        }
        else
        {
            ls.linearSearch("London");
            apc = ls.findAirportCode("London");
        }
        System.out.println("The airport code returned: " + apc);
        //ls.printTopBottom(5);
    }
}
