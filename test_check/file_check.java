import java.nio.file.*;

public class file_check
{
    public static void main(String[] args)
    {
        Path file1 = Paths.get("doc");
        Path file2 = Paths.get("file_check.java");
        
        if (Files.isRegularFile(file1))
            System.out.println(file1 + " is a regular file");
        else
            System.out.println(file1 + " is not a regular file");
            
        if (Files.isDirectory(file1))
            System.out.println(file1 + " is a directory");
        else
            System.out.println(file1 + " is not a directory");
    }
}
