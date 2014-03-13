package ag.twittersimulation.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import ag.twittersimulation.tweet.Tweet;
import ag.twittersimulation.user.User;

public interface IOutputTweets {
	public void OutputTweets(TreeMap<String, User> users, HashMap<User, ArrayList<Tweet>> tweets);
	
}
