package ag.twittersimulation.output;

import java.util.ArrayList;
import java.util.Collections;
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
			String username = entry.getKey();
			User user = entry.getValue();
			System.out.println(username);
			
			ArrayList<Tweet> usersTweetList = tweets.get(user);
			if (usersTweetList != null) {
				for (Tweet usersTweet: usersTweetList) {
					StringBuilder tweetOutput = new StringBuilder();
					tweetOutput.append('\t');
					tweetOutput.append("@");
					tweetOutput.append(username);
					tweetOutput.append(": ");
					tweetOutput.append(usersTweet.getTweet());
					System.out.println(tweetOutput.toString());
				}
			}
			
			ArrayList<String> followsList = user.getFollows();			
			if (followsList != null) {
				for (String follows: followsList) {
					ArrayList<Tweet> followsTweetsList = tweets.get(users.get(follows));
					if (followsTweetsList != null) {
						for (Tweet followsTweet: followsTweetsList) {
							StringBuilder followsTweetOuput = new StringBuilder();
							followsTweetOuput.append('\t');
							followsTweetOuput.append("@");
							followsTweetOuput.append(follows);
							followsTweetOuput.append(": ");
							followsTweetOuput.append(followsTweet.getTweet());
							System.out.println(followsTweetOuput.toString());
						}
					}
				}
			}
		}
	}
}
