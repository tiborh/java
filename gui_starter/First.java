import processing.core.*;
import java.applet.*;
/**
 * Write a description of class First here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class First extends PApplet
    {
    public void settings() 
    {
        size(480, 120);
    }

    public void draw() 
    {
      if (mousePressed) 
        {
          fill(0);
        } else {
          fill(255);
        }
      ellipse(mouseX, mouseY, 80, 80);
    }
}
