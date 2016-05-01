package buggy;

import java.util.ArrayList;
import java.net.MalformedURLException;
import java.io.IOException;
/**
 * Sorting from one ArrayList into another
 * 
 * @author tibor
 * @version 0.01
 */
public class SortCopy implements sorting
{
    // instance variables - replace the example below with your own
    private ArrayList<Airport> airports = new ArrayList<Airport>();

    /**
     * Constructor for objects of class SortInsert
     */
    public SortCopy() throws MalformedURLException,IOException
    {
        LinearSearch ls = new LinearSearch();
        ls.cleanList();
        airports = ls.getAirports();
    }

    public ArrayList<Airport> getList() { return airports; }
    
    public void sortList()
    {
        ArrayList<Airport> airpSorted = new ArrayList<Airport>();
        int listLength = airports.size();
        airpSorted.add(airports.remove(0));
        
        for(int i = 1; i < listLength; ++i)
        {
            Airport anAirp = airports.remove(0);
            for (int j = 0; j < airpSorted.size(); ++j)
            {
                if (j == 0)
                    if (0 > anAirp.compareTo(airpSorted.get(0)))
                    {
                        airpSorted.add(0,anAirp);
                        break;
                    }
                if (j == airpSorted.size()-1)
                {
                        airpSorted.add(anAirp);
                        break;
                } else
                {
                    if (0 >= anAirp.compareTo(airpSorted.get(j)) && 
                            0 < anAirp.compareTo(airpSorted.get(j+1)))
                    {
                        airpSorted.add(j+1,anAirp);
                        break;
                    }
                }
                if (airpSorted.size() > listLength)
                {
                    System.err.println("Runaway sorted list! Aborting.");
                    common.printHeadTail(airpSorted,5);
                    return;
                }
            }
        }
        if (airports.size() != 0)
            System.err.println("Source list is not empty (" + airports.size() + "). Aborting.");
        else
            airports = airpSorted;
    }
    
    public static void main(String[] argv) throws MalformedURLException,IOException
    {
        SortCopy si = new SortCopy();
        si.sortList();
        int htsize;
        if (argv.length > 0)
            htsize = Integer.parseInt(argv[0]);
        else
            htsize = 5;
        common.printHeadTail(si.getList(),htsize);
    }
}
