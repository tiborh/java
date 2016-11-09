package ps2;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
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
     * 1. No @ in the text (tweet1) (no find)
     * 2. @ in the text but 
     *    a. preceded by other character (tweet0) (no find)
     *    b. stands alone (tweet 10) (no find)
     *    c. is followed by an illegal character (tweet16) (no find)
     * 3. @username at the beginning of the string (tweet12)
     * 4. @username somewhere inside the string (tweet17)
     * 5. @username at the end of the string (tweet14)
     * 6. @username in the text followed by other character (e.g. @username's) (tweet11) (find only username)
     * 7. @username in the text with capitalisation: e.g. @Username or @uSerName (alfTweets) (find one only)
     * 8. @username mentioned several times (find one only)
     *    a. in one tweet (tweet15)
     *    b. in various tweets (alfTweets)
     * 9. several usernames in the text (tweet11, mentionsTweets) (find all of them)
     * 10. users from a list of tweets extracted correctly. (mentionsTweets)
     * 11. it should not cause a problem if a tweet is repeated
     *      (Tested in MyExtractTest, because against pre-conditions: same ID)
     * 12. it must be tested that the implementation is case insensitive 
     *     (when converting all elements to lower, the set size should be the same)
     */
    
    private static final Instant d0 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:01Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    private static final Instant d3 = Instant.now();
    private static final Instant d4 = Instant.parse("2100-01-01T00:00:00Z");
    private static final Instant d5 = Instant.parse("2100-01-01T00:00:10Z");
    private static final Instant d6 = Instant.parse("2016-03-31T12:33:15Z");
    private static final Instant d7 = Instant.parse("2015-10-01T00:00:59Z");
   
    private static final Tweet tweet0 = new Tweet(0, "alvin", "let's talk about n8ure or work@home.", d0);
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is't reasonable 2 talk about rivest so much?", d1);
    private static final Tweet tweet2 = new Tweet(2, "bitdiddle", "rivest talk in 30 minutes #hype", d2);
    private static final Tweet tweet3 = new Tweet(3, "alyssa", "i'll quit", d3);
    private static final Tweet tweet4 = new Tweet(4, "alvin", "anyone around?", d4);
    
    private static final Tweet tweet10 = new Tweet(10, "alvin", "let's talk about n8ure or work @ home.", d0);
    private static final Tweet tweet11 = new Tweet(11, "alyssa", 
        "is't reasonable 2 talk about @rivest's big mouth so much, @bitdiddle?", d1);
    private static final Tweet tweet12 = new Tweet(12, "bitdiddle", "@rivest talk in 30 minutes #hype", d2);
    private static final Tweet tweet13 = new Tweet(13, "alyssa", "i'll quit talking about @AlF", d3);
    private static final Tweet tweet14 = new Tweet(14, "alvin", "anyone around? @alf", d4);
    private static final Tweet tweet15b = new Tweet(15, "ava", "@Alf speaking about @ALF. anyone for @aLf?", d5);
    private static final Tweet tweet15a = new Tweet(15, "alf", "@Alf speaking about @ALF. anyone for @aLf?", d5);
    private static final Tweet tweet15 = new Tweet(15, "alf", "@Alf speaking. anyone for @aLf, @Eve?", d5);
    private static final Tweet tweet16 = new Tweet(16, "eve", "Did you mention @' or something else?", d6);
    private static final Tweet tweet17 = new Tweet(17, "alyssa", 
        "Thinkng about @bitdiddle whom I have not seen for a while.", d7);
    
    private static final List<Tweet> allTweets = Arrays.asList(tweet4,tweet1,tweet3,tweet2,tweet0);
    private static final List<Tweet> alfTweets = Arrays.asList(tweet14,tweet15a);
    private static final List<Tweet> mentionsTweets = Arrays.asList(tweet11,tweet12, tweet15);
    
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
    public void testGetMentionedUsersNoMention0() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet1));
        
        assertTrue("expected empty set, but returned: " + mentionedUsers, mentionedUsers.isEmpty());
    }
    
    @Test
    public void testGetMentionedUsersNoMention1() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet0));
        
        assertTrue("expected empty set, but returned: " + mentionedUsers, mentionedUsers.isEmpty());
    }

    @Test
    public void testGetMentionedUsersNoMention2() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet10));
        
        assertTrue("expected empty set, but returned: " + mentionedUsers, mentionedUsers.isEmpty());
    }
    
    @Test
    public void testGetMentionedUsersNoMention3() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet16));
        
        assertTrue("expected empty set, but returned: " + mentionedUsers, mentionedUsers.isEmpty());
    }

    @Test
    public void testGetMentionedUsersOneMentionMixedCase() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet15b));
        Set<String> result = new HashSet<String>();
        result.add("alf");
        
        Set<String> mentionedUsersLower = new HashSet<String>();
        
        for (String aMention : mentionedUsers)
            mentionedUsersLower.add(aMention.toLowerCase());
        
        assertEquals(mentionedUsers.size(),mentionedUsersLower.size());
        assertTrue("expected " + result + " but received " + 
            mentionedUsersLower, Arrays.equals(result.toArray(), mentionedUsersLower.toArray()));
    }
    
    @Test
    public void testGetMentionedUsersOneMatch0() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet12));
        Set<String> result = new HashSet<String>();
        result.add("rivest");
        
        Set<String> mentionedUsersLower = new HashSet<String>();
        
        for (String aMention : mentionedUsers)
            mentionedUsersLower.add(aMention.toLowerCase());
        
        assertEquals(mentionedUsers.size(),mentionedUsersLower.size());
        assertTrue("expected " + result + " but received " + 
            mentionedUsersLower, Arrays.equals(result.toArray(), mentionedUsersLower.toArray()));
    }
        
    @Test
    public void testGetMentionedUsersOneMatch1() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet17));
        Set<String> result = new HashSet<String>();
        result.add("bitdiddle");
        
        Set<String> mentionedUsersLower = new HashSet<String>();
        
        for (String aMention : mentionedUsers)
            mentionedUsersLower.add(aMention.toLowerCase());
        
        assertEquals(mentionedUsers.size(),mentionedUsersLower.size());
        assertTrue("expected " + result + " but received " + 
            mentionedUsersLower, Arrays.equals(result.toArray(), mentionedUsersLower.toArray()));
    }
    
    @Test
    public void testGetMentionedUsersOneMatch2() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet14));
        Set<String> result = new HashSet<String>();
        result.add("alf");
        
        Set<String> mentionedUsersLower = new HashSet<String>();
        
        for (String aMention : mentionedUsers)
            mentionedUsersLower.add(aMention.toLowerCase());
        
        assertEquals(mentionedUsers.size(),mentionedUsersLower.size());
        assertTrue("expected " + result + " but received " + 
            mentionedUsersLower, Arrays.equals(result.toArray(), mentionedUsersLower.toArray()));
    }

    @Test
    public void testGetMentionedUsersOneMatch3() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(alfTweets);
        Set<String> result = new HashSet<String>();
        result.add("alf");
        
        Set<String> mentionedUsersLower = new HashSet<String>();
        
        for (String aMention : mentionedUsers)
            mentionedUsersLower.add(aMention.toLowerCase());
        
        assertEquals(mentionedUsers.size(),mentionedUsersLower.size());
        assertTrue("expected " + result + " but received " + 
            mentionedUsersLower, Arrays.equals(result.toArray(), mentionedUsersLower.toArray()));
    }
    
    @Test
    public void testGetMentionedUsersMultipleMatches1() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet11));
        Set<String> result = new HashSet<String>();
        result.add("rivest");
        result.add("bitdiddle");
        Object[] resultArr = result.toArray();
        Arrays.sort(resultArr);
        
        Set<String> mentionedUsersLower = new HashSet<String>();
        
        for (String aMention : mentionedUsers) {
            mentionedUsersLower.add(aMention.toLowerCase());
        }
        
        Object[] mentUsersArr = mentionedUsersLower.toArray();
        Arrays.sort(mentUsersArr);
        
        assertEquals(mentionedUsers.size(),mentionedUsersLower.size());
        assertTrue("expected " + result + " but received " + mentionedUsers, Arrays.equals(resultArr, mentUsersArr));
    }
    
    @Test
    public void testGetAuthorsMultipleMatches0() {
        Set<String> theAuthors = Extract.getAuthors(allTweets);
        Set<String> result = new HashSet<String>();
        result.add("alvin");
        result.add("alyssa");
        result.add("bitdiddle");
        Object[] resultArr = result.toArray();
        Arrays.sort(resultArr);
        Object[] authorsArr = theAuthors.toArray();
        Arrays.sort(authorsArr);
        
        assertTrue("expected " + result + " but received " + theAuthors, Arrays.equals(resultArr, authorsArr));
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