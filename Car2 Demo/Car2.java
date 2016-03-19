import comp102x.IO;
import comp102x.Canvas;
import comp102x.ColorImage;

/**
 * Write a description of class Cars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car2
{

    String owner = "NoName";
    ColorImage carImage = new ColorImage("Car1.png");
    double gasMileage = 10.0; //litres per 100 kms
    double gasInTank = 10.0;
    
    public Car2 () {}
    
    public Car2(String nameOfOwner) 
    {
        owner = nameOfOwner;
        carImage = new ColorImage();
    }
    
    public Car2 (String nameOfOwner, double newGasMileage) 
    {
        owner = nameOfOwner;
        carImage = new ColorImage( );
        gasMileage = newGasMileage;
    }

    public void moveForward(int dist)
    { 
        // check if there is enough gas
        int range = (int) (gasInTank / gasMileage * 100);
        if (Math.abs(dist) > range) {
            System.out.println("You have run out of gas.");
            if (dist < 0)
                dist = -range;
            else
                dist = range;
        }
        // Obtain the current rotation in degrees
        int rotationInDegrees  = carImage.getRotation();
        
        // Convert the current rotation from degrees to radians
        double rotationInRadians = rotationInDegrees * Math.PI / 180;
        
        // Calculate the distance to move in both x and y directions
        double distX = dist * Math.cos(rotationInRadians);
        double distY = dist * Math.sin(rotationInRadians);
        
        // Move the car in both x and y directions with the correct distances
        // Notice that setX() and setY() take int as argument
        carImage.setX(carImage.getX() + (int)distX);
        carImage.setY(carImage.getY() + (int)distY);
        
        // Update the amount of gas in tank assumming that each unit of dist is 10m
        double gasUsed = Math.abs(dist) * gasMileage / 100.0;
        gasInTank = gasInTank - gasUsed;
        IO.outputln("Amount of gas used: " + gasUsed + ", gas remained: " + gasInTank);
    }
    
    public void makeTurn(int angle) 
    { 
        // Change the orientation of car from current orientation plus angle
        carImage.setRotation(carImage.getRotation() + angle);
    }
    
    // addGas adds an amount of gas equal to gasToAdd to gasInTank
     public void addGas(double gasToAdd) {
         //gasInTank = gasInTank + gasUsed;
         gasInTank = gasInTank + gasToAdd;
    }
    
    public void Car2Demo()
    {
        Canvas canvas = new Canvas();
        canvas.add(carImage,200,200);
    }

}
