package ag.twittersimulation.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import ag.twittersimulation.tweet.Tweet;
import ag.twittersimulation.user.User;

public interface IOutputTweets {
	TreeMap<User, List<Tweet>> FormatTweetOutput(HashMap<String, User> users, HashMap<User, List<Tweet>> tweets);
	public void OutputTweets(HashMap<String, User> users, HashMap<User, List<Tweet>> tweets);
	
}
