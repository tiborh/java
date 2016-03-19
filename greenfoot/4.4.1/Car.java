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
    private static int numberWheels = 4;                                           
    private boolean areHeadlightsOn = false;            
    
    private String image1;
    private String image2;
    
    private int initialX;
    private int initialY;
    
    private int numberOfLaps = 0;
    private boolean isHalfwayMark = false;
    private Counter counter;
    
    private boolean isKeyDown = false;
    
    /**
     * Constructor
     */
    public Car(String file1, String file2, Counter counter, int initialX, int initialY){
        setImage1(file1); // Sets the attribute image1 to file1
        setImage2(file2); // Sets the attribute image2 to file2
        setImage(file1); // Sets the image that appears in the screen at the beginning to the one in file1
        setInitialX(initialX); // Sets the initial X that the car has on the screen
        setInitialY(initialY); // Sets the initial Y that the car has on the screen
        setCounter(counter); // Sets the counter that will be used to show the number of laps completed for this car
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
        checkHalfwayLine();
        increaseCounter();
        restartPosition();
    }    

    /**
     * Move the car forward every time the key "up" is pressed
     */
    public void moveForward(){
        if (Greenfoot.isKeyDown("up")){
            if (!isTouching(Barrier.class)){
                move(5);
            }
            else
                move(-1);
        }
    }
    
    /**
     * Move the car back every time the key "down" is pressed
     */
    public void moveBack(){
        if (Greenfoot.isKeyDown("down")){
            if (!isTouching(Barrier.class)){            
                move(-1);
            }
            else
                move(1);
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
    
    /**
     * Checks if the object of the car class is touching the halfway line
     */        
    public void checkHalfwayLine(){
        if(isTouching(HalfwayLine.class)){
            setIsHalfwayMark(true);
        }
    }
      
    /**
     * Increases the numbr of laps of the car is it is touching the finish line and has previously crossed the halfway line
     */      
    public void increaseCounter(){
        if (isTouching(FinishLine.class) && getIsHalfwayMark()){
            setNumberOfLaps(getNumberOfLaps()+1);
            getCounter().update(getNumberOfLaps());            
            setIsHalfwayMark(false);
        }
    }    
     
    /**
     * Sets the car in the initial position
     */      
    public void restartPosition(){
        if (Greenfoot.isKeyDown("p")){ 
            setLocation(getInitialX(), getInitialY());
            setIsHalfwayMark(false);
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
    
    public void setInitialX(int initialX){
        this.initialX = initialX;
    }
    
    public int getInitialX(){
        return this.initialX;
    }       
    
    public void setInitialY(int initialY){
        this.initialY = initialY;
    }
    
    public int getInitialY(){
        return this.initialY;
    }       
    
    public void setNumberOfLaps(int numberOfLaps){
        this.numberOfLaps = numberOfLaps;
    }
    
    public int getNumberOfLaps(){
        return this.numberOfLaps;
    }   

    public void setIsHalfwayMark(boolean isHalfwayMark){
        this.isHalfwayMark = isHalfwayMark;
    }
    
    public boolean getIsHalfwayMark(){
        return this.isHalfwayMark;
    }     
    
    public void setCounter(Counter counter){
        this.counter = counter;
    }
    
    public Counter getCounter(){
        return this.counter;
    }       
}
