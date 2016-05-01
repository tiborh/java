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
    private ArrayList<Airport> airports = new ArrayList<Airport>();

    /**
     * Constructor for objects of class searchCity
     */
    public LinearSearch() throws MalformedURLException,IOException
    {
        WorkFromFile wff = new WorkFromFile();
        wff.fillData();
        airports = wff.getAirports();
    }

    public ArrayList<Airport> getAirports() { return airports; }
    
    public void cleanList()
    {
        int listLength = airports.size();
        for(int i = 0; i < listLength; ++i)
        {
            if (airports.get(i).getCode3().length() == 0)
            {
                airports.remove(i);
                listLength = airports.size();
            }
        }
    }
    
    public Airport linearSearch(String sstr)
    {
        int listLength = airports.size();
        System.out.println("Searching in " + listLength + " records");
        for (int i = 0; i < listLength; ++i)
        {
            if (airports.get(i).getCity().toUpperCase().equals(sstr.toUpperCase()))
            {
                System.out.println("i == " + i);
                return airports.get(i);
            }
        }
        return null;
    }
    
    public void prinTop(int nu)
    {
        int listLength = airports.size();
        for (int i = 0; i < listLength && i < nu; ++i)
            System.out.println(airports.get(i));
    }
    
    /** main in LinearSearch */
    public static void main(String[] argv) throws MalformedURLException,IOException
    {
        String searched;
        LinearSearch ls = new LinearSearch();
        ls.cleanList();
        Airport result;
        if (argv.length > 0)
            searched = argv[0];
        else
            searched = "London";
            
        result = ls.linearSearch(searched);
        if (result == null)
            System.out.println(searched + "is not found");
        else
            System.out.println("The airport code for " + result.getCity() + " (" + result.getName() + ") in "
                + result.getCountry() + " is " + result.getCode3());
        //ls.printTopBottom(5);
    }
}
