package ps2;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class GradingUtilities {

    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     */
    
    public static Long currentID = 0L;
    
    public static Tweet createTweetWithDate(Instant d1) {
        Tweet tweet = new Tweet(currentID, "testUser", "dummyText", d1);
        currentID++;
        return tweet;
    }

    public static Tweet createTweetWithText(String text) {
        // Tweets cannot be over 140 characters in length.
        String tweetText = text;
        if (text.length() > 140) {
            tweetText = text.substring(0, 140);
        }
        Tweet tweet = new Tweet(currentID, "testUser", tweetText, Instant.now());
        currentID++;
        return tweet;
    }
    
    public static Tweet createTweetWithAuthor(String author) {
        Tweet tweet = new Tweet(currentID, author, "dummyText", Instant.now());
        currentID++;
        return tweet;
    }
    
    public static Set<String> setToLowerCase(Set<String> strings) {
        Set<String> lowerSet = new HashSet<String>();
        for (String s: strings) {
            lowerSet.add(s.toLowerCase());
        }
        return lowerSet;
    }
    
    public static boolean setIsCaseInsensitiveUnique(Set<String> strings) {
        Set<String> lowerSet = new HashSet<String>();
        for (String s: strings) {
            if (lowerSet.contains(s.toLowerCase())) {
                return false;
            }
            lowerSet.add(s.toLowerCase());
        }
        return true;
    }

}
