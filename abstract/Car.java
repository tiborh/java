/**
 * Car class of the Java program.
 */

public class Car extends Vehicle
{
    
    /**
     * Creates a new car
     *
     * @param c  the car color
     * @param l  the state of the car lights
     */
    public Car(String c, boolean l)
    {
        super(c,l);
    }
 
    /**
     * Returns a String representation of the car
     *
     * @return the String representation of the car
     */
    public String toString()
    {
       String state = "";
        if(lights)
        {
            state = "on";
        }else
        {
            state = "off";
        }
        String result = "This car is "+color+", lights are "+state+".";
        return result;
    }
    
    /**
     * Prints a description of the car to the console
     *
     */
    public void printDescription()
    {
        System.out.println(toString());
    }
    
}