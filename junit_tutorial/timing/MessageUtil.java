package timing;

/**
* This class prints the given message on console.
*/
public class MessageUtil {

   private String message;

   /** Constructor
    *  @param message to be printed
    */
   public MessageUtil(String message){
      this.message = message; 
   }

   /**
    *  prints the message
    */
   public void printMessage() throws InterruptedException {
      System.out.println(message);
      Thread.sleep(1001);
   }   

   /**
    *  add "Hi!" to the message
    *  @return message
    */
   public String salutationMessage(){
      message = "Hi!" + message;
      System.out.println(message);
      return message;
   }   
}