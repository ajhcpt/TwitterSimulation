package ag.twittersimulation.main;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import ag.twittersimulation.interfaces.IOutputTweets;
import ag.twittersimulation.tweet.Tweet;
import ag.twittersimulation.user.User;

public class OuputTweetsToConsole implements IOutputTweets {

	@Override
	public TreeMap<User, List<Tweet>> FormatTweetOutput(
			HashMap<String, User> users, HashMap<User, List<Tweet>> tweets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void OutputTweets(HashMap<String, User> users,
			HashMap<User, List<Tweet>> tweets) {
		// TODO Auto-generated method stub
		
	}

}
