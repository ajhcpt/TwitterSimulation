package ag.twittersimulation.tweet;

import java.io.BufferedReader;
import java.util.List;

import ag.twittersimulation.interfaces.ITweetLoader;

public class AsciiFileTweetLoader implements ITweetLoader {
BufferedReader reader;
	
	public AsciiFileTweetLoader(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public List<Tweet> LoadTweets() {
		// TODO Auto-generated method stub
		return null;
	}

}
