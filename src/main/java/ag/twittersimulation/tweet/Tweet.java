package ag.twittersimulation.tweet;

import java.util.concurrent.atomic.AtomicInteger;

public class Tweet implements Comparable<Tweet> {
	private int index;
	private String tweet;
	
	private static AtomicInteger nextIndex = new AtomicInteger(0);	
	
	public Tweet(String tweet) {
		this.index = nextIndex.incrementAndGet();
		this.tweet = tweet;
	}

	public String getTweet() {
		return tweet;
	}

	public int getIndex() {
		return index;
	}

	public int compareTo(Tweet tweet) {
		return this.index - tweet.getIndex();
	}

	
}
