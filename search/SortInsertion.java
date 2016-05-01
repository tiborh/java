import java.util.ArrayList;
import java.net.MalformedURLException;
import java.io.IOException;
/**
 * insertion sort test
 * 
 * @author tibor 
 * @version 0.01
 */
public class SortInsertion implements sorting
{
    private ArrayList<Airport> airports = new ArrayList<Airport>();

    /**
     * Constructor for objects of class SortInsert
     */
    public SortInsertion() throws MalformedURLException,IOException
    {
        LinearSearch ls = new LinearSearch();
        ls.cleanList();
        airports = ls.getAirports();
    }

    public ArrayList<Airport> getList() { return airports; }
    
    public void swapElems(int e1, int e2)
    {
                Airport anAirp = airports.get(e1);
                airports.set(e1,airports.get(e2));
                airports.set(e2,anAirp);        
    }
    
    public void sortList()
    {
        int listLength = airports.size();    
        int currIndex;
        
        for (int pos = 1; pos < listLength; ++pos)
        {
            currIndex = pos;
            
            while( currIndex > 0 && 0 > airports.get(currIndex).compareTo(airports.get(currIndex-1)))
            {
                swapElems(currIndex,currIndex-1);
                --currIndex;
            }
        }
        
    }
        
    public static void main(String[] argv) throws MalformedURLException,IOException
    {
        SortInsertion si = new SortInsertion();
        si.sortList();
        int htsize;
        if (argv.length > 0)
            htsize = Integer.parseInt(argv[0]);
        else
            htsize = 5;
        common.printHeadTail(si.getList(),htsize);
    }
}