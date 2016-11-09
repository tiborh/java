package ps2;


import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.time.Instant;


public class SocialNetworkTest {

    private static final Instant d0 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:01Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    private static final Instant d3 = Instant.now();
    private static final Instant d4 = Instant.parse("2100-01-01T00:00:00Z");
    private static final Instant d5 = Instant.parse("2100-01-01T00:00:10Z");
    private static final Instant d6 = Instant.parse("2016-03-31T12:33:15Z");
    private static final Instant d7 = Instant.parse("2015-10-01T00:00:59Z");
    
    private static final Tweet tweet0 = new Tweet(0, "alvin", 
        "let's talk about n8ure or work@home.", d0);
    private static final Tweet tweet1 = new Tweet(1, "alyssa", 
        "is't reasonable 2 talk about rivest so much?", d1);
    private static final Tweet tweet2 = new Tweet(2, "bitdiddle", 
        "rivest talk in 30 minutes #hype", d2);
    private static final Tweet tweet3 = new Tweet(3, "alyssa", "i'll quit", d3);
    private static final Tweet tweet4 = new Tweet(4, "alvin", "anyone around?", d4);
    
    private static final Tweet tweet15 = new Tweet(15, "alf", "@Alf speaking. anyone for @aLf, @Eve? @Alyssa?", d5);
    
    private static final Tweet tweet5 = new Tweet(5, "alf", "@alyssa @Alyssa", d5);
    private static final Tweet tweet6 = new Tweet(6, "eve", "@alyssa @aLySsA", d6);
    private static final Tweet tweet7 = new Tweet(7, "alyssa", "@eve @eVe", d7);
    
    private static final List<Tweet> allNoMentionTweets = Arrays.asList(tweet4,tweet1,tweet3,tweet2,tweet0);
    private static final List<Tweet> mentionsToSort = Arrays.asList(tweet5,tweet6,tweet7);
    
    /*
     * guessFollowsGrap
     * 1. Check for empty list (returns empty Map)
     * 2. Check for non-empty list, but no mentions (returns Map with empty hash(es))
     * 3. Check for non-empty list with multiple finds
     * 4. Check that an author is not followed by himself (included in above)
     * 
     * influencers
     * 1. test empty
     * 2. test when all is zero
     * 3. test equality
     * 4. test different ones
     * 5. test case insensitivity
     * 6. test if all equal rank is returned
     */
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testGuessFollowsGraphEmpty() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(new ArrayList<>());
                
        assertTrue("expected empty graph", followsGraph.isEmpty());
    }
    
    @Test
    public void testGuessFollowsGraphNoFollow() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(allNoMentionTweets);
        Map<String, Set<String>> lowerFollowsGraph = new HashMap<String, Set<String>>();
        
        for (String aName : followsGraph.keySet()) {
            String lowerName = aName.toLowerCase();
            
            Set<String> lowerFollowers = new HashSet<String>();
            for (String aFollower : followsGraph.get(aName))
                lowerFollowers.add(aFollower.toLowerCase());
                
            lowerFollowsGraph.put(lowerName, lowerFollowers);
        }
        
        Set<String> result = new HashSet<String>();
        String[] names = {"alvin","alyssa","bitdiddle"};
        for (String aName : names) {
            result.add(aName);
        }
        Object[] resultArr = result.toArray();
        Arrays.sort(resultArr);
        Object[] followsGraphKeysArr = lowerFollowsGraph.keySet().toArray();
        Arrays.sort(followsGraphKeysArr);
        
        //System.out.println("received" + followsGraph);
        //System.out.println("received" + lowerFollowsGraph);
        assertFalse("expected non-empty graph", followsGraph.isEmpty());
        assertEquals("expected 3-member Set",3,followsGraph.size());
        assertTrue("expected keys" + resultArr + " but received " + followsGraphKeysArr, Arrays.equals(resultArr, followsGraphKeysArr));
        for (String aName : names) {
            assertTrue("Value is expected to be empty set to " + aName, lowerFollowsGraph.get(aName).isEmpty());
        }
    }

    @Test
    public void testGuessFollowsGraphMultiFollow() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet15,tweet5));
        Map<String, Set<String>> lowerFollowsGraph = new HashMap<String, Set<String>>();
        
        for (String aName : followsGraph.keySet()) {
            String lowerName = aName.toLowerCase();
            
            Set<String> lowerFollowers = new HashSet<String>();
            for (String aFollower : followsGraph.get(aName))
                lowerFollowers.add(aFollower.toLowerCase());
                
            lowerFollowsGraph.put(lowerName, lowerFollowers);
        }
        
        Set<String> followed = new HashSet<String>();
        followed.add("alyssa");
        followed.add("eve");
        
        String[] followedArr = followed.toArray(new String[followed.size()]);
        //System.out.println("length of followedArr: " + followedArr.length);        
        Arrays.sort(followedArr);
        //System.out.println("length of followedArr: " + followedArr.length);

        Set<String> alfFollows = lowerFollowsGraph.get("alf");
        //System.out.println("size of alfFollows: " + lowerFollowsGraph.size());
        String[] alfFollowsArr = alfFollows.toArray(new String[alfFollows.size()]);
        //System.out.println("size of lowerFollowsGraph: " + lowerFollowsGraph.size());
        
        assertEquals("expected equal size sets: expected: " + followed + " but received " + alfFollows,followed.size(),alfFollows.size());
        assertEquals("expected equal length arrays expected",followedArr.length,alfFollowsArr.length);
        Arrays.sort(alfFollowsArr);
        
        assertFalse("expected non-empty graph", lowerFollowsGraph.isEmpty());
        //assertEquals("expected 1-member Set",3,lowerFollowsGraph.size());
        assertNotNull("expected non-empty hash as value",lowerFollowsGraph.get("alf"));
        assertTrue("Values are expected to be" + followed + " but turned out to be " + lowerFollowsGraph.keySet(), Arrays.equals(followedArr, alfFollowsArr));
    }
    
    @Test
    public void testInfluencersEmpty() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        
        assertTrue("expected empty list", influencers.isEmpty());
    }

    @Test
    public void testInfluencersToSort1() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(mentionsToSort);
        List<String> theInfluencers = SocialNetwork.influencers(followsGraph);
        List<String> compareList = new ArrayList<String>();
        compareList.add(0, "alyssa");
        compareList.add(1, "eve");
        compareList.add(2, "alf");
        
        assertEquals("List size expected: " + compareList.size() + " but received " + theInfluencers.size(), compareList.size(), theInfluencers.size());
        assertFalse("expected non-empty list", theInfluencers.isEmpty());
        assertTrue("expected three member list", theInfluencers.equals(compareList));
    }

    @Test
    public void testInfluencersToSort2() {        
        Map<String, Set<String>> followsGraph = new HashMap<String, Set<String>>();
        Set<String> set1 = new HashSet<String>();
        set1.add("alyssa");
        set1.add("Alyssa");
        followsGraph.put("Alf", set1);
        Set<String> set2 = new HashSet<String>();
        set2.add("AlYsSa");
        set2.add("ALySsA");
        followsGraph.put("Eve", set2);
        Set<String> set3 = new HashSet<String>();
        set3.add("EvE");
        set3.add("eVe");
        followsGraph.put("Alyssa", set3);
        
        //followsGraph
        List<String> theInfluencers = SocialNetwork.influencers(followsGraph);
        List<String> compareList = new ArrayList<String>();
        compareList.add(0, "alyssa");
        compareList.add(1, "eve");
        compareList.add(2, "alf");
        
        assertFalse("expected non-empty list", theInfluencers.isEmpty());
        assertEquals("List size expected: " + compareList.size() + " but received " + theInfluencers.size(), compareList.size(), theInfluencers.size());
        assertTrue("expected three member list", theInfluencers.equals(compareList));
    }

    @Test
    public void testInfluencersEqual() {        
        Map<String, Set<String>> followsGraph = new HashMap<String, Set<String>>();
        Set<String> set1 = new HashSet<String>();
        set1.add("alyssa");
        followsGraph.put("Alf", set1);
        Set<String> set2 = new HashSet<String>();
        set2.add("alf");
        followsGraph.put("Eve", set2);
        Set<String> set3 = new HashSet<String>();
        set3.add("Eve");
        followsGraph.put("Alyssa", set3);
        
        List<String> theInfluencers = SocialNetwork.influencers(followsGraph);
                
        assertFalse("expected non-empty list", theInfluencers.isEmpty());
        assertEquals("List size expected: 3 but received " + theInfluencers.size(), 3, theInfluencers.size());
    }

    
    /*
     * Warning: all the tests you write here must be runnable against any
     * SocialNetwork class that follows the spec. It will be run against several
     * staff implementations of SocialNetwork, which will be done by overwriting
     * (temporarily) your version of SocialNetwork with the staff's version.
     * DO NOT strengthen the spec of SocialNetwork or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in SocialNetwork, because that means you're testing a
     * stronger spec than SocialNetwork says. If you need such helper methods,
     * define them in a different class. If you only need them in this test
     * class, then keep them in this test class.
     */

}
