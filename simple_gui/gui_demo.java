import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // needed for mouse listener
public class gui_demo extends JFrame implements MouseListener
{
    private JLabel label;
    
    public gui_demo()
    {
        setTitle("Window created using JFrame");
        setSize(400,200);
        setLocation(200,200); //not needed for minimum
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        //some addition to the simplest version
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.addMouseListener(this); // a listener to the panel too
        
        label = new JLabel("A label on a panel");
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
        // the definition of click: pressed and released in the same position
        Toolkit.getDefaultToolkit().beep();
        System.out.println("Clicked");
    }
    public void mousePressed(MouseEvent e){
        label.setText("Pressed at " + e.getX() + " " + e.getY());
    }
    public void mouseReleased(MouseEvent e){
        label.setText("Released at " + e.getX() + " " + e.getY());
    }
    public void mouseEntered(MouseEvent e){
        label.setText("Entered");
    }
    public void mouseExited(MouseEvent e){
        label.setText("Exited");
    }
}
