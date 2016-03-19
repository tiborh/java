import java.nio.file.*;
import java.io.IOException;
public class real_path
{
    public static void main(String[] argv)
    {
        if (argv.length < 1) {
            System.out.println("usage: FileTest file");
            System.exit(-1);
        }
        
        Path inputPath = Paths.get(argv[0]);
        System.out.format("input path: %s%n",inputPath);
        
        try {
            Path fp = inputPath.toRealPath();
            System.out.format("real path: %s%n",fp);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", inputPath);
            // Logic for case when file doesn't exist.
        } catch (IOException x) {
            System.err.format("%s%n", x);
            // Logic for other sort of file error.
        }
    }
}
