import java.nio.file.*;
public class compare_paths
{
    public static void main(String[] argv)
    {
        Path p1 = Paths.get("/Users/etibhar/tmp");
        Path p2 = Paths.get("../../../tmp");
        System.out.format("P1 %s%n",p1);
        System.out.format("P2 %s%n",p2);
        Path pwd = Paths.get(System.getProperty("user.dir"));
        System.out.format("current working directory: %s%n",pwd);
        System.out.format("pwd.resolve(p2): %s%n", pwd.resolve(p2));
        Path norm_p2 = p2.normalize();
        System.out.format("result of above normalised): %s%n", norm_p2);
        Path p1_absolute = p1.toAbsolutePath();
        Path p2_absolute = p2.toAbsolutePath();
        System.out.format("P1 abzolute: %s%n",p1_absolute);
        System.out.format("P2 absolute: %s%n",p2_absolute);
        Path p2_abs_norm = p2_absolute.normalize();
        System.out.format("P2 absolute normalised: %s%n",p2_abs_norm);
        //looks absolutely crazy:
        System.out.format("Path from P1 to P2 %s%n",p1.toAbsolutePath().relativize(pwd.resolve(p2.toAbsolutePath())));
        //wow:
        System.out.format("Same normalised %s%n",p1.toAbsolutePath().relativize(pwd.resolve(p2.toAbsolutePath())).normalize());
        if (p1_absolute.equals(p2_abs_norm)) {
            System.out.println("The paths are equal.");
        }
        if (p1_absolute.normalize().equals(p2_absolute.normalize())) {
            System.out.println("The normalised paths are equal.");
        }
        Path beginning = Paths.get("/Users");
        if (p1.startsWith(beginning)) {
            System.out.format("Path2 starts with %s%n",beginning);
        }
        Path ending = Paths.get("tmp");
        if (p1.endsWith(ending)) {
            System.out.format("Path1 ends with %s%n",ending);
        }
    }
}
