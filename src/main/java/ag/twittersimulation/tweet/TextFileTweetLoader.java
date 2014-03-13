package ag.twittersimulation.tweet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import ag.twittersimulation.user.User;

public class TextFileTweetLoader extends TweetLoader {
	BufferedReader reader;
	
	public TextFileTweetLoader(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public HashMap<User, ArrayList<String>> LoadTweets(HashMap<String, User> users) throws IOException {
		HashMap<User, ArrayList<String>> tweets = new HashMap<User, ArrayList<String>>();
		
		String lineFromTweetFile = null;
		while ((lineFromTweetFile = reader.readLine()) != null) {
			//This functionality is commom between both readers/loaders. should be moved to one location in the parent class
			String username = GetUsername(lineFromTweetFile);
			String usersTweet = GetTweet(lineFromTweetFile);
			
			if (users.get(username) == null) {
				User newUser = new User(username);
				tweets = AddTweet(tweets, newUser, usersTweet);
			} else {
				tweets = AddTweet(tweets, users.get(username), usersTweet);
			}
		}
		return tweets;		
	}



}
