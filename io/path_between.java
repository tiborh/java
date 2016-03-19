import java.nio.file.*;
public class path_between
{
    public static void main(String[] argv)
    {
        Path p1 = Paths.get("www/home/joe");
        Path p2 = Paths.get("www/home/sally");
        System.out.format("P1 %s%n",p1);
        System.out.format("P2 %s%n",p2);
        System.out.format("Path from P1 to P2 %s%n",p1.relativize(p2));
    }
}
