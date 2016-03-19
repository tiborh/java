// for inherited stuff
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.io.IOException;
// for new stuff
import java.util.ArrayList;
// for file write
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.File;
import java.nio.charset.Charset;

/**
 * writes the input stream into a file for future use
 * 
 * @author tibor
 * @version 0.01
 */
public class StreamSaver extends DataCollect
{
    // instance variables - replace the example below with your own
    private String fn = common.fndat;
 
    public StreamSaver() throws MalformedURLException,IOException
    {
        super();
    }
    
    public StreamSaver(String fn) throws MalformedURLException,IOException
    {
        super(fn);
    }

    public ArrayList<String> getLines() throws IOException
    {
        BufferedReader br = this.getStream();
        ArrayList<String> airps = new ArrayList<String>();
        String input;
        while ((input = br.readLine()) != null)
        {
          airps.add(input);
        }
        this.closeStream();
        return airps;
    }
    
    public void saveStreamToFile(String fn) throws IOException
    {
        ArrayList<String> airps = this.getLines();
        int listSize = airps.size();
        int sampleSize = 5;
        //for (int i = 0; i < listSize; ++i)
        for (int i = 0; i < sampleSize && sampleSize < listSize; ++i)
            System.out.println(airps.get(i));

        System.out.println("...");
            
        int tailIndex = listSize - sampleSize -1;
        if (tailIndex > sampleSize)
            for (int i = listSize-6; i < listSize; ++i)
                System.out.println(airps.get(i));

        Path fp = Paths.get(fn);
        Files.write(fp, airps, Charset.forName(this.getEnc()));

    }
    
    public void setFileName(String fn){ this.fn = fn; }
    public String getFileName() { return this.fn; }
    public String getFilePathName()
    {
        File cwd = new File(System.getProperty("user.dir"));
        File fullpath = new File (cwd,this.fn);
        return fullpath.toString();
    }
    
    public void saveStreamToFile() throws IOException
    {
        this.saveStreamToFile(this.fn);
    }
    
    /** main in StreamSaver **/
    public static void main(String[] argv) throws MalformedURLException,IOException
    {
        StreamSaver ss = new StreamSaver();
        ss.saveStreamToFile();
        System.out.println("File saved to: " + ss.getFilePathName());
    }
}
