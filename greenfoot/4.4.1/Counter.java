import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private int id; 
    private Color color1;
    private Color color2;
    
    /**
     * Constructor
     */    
    public Counter(int id, Color color1, Color color2){
        setId(id);
        setColor1(color1);
        setColor2(color2);
        update(0);
    }
    
    public void update(int numberOfLaps){
        setImage(new GreenfootImage("Player " + id + ": " + numberOfLaps, 20, getColor1(), getColor2()));
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getID(){
        return this.id;
    }      
    
    public void setColor1(Color color1){
        this.color1 = color1;
    }
    
    public Color getColor1(){
        return this.color1;
    }   

    public void setColor2(Color color2){
        this.color2 = color2;
    }
    
    public Color getColor2(){
        return this.color2;
    } 
}
