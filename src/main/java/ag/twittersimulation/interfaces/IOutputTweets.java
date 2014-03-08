package ag.twittersimulation.interfaces;

import java.util.List;
import ag.twittersimulation.tweet.Tweet;
import ag.twittersimulation.user.User;

public interface IOutputTweets {
	public void OutputTweets(List<User> users, List<Tweet> tweets);
}
