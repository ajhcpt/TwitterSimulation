package ag.twittersimulation.tweet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import ag.twittersimulation.user.User;

public abstract class AbstractTweetLoader {
	public abstract HashMap<User, ArrayList<Tweet>> LoadTweets(TreeMap<String, User> users) throws IOException;
	
	protected static String GetUsername(String tweet) {
		int usernameEnds = tweet.indexOf(">");
		String username = tweet.substring(0, usernameEnds);
		return username;
	}
	
	protected static String GetTweet(String tweet) {
		int usernameEnds = tweet.indexOf(">");
		String usersTweet = tweet.substring(usernameEnds + 2);
		if (usersTweet.length() > 140) {
			usersTweet = usersTweet.substring(0, 140);
		}
		return usersTweet;
	}
	
	protected static User GetUser(String userName, TreeMap<String, User> users) {
		User user = users.get(userName);
		return user;
	}
	
	protected static HashMap<User, ArrayList<Tweet>> AddTweet(HashMap<User, ArrayList<Tweet>> tweets, User user, Tweet usersTweet) {
		HashMap<User, ArrayList<Tweet>> tempTweets = tweets;
		ArrayList<Tweet> existingTweets = new ArrayList<Tweet>();
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
