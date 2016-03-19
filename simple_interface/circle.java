public class circle implements shape
{
    // instance variables - replace the example below with your own
    private double radius;
    private final double PI = Math.PI;

    public circle(double r)
    {
        // initialise instance variables
        radius = r;
    }

    public double area()
    {
        return PI * Math.pow(radius,2);
    }
    
    public double perimeter() {
        return 2 * PI * radius;
    }
}
