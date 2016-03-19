import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Garage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garage extends Actor
{
    private static final String openImage = "house-opened.png";
    private static final String closedImage = "house-05.png";
    private boolean isOpen = false;
    /**
     * Act - do whatever the Garage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (this.isTouching(null)){
              
        }
        
    }   
    
    public void openGarage()
    {
        this.setImage(openImage);
        isOpen = true;
        System.out.println("You have entered the garage.");
    }
    
    public void closeGarage()
    {
        this.setImage(closedImage);
        isOpen = false;
        System.out.println("You have left the garage.");
    }
    
    boolean isOpen()
    {
        return isOpen;
    }
}
