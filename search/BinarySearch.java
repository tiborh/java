import java.util.ArrayList;
import java.util.Collections;
import java.net.MalformedURLException;
import java.io.IOException;
/**
 * using binary search instead of linear
 * 
 * @author tibor
 * @version 0.01
 */
public class BinarySearch extends FasterLinearSearch
{
    // instance variables - replace the example below with your own
    private ArrayList<Airport> airports;

    /**
     * Constructor for objects of class searchCity
     */
    public BinarySearch() throws MalformedURLException,IOException
    {
        super();
    }
    
    public int getSize() { return airports.size(); }
    
    public Airport binarySearch(String sstr)
    {
        super.sortList();
        airports = super.getAirports();
        //Collections.sort(airports);
        int low = 0;
        int high = airports.size() - 1;
        int mid;
        while (low <= high)
        {
            mid = low + (high - low) / 2;
            int compare = sstr.compareTo(airports.get(mid).getCity());
            
            if (compare < 0)
                high = mid - 1;
            else if (compare > 0)
                low = mid + 1;
            else
                return airports.get(mid);
        }
        
        return null;
    }
    
    /** main in BinarySearch */
    public static void main(String[] argv) throws MalformedURLException,IOException
    {
        BinarySearch ls = new BinarySearch();
        ls.cleanList();
        String searched;
        if (argv.length > 0)
            searched = argv[0];
        else
            searched = "London";
            
        Airport result = ls.binarySearch(searched);
        System.out.println("Searching in " + ls.getSize() + " records");        
        if (result == null)
            System.out.println(searched + "is not found");
        else
            System.out.println("The airport code for " + result.getCity() 
                + " (" + result.getName() + ") in "
                + result.getCountry() + " is " + result.getCode3());

        //ls.printTopBottom(5);
    }
}
