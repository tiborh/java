package ps2;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.Instant;
import java.util.Arrays;

/**
 * The test class MyExtractTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MyExtractTest
{
    private static Instant d1;
    private static Tweet tweet1;
    
    /**
     * Default constructor for test class MyExtractTest
     */
    public MyExtractTest()
    {
    }

    @BeforeClass
    public static void beforeClass() {
        d1 = Instant.parse("2016-02-17T10:00:01Z");
        tweet1 = new Tweet(1, "alyssa", "is't reasonable 2 talk about rivest so much?", d1);
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test(expected=AssertionError.class)
    public void testGetTimespanZeroTweet()
    {
        Timespan timespan = Extract.getTimespan(Arrays.asList());               
    }
    
    @Test
    public void testGetTimespanDoubleTweet() {
        Timespan timespan = Extract.getTimespan(Arrays.asList(tweet1, tweet1));
        
        assertEquals("expected start", d1, timespan.getStart());
        assertEquals("expected end", d1, timespan.getEnd());
    }

    
    @Test(expected=AssertionError.class)
    public void testGetMentionedUsersZeroTweet()
    {
        Timespan timespan = Extract.getTimespan(Arrays.asList());               
    }
}
