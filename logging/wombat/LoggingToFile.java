package wombat;

import java.util.logging.*;

public class LoggingToFile{
    private static Logger logger = Logger.getLogger("wombat.LoggingToFile");
    private static FileHandler fh;
    public static void main(String argv[]) throws java.io.IOException {
        fh = new FileHandler("myLog.xml");       
        // Send logger output to our FileHandler.
        logger.addHandler(fh);
        // Request that every detail gets logged.
        logger.setLevel(Level.ALL);
        // Log a simple INFO message.
        logger.info("doing stuff");
        try {
            Wombat.sneeze();
        } catch (Exception ex) {
            logger.log(Level.WARNING, "trouble sneezing", ex);
        }
        logger.fine("done");
    }
}