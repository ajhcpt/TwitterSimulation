package ag.twittersimulation.interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import ag.twittersimulation.user.User;

public abstract class TweetLoader {
	public abstract HashMap<User, ArrayList<String>> LoadTweets(HashMap<String, User> users) throws IOException;
	
	protected static String GetUsername(String tweet) {
		int usernameEnds = tweet.indexOf(">");
		String username = tweet.substring(0, usernameEnds);
		return username;
	}
	
	protected static String GetTweet(String tweet) {
		int usernameEnds = tweet.indexOf(">");
		String usersTweet = tweet.substring(usernameEnds + 2);
		return usersTweet;
	}
	
	protected static User GetUser(String userName, HashMap<String, User> users) {
		User user = users.get(userName);
		return user;
	}
	
	protected static HashMap<User, ArrayList<String>> AddTweet(HashMap<User, ArrayList<String>> tweets, User user, String usersTweet) {
		HashMap<User, ArrayList<String>> tempTweets = tweets;
		ArrayList<String> existingTweets = new ArrayList<String>();
		if (tempTweets.get(user) == null) {
			existingTweets.add(usersTweet);
		} else {
			existingTweets = tempTweets.get(user);
			existingTweets.add(usersTweet);
		}
		tempTweets.put(user, existingTweets);		
		
		return tempTweets;
	}
	
}
