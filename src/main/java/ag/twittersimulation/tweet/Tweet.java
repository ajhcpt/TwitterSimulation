package ag.twittersimulation.tweet;

import ag.twittersimulation.user.User;

public class Tweet {
	String tweet;
	User user;
	
	Tweet(User user, String tweet) {
		this.user = user;
		this.tweet = tweet;
	}
	
	public User getUser() {
		return user;
	}
	
}
