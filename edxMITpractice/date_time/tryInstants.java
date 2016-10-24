package date_time;

import java.time.Instant;
import java.util.Arrays;

/**
 * Write a description of class tryInstants here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tryInstants
{
    public static void main(String[] argv)
    {
        Instant now = Instant.now();
        Instant now2 = Instant.now();
        System.out.println("now.equals(now2): " + now.equals(now2));
        Instant past = now.minusSeconds(46416448);
        Instant future = now.plusSeconds(16546464);
        System.out.println("Past: " + past);
        System.out.println("Now: " + now);
        System.out.println("Future: " + future);
        
        Instant[] moments = {now,future,past};
        System.out.println("Moments: ");
        for(Instant aMoment: moments)
            System.out.println("\t" + aMoment);
        Arrays.sort(moments);
        System.out.println("sorted moments: ");
        for(Instant aMoment: moments)
            System.out.println("\t" + aMoment);
            
        System.out.println("past.compareTo(now): " + past.compareTo(now));
        System.out.println("future.compareTo(now): " + future.compareTo(now));
        System.out.println("now.compareTo(now2): " + now.compareTo(now2));
    }
}
