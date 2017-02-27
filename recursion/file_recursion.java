import java.io.File;
/**
 * Write a description of class file_recursion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class file_recursion
{
    final private static File fn = new File("./txt/file.txt");

    /**
     * @param f a file in the filesystem
     * @return the full pathname of f from the root of the filesystem
     */
    public static String fullPathname(File f) {
        if (f.getParentFile() == null) {
            // base case: f is at the root of the filesystem
            return f.getName();  
        } else {
            // recursive step
            return fullPathname(f.getParentFile()) + "/" + f.getName();
        }
    }
    
    public static void main(String[] argv) {
        System.out.println(fullPathname(fn));
        System.out.println("Exists: " + fn.exists());
        if (fn.exists()) {
            System.out.println("Can read: " + fn.canRead());
            System.out.println("Can write: " + fn.canWrite());
            System.out.println("Can execute: " + fn.canExecute());
        }
    }
}
