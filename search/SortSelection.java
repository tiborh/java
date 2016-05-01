import java.util.ArrayList;
import java.net.MalformedURLException;
import java.io.IOException;
/**
 * selection sort test
 * 
 * @author tibor 
 * @version 0.01
 */
public class SortSelection implements sorting
{
    private ArrayList<Airport> airports = new ArrayList<Airport>();

    /**
     * Constructor for objects of class SortInsert
     */
    public SortSelection() throws MalformedURLException,IOException
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
    
        for (int i = 0; i < listLength-1; ++i)
        {
            int minIndex = i;
            for (int j = i+1; j < listLength; ++j)
                if (0 < airports.get(minIndex).compareTo(airports.get(j)))
                    minIndex = j;                    

            if (minIndex != i)
            {
                swapElems(i,minIndex);
            }
        }
    }
        
    public static void main(String[] argv) throws MalformedURLException,IOException
    {
        SortSelection si = new SortSelection();
        si.sortList();
        int htsize;
        if (argv.length > 0)
            htsize = Integer.parseInt(argv[0]);
        else
            htsize = 5;
        common.printHeadTail(si.getList(),htsize);
    }
}
