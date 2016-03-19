/**
 * Point class to study a task of week 4 quiz
 * 
 * @author University of Madrid
 * @version 0.01
 * @since 2015-06-06
 */
public class Point 
{
    /**
     * Coordinates
     */
    private double x = 0;
    private double y = 0;
    
    /**
     * Constructor
     */
    public Point(int a, int b) 
    {
        x = a;
        y = b;
    }
    
    /**
     * getting coordinates
     */
    public double getX() 
    {
        return x;
    }
    
    public double getY() 
    {
        return y;
    }
    
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}