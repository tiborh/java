public class rectangle implements shape
{
    // instance variables - replace the example below with your own
    private double width;
    private double height;

    public rectangle(double w, double h)
    {
        width = w;
        height = h;
    }

    public double area()
    {
        return width * height;
    }
    
    public double perimeter() {
        return (width + height) * 2;
    }
}
