package ps2;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Filter consists of methods that filter a list of tweets for those matching a
 * condition.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Filter {

    /**
     * Find tweets written by a particular user.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param username
     *            Twitter username, required to be a valid Twitter username as
     *            defined by Tweet.getAuthor()'s spec.
     * @return all and only the tweets in the list whose author is username,
     *         in the same order as in the input list.
     */
    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {
        assert(username.length() > 0);
        ArrayList<Tweet> outList = new ArrayList<Tweet>();
        if (tweets.isEmpty())
            return outList;
        
        for (Tweet aTweet : tweets) {
            if (aTweet.getAuthor().toLowerCase().equals(username.toLowerCase()))
                outList.add(aTweet);
        }
        return(outList);
    }

    /**
     * Find tweets that were sent during a particular timespan.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param timespan
     *            timespan
     * @return all and only the tweets in the list that were sent during the timespan,
     *         in the same order as in the input list.
     */
    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
        assert(!tweets.isEmpty());        
        ArrayList<Tweet> outList = new ArrayList<Tweet>();
        
        for (Tweet aTweet : tweets) {
            if (timespan.getStart().compareTo(aTweet.getTimestamp()) <= 0 && 
                timespan.getEnd().compareTo(aTweet.getTimestamp()) >= 0)
                outList.add(aTweet);
        }
        
        return(outList);
    }

    /**
     * Find tweets that contain certain words.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param words
     *            a list of words to search for in the tweets. 
     *            A word is a nonempty sequence of nonspace characters.
     * @return all and only the tweets in the list such that the tweet text (when 
     *         represented as a sequence of nonempty words bounded by space characters 
     *         and the ends of the string) includes *at least one* of the words 
     *         found in the words list. Word comparison is not case-sensitive,
     *         so "Obama" is the same as "obama".  The returned tweets are in the
     *         same order as in the input list.
     */
    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {
        assert(!tweets.isEmpty());
        assert(!words.isEmpty());
        
        ArrayList<Tweet> outList = new ArrayList<Tweet>();
        int matchesNeeded = words.size();
        
        for (Tweet aTweet : tweets) {
            int matchCounter = 0;
            //System.out.println("in tweet: " + aTweet.getText());
            for (String aWord : words) {
                assert(aWord.length() > 0);
                aWord = aWord.toLowerCase();
                //System.out.println("Word: " + aWord);
                Pattern p0 = Pattern.compile("\\b" + aWord + "\\b");
                Matcher m0 = p0.matcher(aTweet.getText().toLowerCase());
                if (m0.find()) {
                    //System.out.println("word boundary");
                    ++matchCounter;
                    continue;
                }
                Pattern p = Pattern.compile("\\s" + aWord + "\\s");
                Matcher m = p.matcher(aTweet.getText().toLowerCase());
                if (m.find()) {
                    //System.out.println("match space bounded");
                    ++matchCounter;
                    continue;
                }
                Pattern p1 = Pattern.compile("^" + aWord + "\\b");
                Matcher m1 = p1.matcher(aTweet.getText().toLowerCase());
                if (m1.find()) {
                    //System.out.println("match front");
                    ++matchCounter;
                    continue;
                }
                Pattern p2 = Pattern.compile("\\b" + aWord + "$");
                Matcher m2 = p2.matcher(aTweet.getText().toLowerCase());
                if (m2.find()) {
                    //System.out.println("match back");
                    ++matchCounter;
                    continue;
                }                
            }
            //System.out.println("match counter " + matchCounter);
            if (matchCounter == matchesNeeded)
                outList.add(aTweet);
        }
        
        return outList;
    }

}
