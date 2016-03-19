import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class that models objects of type "car"
 * 
 * @Java MOOC team, UC3M
 * @1.0
 */
public class SportCar extends Car
{
    // Specific attributes of the class SportCar
    private int turbo;       // Turbo coefficient of the sport car    
        
    /**
     * Constructor
     */
    public SportCar(String file1, String file2, Counter counter, int initialX, int initialY, int turbo){
        super(file1, file2, counter, initialX, initialY); // Invokes the constructor of the Car class
        if (turbo > 0) {     // Checks that the attribute turbo is higher than 0
            setTurbo(turbo); 
        } else {
            setTurbo(0);
        }
    }
    
    /**
     * Overriding the method moveForward() from the Car class to move forward faster
     */
    public void moveForward(){
        if (Greenfoot.isKeyDown("w")){
            if(!isTouching(Barrier.class)){
                move(5 + getTurbo());
            }
        }
    }    
    
    /**
     * Overriding the method moveBack() from the Car class to move back faster
     */
    public void moveBack(){
        if (Greenfoot.isKeyDown("s")){
            if(!isTouching(Barrier.class)){
                move(-1 - getTurbo());
            } 
        }
    }    
    
    /**
     * Overriding the method turnLeft() from the Car class to turn left faster
     */    
    public void turnLeft(){
        if (Greenfoot.isKeyDown("a")){ 
            turn(-4 - getTurbo());
        }
    }
    
    /**
     * Overriding the method turnRight() from the Car class to turn right faster
     */      
    public void turnRight(){
        if (Greenfoot.isKeyDown("d")){ 
            turn(4 + getTurbo());
        }
    }   
    
    /**
     * Sets the Car in the initial position
     */      
    public void restartPosition(){
        if (Greenfoot.isKeyDown("z")){ 
            setLocation(getInitialX(), getInitialY());
            setIsHalfwayMark(false);
        }
    }    
    
    public void setTurbo(int turbo){
        this.turbo = turbo;
    }
    
    public int getTurbo(){
        return this.turbo;
    }     
}
