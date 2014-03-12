package ag.twittersimulation.interfaces;

import java.util.HashMap;
import java.util.List;

import ag.twittersimulation.tweet.Tweet;
import ag.twittersimulation.user.User;

public abstract class TweetLoader {
	public abstract HashMap<User, List<Tweet>> LoadTweets();
}
