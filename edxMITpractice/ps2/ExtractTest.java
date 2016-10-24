package ps2;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.Set;
import java.util.List;

import org.junit.Test;

public class ExtractTest {

    /**
     * Test GetTimespan:
     * 1. The question of empty list has not been touched, so not tested. (to be handled in MyExtractTest)
     *  (There should be a prerequisite that it cannot be empty.)
     * 2 If the list is 1 item long, the same Instant should be the starting and end points.
     * 3. From two items up, the same thing should happen.
     *    a. two items can be solved with .compareTo(), so also tested
     *    b. more than two, which can only be solved differently than a simple comparison
     *    c. If two items of the same instant is entered, it should not pose a problem either. 
     *       (Tested in MyExtractTest, because against pre-conditions: same ID)
     * 
     * Test GetMentionedUsers
     * 1. No @ in the text
     * 2. @ in the text but preceded by other character
     * 3. @username in the text by followed by other character (e.g. @username's)
     * 4. @username in the text with capitalisation: e.g. @Username or @uSerName
     * 5. @username mentioned several times
     *    a. in one tweet
     *    b. in various tweets
     * 6. several usernames in the text
     * 7. it should not cause a problem if a tweet is repeated
     *    (Tested in MyExtractTest, because against pre-conditions: same ID)
     */
    
    private static final Instant d0 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:01Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    private static final Instant d3 = Instant.now();
    private static final Instant d4 = Instant.parse("2100-01-01T00:00:00Z");
    
    private static final Tweet tweet0 = new Tweet(0, "alvin", "let's talk about n8ure or work@home.", d0);
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is't reasonable 2 talk about rivest so much?", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype", d2);
    private static final Tweet tweet3 = new Tweet(3, "alyssa", "i'll quit", d3);
    private static final Tweet tweet4 = new Tweet(4, "alvin", "anyone around?", d4);
    
    private static final List<Tweet> allTweets = Arrays.asList(tweet4,tweet1,tweet3,tweet2,tweet0);
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testGetTimespanOneTweet() {
        Timespan timespan = Extract.getTimespan(Arrays.asList(tweet4));
        
        assertEquals("expected start", d4, timespan.getStart());
        assertEquals("expected end", d4, timespan.getEnd());
    }
    
    @Test
    public void testGetTimespanTwoTweets() {
        Timespan timespan = Extract.getTimespan(Arrays.asList(tweet1, tweet2));
        
        assertEquals("expected start", d1, timespan.getStart());
        assertEquals("expected end", d2, timespan.getEnd());
    }
        
    @Test
    public void testGetTimespanAllTweets() {
        Timespan timespan = Extract.getTimespan(allTweets);
        
        assertEquals("expected start", d0, timespan.getStart());
        assertEquals("expected end", d4, timespan.getEnd());
    }
    
    @Test
    public void testGetMentionedUsersNoMention() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet0));
        
        assertTrue("expected empty set", mentionedUsers.isEmpty());
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * Extract class that follows the spec. It will be run against several staff
     * implementations of Extract, which will be done by overwriting
     * (temporarily) your version of Extract with the staff's version.
     * DO NOT strengthen the spec of Extract or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in Extract, because that means you're testing a
     * stronger spec than Extract says. If you need such helper methods, define
     * them in a different class. If you only need them in this test class, then
     * keep them in this test class.
     */
}