package ag.twittersimulation.interfaces;

import java.util.HashMap;
import java.util.List;

import ag.twittersimulation.tweet.Tweet;
import ag.twittersimulation.user.User;

public interface ITweetLoader {
	public HashMap<User, List<Tweet>> LoadTweets();
}
