package testSuite;


/**
 * Write a description of class MessageUtil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MessageUtil
{
    // instance variables - replace the example below with your own
    private String msg;

    /**
     * value to msg
     */
    public MessageUtil(String message)
    {
        this.msg = message;
    }

    /**
     * return the msg only
     * 
     * @return     message
     */
    public String printMessage() {
        return msg;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @return     greeting + message
     */
    public String salutationMessage()
    {
        // put your code here
        return "Hi! " + msg;
    }
}
