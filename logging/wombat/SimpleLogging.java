package wombat;

import java.util.logging.*;

public class SimpleLogging{
    // Obtain a suitable logger.
    private static Logger logger = Logger.getLogger("wombat.SimpleLogging");
    public static void main(String[] argv) {
        logger.setLevel(Level.ALL);
        // Log a FINE tracing message
        logger.fine("doing stuff");
        try{
            Wombat.sneeze();
        } catch (Exception ex) {
            // Log the exception
            logger.log(Level.WARNING, "trouble sneezing", ex);
        }
        logger.fine("done");
    }
}