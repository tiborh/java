import se.ericsson.edt.eriuser.client.*;
import se.ericsson.edt.eriuser.core.*;
/**
 * Title:        RACFcheck
 * Description:  Authenticates a user in RACF using the EriUser service
 * Copyright:    Copyright (c) 2001
 * Company:      EPAC
 * @author QDTMAEL
 * @version 1.0
 *
 */

public class Racfcheck {

  /**
   * Default constructor for the test program.
   */
  public Racfcheck() {
  }
  /**
   * The main function for the program.
   * @param args parameter for main
   */
  public static void main(String[] args) {
    if(2==args.length) {
      try {
        String user=args[0];
        String pwd=args[1];

        if (authenticate(user, pwd)) {
          System.out.println("The authentication process was successful.");
        }
        else {
          System.out.println("The authentication process was NOT successful.");
        }
      }
      catch (Exception e) {
        System.err.println("Unexpected exception throwed!");
        e.printStackTrace();
      }
    }
    else {
      System.out.println("Usage: RACFcheck <userid> <password>");
      return;
    }
  }
  /**
   * The method authenticates the supplied user using the supplied password.
   * @param user RACF user id to authenticate
   * @param password RACF password for the user
   * @return true if the user was successfully authenticated, false otherwise.
   */
  private static boolean authenticate(String user, String password)
  {
    System.out.println("authenticate() started");
    EriuserApplicationService eas=new EriuserApplicationService();
    try {
  	eas.authenticate(user, password);
    }
    catch (EriuserException ex) {
      // throws EriuserException
      // Not a valid user
      ex.printStackTrace();
      return false;
    }
    // Valid user
    System.out.println("authenticate() ended. " + "New ticket=" + eas.getTicket());
    return true;
  }
}
