import java.util.ArrayList;
import java.util.Collections;
import java.net.MalformedURLException;
import java.io.IOException;
/**
 * sorts the data before linear search
 * 
 * @author tibor
 * @version 0.01
 */
public class FasterLinearSearch extends LinearSearch
{
    // instance variables - replace the example below with your own
    public FasterLinearSearch() throws MalformedURLException,IOException
    {
        super();
    }

    public void sortList()
    {
        Collections.sort(super.getAirports());
    }
       
    /** main in FasterLinearSearch */
    public static void main(String[] argv) throws MalformedURLException,IOException
    {
        String searched;
        FasterLinearSearch fls = new FasterLinearSearch();
        fls.cleanList();
        //fls.prinTop(5);
        fls.sortList();
        //fls.prinTop(5);
        
        Airport result;
        if (argv.length > 0)
            searched = argv[0];
        else
            searched = "London";
            
        result = fls.linearSearch(searched);
        if (result == null)
            System.out.println(searched + "is not found");
        else
            System.out.println("The airport code for " + result.getCity() + " (" + result.getName() + ") in "
                + result.getCountry() + " is " + result.getCode3());
        //ls.printTopBottom(5);
    }    
}
