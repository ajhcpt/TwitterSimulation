package ag.twittersimulation.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import ag.twittersimulation.user.User;

public interface IOutputTweets {
	TreeMap<User, ArrayList<String>> FormatTweetOutput(HashMap<String, User> users, HashMap<User, ArrayList<String>> tweets);
	public void OutputTweets(HashMap<String, User> users, HashMap<User, ArrayList<String>> tweets);
	
}
