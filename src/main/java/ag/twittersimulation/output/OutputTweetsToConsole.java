package ag.twittersimulation.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import ag.twittersimulation.interfaces.IOutputTweets;
import ag.twittersimulation.tweet.Tweet;
import ag.twittersimulation.user.User;

public class OutputTweetsToConsole implements IOutputTweets {

	@Override
	public void OutputTweets(TreeMap<String, User> users, HashMap<User, ArrayList<Tweet>> tweets) {
		for (Map.Entry<String, User> entry: users.entrySet()) {
			HashMap<User, ArrayList<Tweet>> unsortedUserTweetMap = new HashMap<User, ArrayList<Tweet>>();
			User user = entry.getValue();
			System.out.println(user.getName());
			
			unsortedUserTweetMap.put(user, tweets.get(user));
						
			ArrayList<String> followsList = user.getFollows();			
			if (followsList != null) {
				for (String follows: followsList) {
					user = users.get(follows);
					unsortedUserTweetMap.put(user, tweets.get(user));
				}
			}
			
			TreeMap<Tweet, User> sortedTweetUserMap = new TreeMap<Tweet, User>();
			for (Map.Entry<User, ArrayList<Tweet>> unsortedEntry: unsortedUserTweetMap.entrySet()) {
				if(unsortedEntry.getValue() != null) {
					for (Tweet tweet: unsortedEntry.getValue()) {
						sortedTweetUserMap.put(tweet, unsortedEntry.getKey());
					}
				}
			}
			
			for (Map.Entry<Tweet, User> sortedEntry: sortedTweetUserMap.entrySet()) {
				StringBuilder output = new StringBuilder();
				output.append('\t');
				output.append("@");
				output.append(sortedEntry.getValue().getName());
				output.append(": ");
				output.append(sortedEntry.getKey().getTweet());
				System.out.println(output.toString());
			}
		}
	}
}
