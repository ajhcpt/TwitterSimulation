package ag.twittersimulation.main;

import java.util.List;

import ag.twittersimulation.interfaces.IOutputTweets;
import ag.twittersimulation.tweet.Tweet;
import ag.twittersimulation.user.User;

public class OuputTweetsToConsole implements IOutputTweets {

	@Override
	public void OutputTweets(List<User> users, List<Tweet> tweets) {
		// TODO Auto-generated method stub
		for (User user : users) {
			List<Tweet> usersTweets = findTweetsForUser(user, tweets);			
		}
	}

	private List<Tweet> findTweetsForUser(User user, List<Tweet> tweets) {
		List<Tweet> thisUsersTweets = null;
		for (Tweet tweet: tweets) {
			if(user.getName() == tweet.getUser().getName()) {
				thisUsersTweets.add(tweet);
			}
		}
		return thisUsersTweets;
	}

}
