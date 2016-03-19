/**
 * Line class to study a task of week 4 quiz
 * 
 * @author University of Madrid
 * @version 0.01
 * @since 2015-06-06
 */
public class Line
{
    /**
     * Points of the line
     */
    private Point p1;
    private Point p2;
    private double lineLength;

    /**
     * constructing a line from two endpoints
     */
    public Line (Point firstPoint, Point secondPoint) 
    {
        p1 = firstPoint;
        p2 = secondPoint;
        calcLength();
    }

    /**
     * Implementation of the length of a line
     */
    private void calcLength()
    {
        lineLength = Math.sqrt(
                Math.pow(
                    p2.getX()-p1.getX(),2
                    ) + 
                Math.pow(
                    p2.getY()-p1.getY(),2
                    )
            );
    }
    
    public double getLineLength()
    {
        return lineLength;
    }
}