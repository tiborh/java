import java.util.ArrayList;
/**
 * common package variables are defined here
 * 
 * @author tibor
 * @version 0.01
 */
public class common
{
    public static void printHeadTail(ArrayList<Airport> airps, int nu)
    {
        int listLength = airps.size();
        int i;
        for (i = 0; i < listLength && i < nu; ++i)
            System.out.println(airps.get(i));
        if (nu < listLength)
        {
            if (nu * 2 < listLength)
                System.out.println("...");
            for (int j = listLength-nu-1; j < listLength; ++j)
                if (j >= i)
                    System.out.println(airps.get(j));                
        }
    }
    public static final String fndat = "airport.dat";
    public static final String fncsv = "airport.csv";
}
