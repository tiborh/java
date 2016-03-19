import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class that creates a new world: MyWorld
 * 
 * @Java MOOC team, UC3M
 * @1.0
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(800, 600, 1); 
        setBackground("road.jpg");
        populateWorld();
    }
    
    public void populateWorld(){
        Car car1 = new Car(new String("car1.png"), new String("car2.png"));
        Car car2 = new Car(new String("car3.png"), new String("car4.png"));
        
        addObject(car1, 400, 300);
        addObject(car2, 400, 320);        
    }
}
