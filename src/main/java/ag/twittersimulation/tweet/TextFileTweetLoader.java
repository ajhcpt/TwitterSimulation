package ag.twittersimulation.tweet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import ag.twittersimulation.user.User;

public class TextFileTweetLoader extends TweetLoader {
	BufferedReader reader;
	
	public TextFileTweetLoader(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public HashMap<User, ArrayList<Tweet>> LoadTweets(TreeMap<String, User> users) throws IOException {
		HashMap<User, ArrayList<Tweet>> tweets = new HashMap<User, ArrayList<Tweet>>();
		
		String lineFromTweetFile = null;
		while ((lineFromTweetFile = reader.readLine()) != null) {
			//This functionality is commom between both readers/loaders. should be moved to one location in the parent class
			String username = GetUsername(lineFromTweetFile);
			String usersTweet = GetTweet(lineFromTweetFile);
			
			if (users.get(username) == null) {
				User newUser = new User(username);
				tweets = AddTweet(tweets, newUser, new Tweet(usersTweet));
			} else {
				tweets = AddTweet(tweets, users.get(username), new Tweet(usersTweet));
			}
		}
		return tweets;		
	}
}
