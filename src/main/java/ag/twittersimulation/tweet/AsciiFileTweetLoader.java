package ag.twittersimulation.tweet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ag.twittersimulation.user.User;

public class AsciiFileTweetLoader extends TweetLoader {
BufferedReader reader;
	
	public AsciiFileTweetLoader(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public HashMap<User, ArrayList<String>> LoadTweets(HashMap<String, User> users) throws IOException {
		HashMap<User, ArrayList<String>> tweets = new HashMap<User, ArrayList<String>>();
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
				tweets = AddTweet(tweets, newUser, usersTweet);
			} else {
				tweets = AddTweet(tweets, users.get(username), usersTweet);
			}
		}
		return tweets;
	}

}
