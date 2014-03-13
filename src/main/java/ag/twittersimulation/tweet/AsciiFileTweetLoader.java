package ag.twittersimulation.tweet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

import ag.twittersimulation.user.User;

public class AsciiFileTweetLoader extends TweetLoader {
BufferedReader reader;
	
	public AsciiFileTweetLoader(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public HashMap<User, ArrayList<Tweet>> LoadTweets(TreeMap<String, User> users) throws IOException {
		HashMap<User, ArrayList<Tweet>> tweets = new HashMap<User, ArrayList<Tweet>>();
		char[] asciiCharacter = new char[3];
		char[] space = new char[1];
		StringBuilder stringTweets = new StringBuilder(); 
		
		while (reader.read(asciiCharacter, 0, 3) != -1) {
			String asciiChar = new String(asciiCharacter);
			int asciiVal =  Integer.parseInt(asciiChar);
			stringTweets.append(String.valueOf(Character.toChars(asciiVal)));
			
			reader.read(space, 0, 1);
		}
		
		ArrayList<String> tweetFile = new ArrayList<String>(Arrays.asList(stringTweets.toString().split("\r")));
		
		for (String tweet: tweetFile) {
			//This functionality is commom between both readers/loaders. should be moved to one location in the parent class
			String username = GetUsername(tweet);
			String usersTweet = GetTweet(tweet);
			
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
