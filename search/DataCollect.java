import java.util.ArrayList;
//for url
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;
//for input 
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//for https:
import java.security.cert.Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
//for file writing
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.charset.Charset;

/**
 * Get airport data and put it into a structure.
 * 
 * @author Tibor
 * @version 0.01
 */
public class DataCollect
{
    // instance variables - replace the example below with your own
    private ArrayList<Airport> airports = new ArrayList<Airport>();
    private URL url;
    protected BufferedReader br;
    private String cvsSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
    private static final String defEnc = "UTF-8";
    private static final String defSep = "\t";
    
    /**
     * Constructor for objects of class DataCollect
     */
    public DataCollect(String urlStr) throws MalformedURLException,IOException
    {
        url = new URL(urlStr);
        //URLConnection con = url.openConnection(); // Does not work for https
        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
    }
    
    public DataCollect() throws MalformedURLException,IOException
    {
        this("https://raw.githubusercontent.com/jpatokal/openflights/master/data/airports.dat");
    }
    
    public void closeStream() throws IOException
    {
        if (this.br == null)
            System.out.println("Nothing to close. Connection is null.");
        else
            this.br.close();
    }

    public int fillData() throws IOException
    {
        String input;
        String line = "";
        int i = 0;
        while ((line = br.readLine()) != null)
        {
          String[] airpDat = line.split(cvsSplitBy,-1);
          airpDat = checkArray(airpDat);
          Airport anAirp = new Airport(Integer.parseInt(airpDat[0]),airpDat[1],airpDat[2],airpDat[3],airpDat[4]);
          //System.out.println(anAirp);
          this.airports.add(anAirp);
          ++i;
        }
        return i+1;
    }
    
    private static String[] checkArray(String[] airpDat)
    {
        int airpDatSize = airpDat.length;
        for (int j = 0; j < airpDatSize; ++j)
        if (airpDat[j].charAt(0) == '"' && airpDat[j].endsWith("\""))
        {
            if (airpDat[j].length() > 2)
            airpDat[j] = airpDat[j].substring(1, airpDat[j].length()-1);
            else
            airpDat[j] = "";
            //System.out.println(airpDat[j]);
        }
        return airpDat;
    }
    
    public void setBr(BufferedReader br) { this.br = br; }
    
    public void setCvsSplitBy(String sep) { this.cvsSplitBy = sep; }
    
    public String getCvsSplitBy() { return this.cvsSplitBy; }
    
    public BufferedReader getStream() { return br; }
    
    public String getEnc() { return defEnc; }    
    
    public ArrayList<Airport> getAirports() { return airports; }
    
    public int fillData(int nu) throws IOException
    {
        String input;
        String line = "";
        int i;
        for (i = 0; i < nu && (line = br.readLine()) != null; ++i)
        {
          String[] airpDat = line.split(cvsSplitBy);
          airpDat = checkArray(airpDat);
          Airport anAirp = new Airport(Integer.parseInt(airpDat[0]),airpDat[1],airpDat[2],airpDat[3],airpDat[4]);          
          this.airports.add(anAirp);
        }
        return i;
    }    
        
    public void saveDataToFile(String fn, String sep, String enc) throws IOException
    {
        ArrayList<String> airps = new ArrayList<String>();
        int listSize = airports.size();
        
        for (int j = 0; j < listSize; ++j)
            airps.add(airports.get(j).toString());
        
        Path fp = Paths.get(fn);
        Files.write(fp, airps, Charset.forName(enc));
    }
    
    public void saveDataToFile(String fn, String sep) throws IOException
    {
        this.saveDataToFile(fn,sep,defEnc);
    }

    public void saveDataToFile(String fn) throws IOException
    {
        this.saveDataToFile(fn,defSep,defEnc);
    }
    
    public void saveDataToFile() throws IOException
    {
        this.saveDataToFile(common.fncsv,defSep,defEnc);
    }
    
    public void printLines(int nuLines) throws IOException
    {
        String input;
        for (int i = 0; i < nuLines && (input = br.readLine()) != null; ++i)
        {
          System.out.println(input);
        }
    }
        
    public void printData()
    {
        int listSize = airports.size();
        for (int i = 0; i < listSize; ++i)
            System.out.println(airports.get(i));
    }

    public void printData(int nu)
    {
        int listSize = airports.size();
        for (int i = 0; i < listSize && i < nu; ++i)
            System.out.println(airports.get(i));
    }

    public void printLastData(int nu)
    {
        int listSize = airports.size();
        int i = listSize-nu;
        if (i < 0)
            i = 0;
        for (int j = 0; i < listSize && j < nu; ++i,++j)
            System.out.println(airports.get(i));

    }

    public String toString()
    {
        String datOut = new String();
        int listSize = airports.size();
        
        for (int j = 0; j < listSize; ++j)
            datOut += airports.get(j) + "\n";
        
        return datOut;
    }
    
    /** main in DataCollect */
    public static void main(String[] argv) throws MalformedURLException,IOException
    {
        DataCollect dc = new DataCollect();
        
        //dc.printLines(5);
        //System.out.println("Number of data collected: " + dc.fillData(6));
        //dc.printData();
        System.out.println("Number of data collected: " + dc.fillData());
        dc.printData(5);
        System.out.println("..");
        dc.printLastData(5);
        dc.saveDataToFile("airport.csv");
        
        dc.closeStream();
        
        //System.out.println(dc); //only for serious testing
    }
}
