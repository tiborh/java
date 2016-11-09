package ps2;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * SocialNetwork provides methods that operate on a social network.
 * 
 * A social network is represented by a Map<String, Set<String>> where map[A] is
 * the set of people that person A follows on Twitter, and all people are
 * represented by their Twitter usernames. Users can't follow themselves. If A
 * doesn't follow anybody, then map[A] may be the empty set, or A may not even exist
 * as a key in the map; this is true even if A is followed by other people in the network.
 * Twitter usernames are not case sensitive, so "ernie" is the same as "ERNie".
 * A username should appear at most once as a key in the map or in any given
 * map[A] set.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class SocialNetwork {

    /**
     * Guess who might follow whom, from evidence found in tweets.
     * 
     * @param tweets
     *            a list of tweets providing the evidence, not modified by this
     *            method.
     * @return a social network (as defined above) in which Ernie follows Bert
     *         if and only if there is evidence for it in the given list of
     *         tweets.
     *         One kind of evidence that Ernie follows Bert is if Ernie
     *         @-mentions Bert in a tweet. This must be implemented. Other kinds
     *         of evidence may be used at the implementor's discretion.
     *         All the Twitter usernames in the returned social network must be
     *         either authors or @-mentions in the list of tweets.
     */
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
        Map<String, Set<String>> outMap = new HashMap<String, Set<String>>();
        
        Set<String> theAuthors = Extract.getAuthors(tweets);
        
        for (String anAuthor : theAuthors) {
            List<Tweet> userTweets = Filter.writtenBy(tweets, anAuthor);
            Set<String> mentionedUsers = Extract.getMentionedUsers(userTweets);
            if (mentionedUsers.contains(anAuthor))
                mentionedUsers.remove(anAuthor);
            outMap.put(anAuthor, mentionedUsers);
        }
        
        return outMap;
    }
//         Map<String, Set<String>> network = new HashMap<String, Set<String>>();
//         Set<String> userFriends;
// 
//         for (Tweet t : tweets) {
//             userFriends = new HashSet<String>();
//             userFriends.addAll(getMentionedUsers_Good(Arrays.asList(t)));
//             // Can't follow yourself.
//             userFriends.remove(t.getAuthor().toLowerCase());
//             if (network.get(t.getAuthor().toLowerCase()) == null) {
//                 network.put(t.getAuthor().toLowerCase(), userFriends);
//             } else {
//                 network.get(t.getAuthor().toLowerCase()).addAll(userFriends);
//             }
//             for (String user : userFriends) {
//                 if (network.get(user) == null) {
//                     network.put(user, new HashSet<String>(Arrays.asList(t.getAuthor().toLowerCase())));
//                 } else {
//                     network.get(user).add(t.getAuthor().toLowerCase());
//                 }
//             }
//         }
//         
//         return network;
//     }
    

    /**
     * Find the people in a social network who have the greatest influence, in
     * the sense that they have the most followers.
     * 
     * @param followsGraph
     *            a social network (as defined above)
     * @return a list of all distinct Twitter usernames in followsGraph, in
     *         descending order of follower count.
     */
    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
        List<String> outList = new ArrayList<String>();

        //System.out.println("Received: " + followsGraph);

        Map<String,Integer> influencersMap = new LinkedHashMap<String,Integer>();

        Set<String> theFollowers = followsGraph.keySet();
        for (String aFollower : theFollowers) {
            Set<String> someInfluencers = followsGraph.get(aFollower);
            Set<String> someInfluencerKeys = influencersMap.keySet();
            for (String anInfluencer : someInfluencers) {
                anInfluencer = anInfluencer.toLowerCase();
                if (someInfluencerKeys.contains(anInfluencer))
                    influencersMap.put(anInfluencer, influencersMap.get(anInfluencer)-1);
                else
                    influencersMap.put(anInfluencer, -1);
            }
        }

        influencersMap = MapUtil.sortByValue( influencersMap );

        Set<String> influencerKeys = influencersMap.keySet();

        for (String anInfluencerKey : influencerKeys) {
            outList.add(anInfluencerKey);
        }

        for (String aFollower : theFollowers)
            if (!outList.contains(aFollower.toLowerCase()))
                outList.add(aFollower.toLowerCase());

        //System.out.println("Returned: " + outList);

        return outList;
    }

    private static Set<String> getMentionedUsers_Good(List<Tweet> tweets) {
        // ripped from a good version of extract
        // returns all lowercase
        Set<String> mentions = new HashSet<String>();
        for (Tweet t : tweets) {
            String text = t.getText();
            Pattern p = Pattern.compile("(^|[^A-Za-z0-9_-])@[A-Za-z0-9_-]+");
            Matcher m = p.matcher(text);
            while (m.find()) {
                mentions.add(m.group().replaceFirst("^[^A-Za-z0-9_-]+", "").toLowerCase());
            }
        }
        return mentions;
    }

}
