/**
 * Main class of the Java program.
 */

public class test_vehicles 
{
    public static void main(String[] args) 
    {
        Car c = new Car("blue",true);
        Motorbike m = new Motorbike("black",false);
        m.setLights(true);
        Truck t = new Truck("white",false);
        c.printDescription();
        m.printDescription();
        t.printDescription();
    }
}
