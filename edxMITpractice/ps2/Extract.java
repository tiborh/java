package ps2;


import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.time.Duration;
import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Extract {

    /**
     * Get the time period spanned by tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return a minimum-length time interval that contains the timestamp of
     *         every tweet in the list.
     */
    public static Timespan getTimespan(List<Tweet> tweets) {
        assert(!tweets.isEmpty());
        int listSize = tweets.size();
        if (listSize == 1)
            return(new Timespan(tweets.get(0).getTimestamp(),tweets.get(0).getTimestamp()));
        Instant[] tweetTimes = new Instant[listSize];
        for (int i = 0; i < listSize; ++i)
            tweetTimes[i]= tweets.get(i).getTimestamp();
        Arrays.sort(tweetTimes);
        return(new Timespan(tweetTimes[0],tweetTimes[listSize-1]));
    }

    /**
     * Get usernames mentioned in a list of tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return the set of usernames who are mentioned in the text of the tweets.
     *         A username-mention is "@" followed by a Twitter username (as
     *         defined by Tweet.getAuthor()'s spec).
     *         The username-mention cannot be immediately preceded or followed by any
     *         character valid in a Twitter username.
     *         For this reason, an email address like bitdiddle@mit.edu does NOT 
     *         contain a mention of the username mit.
     *         Twitter usernames are case-insensitive, and the returned set may
     *         include a username at most once.
     */
    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
        assert(!tweets.isEmpty());
        Set<String> users = new HashSet<String>();
        
        for (Tweet aTweet : tweets) {
            String tweetStr = aTweet.toString();
            Pattern p = Pattern.compile("[^\\w\\d-]@[\\w\\d-]+\\b", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(tweetStr);
            while(m.find()) {
                users.add(tweetStr.substring(m.start()+2, m.end()).toLowerCase());
            }
        }
                
        return(users);
    }
    
    /**
     * Get the authors from a list of tweets.
     * 
     * @param tweets list of Tweet messages
     * @return returns the list of authors from tweets
     */
    public static Set<String> getAuthors(List<Tweet> tweets) {
        
        Set<String> authors = new HashSet<String>();
        
        for (Tweet aTweet : tweets) {
            authors.add(aTweet.getAuthor());
        }
        
        return authors;
    }
}
