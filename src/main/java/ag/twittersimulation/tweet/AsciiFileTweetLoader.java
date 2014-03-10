package ag.twittersimulation.tweet;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;

import ag.twittersimulation.interfaces.ITweetLoader;
import ag.twittersimulation.user.User;

public class AsciiFileTweetLoader implements ITweetLoader {
BufferedReader reader;
	
	public AsciiFileTweetLoader(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public HashMap<User, List<Tweet>> LoadTweets() {
		// TODO Auto-generated method stub
		return null;
	}

}
