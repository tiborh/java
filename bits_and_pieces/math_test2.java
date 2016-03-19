import comp102x.IO;
/**
 * Write a description of class math_test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class math_test2
{
    public static void main(String[] args)
    {
        System.out.println("Pi: " + Math.PI);
        System.out.print("Angle (deg): ");
        int angle_deg = IO.inputInteger( );
        double angle_rad = angle_deg * Math.PI / 180;
        System.out.println("Angle in radians: " + angle_rad);
        System.out.print("Distance: ");
        int dist = IO.inputInteger( );
        double x_dist = dist * Math.cos(angle_rad);
        double y_dist = dist * Math.sin(angle_rad);
        System.out.println("x dist: " + x_dist);
        System.out.println("y dist: " + y_dist);
    }
}
