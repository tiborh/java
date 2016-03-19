import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class that creates a new world: MyWorld
 * 
 * @Java MOOC team, UC3M
 * @1.0
 */
public class MyWorld extends World
{

    Car theCar;
    Garage theGarage;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(800, 600, 1); 
        setBackground("road.jpg");
        theGarage=new Garage();
        theCar=new Car(theGarage);
        populateWorld();
    }
    
    public void populateWorld(){
        addObject(theCar, 400, 300);
        addObject (theGarage, 700,100);
    }
}
