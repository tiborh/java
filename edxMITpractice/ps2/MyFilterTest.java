package ps2;

import static org.junit.Assert.*;
import org.junit.Test;

import java.time.Instant;
import java.util.List;
import java.util.Arrays;

public class MyFilterTest
{
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest so much?", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype", d2);   
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
//     @Test(expected=AssertionError.class)
//     public void testWrittenByZeroTweet()
//     {
//         List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(), "alyssa");
//     }
    
    @Test(expected=AssertionError.class)
    public void testWrittenByZeroLengthUsername()
    {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1, tweet2), "");                
    }

    @Test(expected=AssertionError.class)
    public void testInTimeSpanZeroTweet()
    {
        Instant testStart = Instant.parse("2016-02-17T09:00:00Z");
        Instant testEnd = Instant.parse("2016-02-17T12:00:00Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(), new Timespan(testStart, testEnd));
    }
    
    @Test(expected=AssertionError.class)
    public void testContainingZeroTweet()
    {
        List<Tweet> containing = Filter.containing(Arrays.asList(),Arrays.asList("talk"));
    }
    
    @Test(expected=AssertionError.class)
    public void testContainingZeroWords()
    {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList());
    }

    @Test(expected=AssertionError.class)
    public void testContainingZeroLengthWord()
    {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList(""));
    }

    
}
