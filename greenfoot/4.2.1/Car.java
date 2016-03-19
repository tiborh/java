import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class that models objects of type "car"
 * 
 * @Java MOOC team, UC3M
 * @1.0
 */
public class Car extends Actor
{
    // Attributes of the class Car
    private static int numberWheels = 4;                // Number of wheels                           
    private boolean areHeadlightsOn = false;            // State of headlights (on => true; off => false)
    
    private String image1;
    private String image2;
    
    private boolean isKeyDown = false;
    
    /**
     * Constructor
     */
    public Car(String file1, String file2){
        setImage1(file1); // Sets the attribute image1 to file1
        setImage2(file2); // Sets the attribute image2 to file2
        
        setImage(file1); // Sets the image that appears in the screen at the beginning to the one in file1
    }
    
    /**
     * Method that is being always invoked when the program is running
     */
    public void act(){
        moveForward();
        moveBack();
        turnLeft();
        turnRight();
        turnHeadlightsOn();
        turnHeadlightsOff();
    }    

    /**
     * Move the car forward every time the key "up" is pressed
     */
    public void moveForward(){
        if (Greenfoot.isKeyDown("up")){
            move(5);
        }
    }
    
    /**
     * Move the car back every time the key "down" is pressed
     */
    public void moveBack(){
        if (Greenfoot.isKeyDown("down")){
            move(-1);
        }
    }    
    
    /**
     * Turn the car to the left every time the key "left" is pressed
     */    
    public void turnLeft(){
        if (Greenfoot.isKeyDown("left")){ 
            turn(-4);
        }
    }
    
    /**
     * Turn the car to the right every time the key "right" is pressed
     */      
    public void turnRight(){
        if (Greenfoot.isKeyDown("right")){ 
            turn(4);
        }
    }
    
    /**
     * Turn the headlights on when the key "space" is pressed.
     * The attribute isKeyDown is used to prevent setting the headlights on and off when the key "space" is pressed (and remains pressed for some time)
     */      
    public void turnHeadlightsOn(){
        if (Greenfoot.isKeyDown("space") && !getIsKeyDown()){
            if (getAreHeadlightsOn() == false){
                setAreHeadlightsOn(true);
                setImage(getImage2());
                setIsKeyDown(true);
            }

        }
        if (!Greenfoot.isKeyDown("space") && getIsKeyDown()){
             setIsKeyDown(false);
        }           
    }   

    /**
     * Turn the headlights off when the key "space" is pressed.
     * The attribute isKeyDown is used to prevent setting the headlights off and on when the key "space" is pressed (and remains pressed for some time)
     */          
    public void turnHeadlightsOff(){
        if (Greenfoot.isKeyDown("space") && !getIsKeyDown()){
            if (getAreHeadlightsOn() == true){
                setAreHeadlightsOn(false);
                setImage(getImage1());
                setIsKeyDown(true);
            }

        }
        if (!Greenfoot.isKeyDown("space") && getIsKeyDown()){
            setIsKeyDown(false);
        }           
    }      
     
    public void setAreHeadlightsOn(boolean areHeadlightsOn){
        this.areHeadlightsOn = areHeadlightsOn;
    }
    
    public boolean getAreHeadlightsOn(){
        return this.areHeadlightsOn;
    }     
    
    public void setImage1(String image1){
        this.image1 = image1;
    }
    
    public String getImage1(){
        return this.image1;
    }    
    
    public void setImage2(String image2){
        this.image2 = image2;
    }
    
    public String getImage2(){
        return this.image2;
    }       
    
    public void setIsKeyDown(boolean isKeyDown){
        this.isKeyDown = isKeyDown;
    }
    
    public boolean getIsKeyDown(){
        return this.isKeyDown;
    }          
}
