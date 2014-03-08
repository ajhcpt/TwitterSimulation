package ag.twittersimulation.interfaces;

import java.util.List;
import ag.twittersimulation.tweet.Tweet;

public interface ITweetLoader {
	public List<Tweet> LoadTweets();
}
