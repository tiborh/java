import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.File;
/**
 * Same as DataCollector but works from file saved by StreamSaver
 * 
 * @author tibor
 * @version 0.01
 */
public class WorkFromFile extends DataCollect
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class WorkFromFile
     */
    public WorkFromFile(String fn) throws MalformedURLException,IOException
    {
        File f = new File(common.fndat);
        if (!f.exists())
        {
            StreamSaver ss = new StreamSaver();
            ss.saveStreamToFile();
        }
        br = new BufferedReader(new FileReader(fn));
    }

    public WorkFromFile() throws MalformedURLException,IOException
    {
        this(common.fndat);
    }

    /** main in WorkFromFile **/
    public static void main(String[] argv) throws MalformedURLException,IOException
    {
        WorkFromFile wff = new WorkFromFile();
        wff.fillData();
        wff.printData(5);
        System.out.println("..");
        wff.printLastData(5);
    }
}
