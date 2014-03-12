package ag.twittersimulation.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import ag.twittersimulation.factory.TweetReaderFactory;
import ag.twittersimulation.factory.UserReaderFactory;
import ag.twittersimulation.interfaces.TweetLoader;
import ag.twittersimulation.interfaces.UserLoader;
import ag.twittersimulation.tweet.Tweet;
import ag.twittersimulation.user.User;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Properties config = new Properties();
		config.load(new FileInputStream(args[0]));
		UserLoader userLoader = UserReaderFactory.getUserLoader(config.getProperty("userfileformat"), config.getProperty("userfile"));
		TweetLoader tweetLoader = TweetReaderFactory.getTweetReader(config.getProperty("tweetfileformat"), config.getProperty("tweetfile"));
		
		HashMap<String, User> hmUsers = userLoader.LoadUsers();
		HashMap<User, List<Tweet>> hmTweets = tweetLoader.LoadTweets();
		
		
		System.out.println("test");
		
		
	}

}
