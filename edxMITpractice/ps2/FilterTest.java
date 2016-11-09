package ps2;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FilterTest {

    /*
     * writtenBy Tests
     * 1. Assume that list is never empty (test in MyFilterTest
     * 2. Assume that user is never zero length string (test in MyFilterTest)
     * 3. If one tweet is in the list, that one item is returned if username matches
     * 4. test with uppercase, mix case
     *    a. as "username"
     *    b. as "author" in tweet
     * 5. If no match, empty list is returned.
     * 6. Check if one item is matched
     * 7. Check if multiple items are matched.
     * 8. Check with username which is a substring of a user string
     *    a. beginning of string
     *    b. middle of string
     *    c. end of string
     * 9. Check with author which is a substring of a username
     *    a.-c. same as above
     * 
     * inTimespan
     * 1. Assume neither list is empty (test in MyFilterTest
     * 2. try zero match
     *    a. above range
     *    b. below range
     * 3. try one match
     *    a. one of one (skipped)
     *    b. one of multi
     * 4. try multiple matches
     *    a. all of multi
     *    b. some of multi
     * 5. try matches on the edges of the timespan (included in multi-multi)
     * 6. try matches in the middle of the timespan
     * 7. try matches only minimum time outside the timespan (how much is minimum?)
     * 8. test for correct order (included in 4)
     * 
     * containing
     * 0. Wordiness of Strings is not checked)
     * 1. Assume list is not empty (test in MyFilterTest
     * 2. Assume word is not zero length (test in MyFilterTest
     * 3. Assume that each word is longer than zero (test in MyFilterTest
     * 4. Check when none matches
     * 5. try one match
     * 6. try multi matches
     * 7. test case insensivity
     * 8. test that full word matches only
     * 9. test when match is at front of the string
     * 10. test when match is at the back of the string
     * 11. test when match is somewhere in the middle of the string
     * 12. test when only one word matches
     * 13. test when multiple words match
     * 14. Question: what about words in quotes or followed by punctuation?
     * TODO: mask regex metacharacters
     */
    
    private static final Instant d0 = Instant.parse("2016-02-17T09:59:00Z");
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    private static final Instant d3 = Instant.parse("2016-02-17T11:00:20Z");
    private static final Instant d4 = Instant.parse("2016-02-17T11:00:30Z");
    private static final Instant d5 = Instant.parse("2016-02-17T11:00:40Z");
    private static final Instant d6 = Instant.parse("2016-02-17T11:00:45Z");
    
    private static final Tweet tweet0 = new Tweet(0, "aLysSa", "it reasonable to talk about @rivest a lot", d1);
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest so much?", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype", d2);
    private static final Tweet tweet3 = new Tweet(3, "alyssa", "Is @Abe around?", d3);
    private static final Tweet tweet4 = new Tweet(4, "alys", "Is @any around?", d4);
    private static final Tweet tweet5 = new Tweet(5, "diddle", "Is @bbit around?", d5);
    private static final Tweet tweet6 = new Tweet(6, "diddl", "Is @any around?", d6);
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testWrittenByEmptyTweets() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(), "alyssa");
        
        assertEquals("expected zero length list",0,writtenBy.size());
    }
    
    @Test
    public void testWrittenBySingleTweetSingleResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1), "alyssa");
        
        assertEquals("expected singleton list", 1, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet1));
    }
    
    @Test
    public void testWrittenByMultipleTweetsAuthorSubstringFrontZeroResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1, tweet2), "a");
        
        assertEquals("expected singleton list", 0, writtenBy.size());
    }
    
    @Test
    public void testWrittenByMultipleTweetsSingleResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1, tweet2), "alyssa");
        
        assertEquals("expected singleton list", 1, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet1));
    }

    @Test
    public void testWrittenByMultipleTweetsAuthorSubtringFrontSingleResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1, tweet4), "alys");
        
        assertEquals("expected singleton list", 1, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet4));
    }

    @Test
    public void testWrittenByMultipleTweetsAuthorSubtringMidSingleResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet2, tweet6), "diddl");
        
        assertEquals("expected singleton list", 1, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet6));
    }
    
    @Test
    public void testWrittenByMultipleTweetsAuthorSubtringEndSingleResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet2, tweet5), "diddle");
        
        assertEquals("expected singleton list", 1, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet5));
    }

    
    @Test
    public void testWrittenByMultipleTweetsMultipleResults() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1, tweet3), "alyssa");
        
        assertEquals("expected singleton list", 2, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet1));
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet3));
    }

    @Test
    public void testWrittenByMultipleTweetsMixedCaseUsername() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1, tweet2), "AlySsA");
        
        assertEquals("expected singleton list", 1, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet1));
    }

    @Test
    public void testWrittenByMultipleTweetsMixedCaseTweetAuthor() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet0, tweet2), "alyssa");
        
        assertEquals("expected singleton list", 1, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet0));
    }

    @Test
    public void testWrittenByMultipleTweetsAuthorSubstringEndZeroResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1, tweet2), "lysa");
        
        assertEquals("expected singleton list", 0, writtenBy.size());
    }

    @Test
    public void testWrittenByMultipleTweetsAuthorSubstringMiddleZeroResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1, tweet2), "lys");
        
        assertEquals("expected singleton list", 0, writtenBy.size());
    }

    @Test
    public void testInTimespanMultipleTweetsZeroResultAboveRange() {
        Instant testStart = Instant.parse("2016-02-17T09:00:00Z");
        Instant testEnd = Instant.parse("2016-02-17T09:59:59Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2), new Timespan(testStart, testEnd));
        
        assertTrue("expected non-empty list", inTimespan.isEmpty());
    }

    @Test
    public void testInTimespanMultipleTweetsZeroResultBelowRange() {
        Instant testStart = Instant.parse("2016-02-17T11:00:01Z");
        Instant testEnd = Instant.parse("2016-02-17T12:59:59Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2), new Timespan(testStart, testEnd));
        
        assertTrue("expected non-empty list", inTimespan.isEmpty());
    }
    
    @Test
    public void testInTimespanMultipleTweetsZeroResultBelowRangeMinimumDiff() {
        Instant testStart = Instant.parse("2016-02-17T11:00:01Z");
        Instant testEnd = Instant.parse("2016-02-17T12:59:59.999999999Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2), new Timespan(testStart, testEnd));
        
        assertTrue("expected non-empty list", inTimespan.isEmpty());
    }

    
    @Test
    public void testInTimespanMultipleTweetsSingleResultMiddle() {
        Instant testStart = Instant.parse("2016-02-17T10:59:00Z");
        Instant testEnd = Instant.parse("2016-02-17T11:00:10Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2, tweet3), new Timespan(testStart, testEnd));
        
        assertFalse("expected non-empty list", inTimespan.isEmpty());
        assertTrue("expected list to contain tweets", inTimespan.containsAll(Arrays.asList(tweet2)));
    }

    @Test
    public void testInTimespanMultipleTweetsSingleResultFirst() {
        Instant testStart = Instant.parse("2016-02-17T09:59:00Z");
        Instant testEnd = Instant.parse("2016-02-17T10:00:10Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2, tweet3), new Timespan(testStart, testEnd));
        
        assertFalse("expected non-empty list", inTimespan.isEmpty());
        assertTrue("expected list to contain tweets", inTimespan.containsAll(Arrays.asList(tweet1)));
    }

    @Test
    public void testInTimespanMultipleTweetsSingleResultLast() {
        Instant testStart = Instant.parse("2016-02-17T11:00:10Z");
        Instant testEnd = Instant.parse("2016-02-17T11:00:20Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2, tweet3), new Timespan(testStart, testEnd));
        
        assertFalse("expected non-empty list", inTimespan.isEmpty());
        assertTrue("expected list to contain tweets", inTimespan.containsAll(Arrays.asList(tweet3)));
    }

    
    @Test
    public void testInTimespanMultipleTweetsMultipleResultsAll() {
        Instant testStart = Instant.parse("2016-02-17T09:00:00Z");
        Instant testEnd = Instant.parse("2016-02-17T12:00:00Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2), new Timespan(testStart, testEnd));
        
        assertFalse("expected non-empty list", inTimespan.isEmpty());
        assertTrue("expected list to contain tweets", inTimespan.containsAll(Arrays.asList(tweet1, tweet2)));
        assertEquals("expected same order", 0, inTimespan.indexOf(tweet1));
        assertEquals("expected same order", 1, inTimespan.indexOf(tweet2));
    }

    @Test
    public void testInTimespanMultipleTweetsMultipleResultsSome() {
        Instant testStart = Instant.parse("2016-02-17T09:00:00Z");
        Instant testEnd = Instant.parse("2016-02-17T11:00:10Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet3, tweet2, tweet1), new Timespan(testStart, testEnd));
        
        assertFalse("expected non-empty list", inTimespan.isEmpty());
        assertTrue("expected list to contain tweets", inTimespan.containsAll(Arrays.asList(tweet2, tweet1)));
        assertEquals("expected same order", 0, inTimespan.indexOf(tweet2));
        assertEquals("expected same order", 1, inTimespan.indexOf(tweet1));
    }
    
    @Test
    public void testInTimespanMultipleTweetsMultipleResultsBorders() {
        Instant testStart = Instant.parse("2016-02-17T10:00:00Z");
        Instant testEnd = Instant.parse("2016-02-17T11:00:00Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2), new Timespan(testStart, testEnd));
        
        assertFalse("expected non-empty list", inTimespan.isEmpty());
        assertTrue("expected list to contain tweets", inTimespan.containsAll(Arrays.asList(tweet1, tweet2)));
        assertEquals("expected same order", 0, inTimespan.indexOf(tweet1));
        assertEquals("expected same order", 1, inTimespan.indexOf(tweet2));
    }
    
    @Test
    public void testContainingSingleMatchFront() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("is"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertTrue("expected list to contain tweets", containing.containsAll(Arrays.asList(tweet1)));
    }
    
    @Test
    public void testContainingSingleMatchMiddle() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("talk"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertTrue("expected list to contain tweets", containing.containsAll(Arrays.asList(tweet1, tweet2)));
        assertEquals("expected same order", 0, containing.indexOf(tweet1));
    }

    @Test
    public void testContainingSingleMatchEnd0() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet0, tweet1, tweet2), Arrays.asList("lot"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertTrue("expected list to contain tweets", containing.containsAll(Arrays.asList(tweet0)));
    }

    // Non-working test case
    @Test
    public void testContainingSingleMatchEnd1() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("much\\?"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertTrue("expected list to contain tweets", containing.containsAll(Arrays.asList(tweet1)));
    }
    
    @Test
    public void testContainingSingleMatchUsernameRef() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet4), Arrays.asList("@any"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertTrue("expected list to contain tweets", containing.containsAll(Arrays.asList(tweet4)));
    }
    
    @Test
    public void testContainingSingleMatchCaseInsensitive() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("taLK"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertTrue("expected list to contain tweets", containing.containsAll(Arrays.asList(tweet1, tweet2)));
        assertEquals("expected same order", 0, containing.indexOf(tweet1));
    }
    
    @Test
    public void testContainingBothMatchOnlyInOne() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("talk","much"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertEquals("expected to get back only one match:",1,containing.size());
        assertTrue("expected list to contain first tweet", containing.containsAll(Arrays.asList(tweet1)));
    }

    @Test
    public void testContainingBothMatchOnlyInBoth() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet0, tweet1), Arrays.asList("talk","reasonable"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertEquals("expected to get back both tweets:",2,containing.size());
        assertTrue("expected list to contain tweets in order", containing.containsAll(Arrays.asList(tweet0,tweet1)));
    }
    
    @Test
    public void testContainingNoMatch() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("saint"));
        
        assertTrue("expected non-empty list", containing.isEmpty());
    }

    @Test
    public void testContainingNoMatchSubstringFront() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("reason"));
        
        assertTrue("expected non-empty list", containing.isEmpty());
    }

    @Test
    public void testContainingNoMatchSubstringEnd() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("able"));
        
        assertTrue("expected non-empty list", containing.isEmpty());
    }

    @Test
    public void testContainingNoMatchSubstringMiddle() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2), Arrays.asList("v"));
        
        assertTrue("expected non-empty list", containing.isEmpty());
    }

    
    /*
     * Warning: all the tests you write here must be runnable against any Filter
     * class that follows the spec. It will be run against several staff
     * implementations of Filter, which will be done by overwriting
     * (temporarily) your version of Filter with the staff's version.
     * DO NOT strengthen the spec of Filter or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in Filter, because that means you're testing a stronger
     * spec than Filter says. If you need such helper methods, define them in a
     * different class. If you only need them in this test class, then keep them
     * in this test class.
     */
}
