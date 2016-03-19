
/**
 * Write a description of class Circle2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle2
{
    public double circleArea (double radius){
        double first=Math.PI;
        double second=Math.abs(radius);
        double third=Math.pow(second,2);
        return first*third;
    }
}
