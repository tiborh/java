import comp102x.Canvas;
import comp102x.ColorImage;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class my_listener implements MouseListener
{
    private Canvas canvas;

    public my_listener()
    {
        canvas = new Canvas();
        canvas.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e)
    {
        System.out.println("mouse button clicked");
        ColorImage image = new ColorImage("happy_face.png");
        int x = e.getX() - image.getWidth()/2;
        int y = e.getY() - image.getHeight()/2;
        canvas.add(image,x,y);
    }
    
    public void mousePressed(MouseEvent e){
        System.out.println("mouse button pressed");
    }
    public void mouseReleased(MouseEvent e){
        System.out.println("mouse button released");
    }
    public void mouseEntered(MouseEvent e){
        System.out.println("mouse cursor entered canvas"); 
    }
    public void mouseExited(MouseEvent e){
        System.out.println("mouse cursor exited canvas"); 
    }
}
