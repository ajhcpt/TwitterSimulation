package ag.twittersimulation.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.TreeMap;

import ag.twittersimulation.factory.OutputTweetsFactory;
import ag.twittersimulation.factory.TweetLoaderFactory;
import ag.twittersimulation.factory.UserLoaderFactory;
import ag.twittersimulation.interfaces.IOutputTweets;
import ag.twittersimulation.tweet.Tweet;
import ag.twittersimulation.tweet.TweetLoader;
import ag.twittersimulation.user.User;
import ag.twittersimulation.user.UserLoader;

public class Main {

	public static void main(String[] args) throws IOException {
		Properties config = new Properties();
		try {
			config.load(new FileInputStream(args[0]));
			UserLoader userLoader = UserLoaderFactory.getUserLoader(config.getProperty("userfileformat"), config.getProperty("userfile"));
			TweetLoader tweetLoader = TweetLoaderFactory.getTweetLoader(config.getProperty("tweetfileformat"), config.getProperty("tweetfile"));
			
			TreeMap<String, User> tmUsers = userLoader.LoadUsers();
			HashMap<User, ArrayList<Tweet>> hmTweets = tweetLoader.LoadTweets(tmUsers);

			IOutputTweets output = OutputTweetsFactory.GetOutputFormat("Console");
			output.OutputTweets(tmUsers, hmTweets);

		} catch (FileNotFoundException e) {
			System.out.println("Please specify the path to the environment.properties file as the argument.");
		}
	}
}
