package date_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * provides a timestamp that can be suffixed to base filename before file extension
 * 
 * @author tibor
 * @version 0.01
 */
public class TimeStamp
{
    private final String timestamp;

    /**
     * giving value to timestamp
     */
    public TimeStamp()
    {
        LocalDateTime now = LocalDateTime.now();
        timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_kkmmss"));
    }

    public String getTimeStamp() { return timestamp; }
    public String toString() { return timestamp; }
    
    public static void main(String[] argv)
    {
        TimeStamp ts = new TimeStamp();
        System.out.println("The time stamp: " + ts);
    }
}
