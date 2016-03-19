import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // needed for mouse listener
public class window_demo extends JFrame implements MouseListener
{
    public window_demo()
    {
        setTitle("Window created using JFrame");
        setSize(400,200);
        setLocation(200,200); //not needed for minimum
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //some addition to the simplest version
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        
        JLabel label = new JLabel("A label on a panel");
        content.add(label);
        JButton button = new JButton("Click Me");
        content.add(button);
        
        //add a listener for the button to do something
        // also added: "java.awt.event" and "implements MouseListener"
        // and of course the listeners are defined at this point too.
        button.addMouseListener(this); // this makes the instance a source
        
        setContentPane(content);
    }
    
    public void mouseClicked(MouseEvent e)
    {
        Toolkit.getDefaultToolkit().beep();
        System.out.println("mouse button clicked");
    }
    public void mousePressed(MouseEvent e){
        System.out.println("mouse button pressed");
    }
    public void mouseReleased(MouseEvent e){
        System.out.println("mouse button released");
    }
    public void mouseEntered(MouseEvent e){
        System.out.println("mouse cursor entered button"); 
    }
    public void mouseExited(MouseEvent e){
        System.out.println("mouse cursor exited button"); 
    }
}
