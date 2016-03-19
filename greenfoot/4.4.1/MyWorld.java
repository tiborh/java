import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

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
        super(1024, 576, 1); 
        setBackground("track.png");
        populateWorld();
    }
    
    
    /**
     * Method that creates instances of the different objects and adds them to the world.
     * 
     */    
    public void populateWorld(){
        FinishLine finishLine = new FinishLine("finishline.png");
        HalfwayLine halfwayLine = new HalfwayLine("halfwayline.png");     
        Counter counterPlayer1 = new Counter(1, Color.BLUE, Color.GREEN);
        Counter counterPlayer2 = new Counter(2, Color.WHITE, Color.BLACK);
        
        Car[] cars = new Car[]{new Car(new String("car1.png"), new String("car2.png"), counterPlayer1, 450, 210),
            new SportCar(new String("sportcar1.png"), new String("sportcar2.png"), counterPlayer2, 450, 210, 2)};      
        
        Barrier b1 = new Barrier("barrier.png");
        Barrier b2 = new Barrier("barrier.png");
        Barrier b3 = new Barrier("barrier.png");  
        Barrier b4 = new Barrier("barrier.png");  
        Barrier b5 = new Barrier("barrier2.png");           
        Barrier b6 = new Barrier("barrier3.png");            

        addObject(finishLine, 450, 210);     
        addObject(halfwayLine, 300, 515);
        addObject(counterPlayer1, 40, 10);
        addObject(counterPlayer2, 40, 30);         
  
        for (int i = 0; i < cars.length; i++){
            addObject(cars[i], 390, 180 + 50*i);
        }        
       
        addObject(b1, 520, 140);
        addObject(b2, 680, 275);
        addObject(b3, 520, 400);   
        addObject(b4, 520, 420);     
        addObject(b5, 680, 445);                
        addObject(b6, 150, 270);                      
    }
    
}
