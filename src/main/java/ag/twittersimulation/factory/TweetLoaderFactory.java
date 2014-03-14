package ag.twittersimulation.factory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import ag.twittersimulation.tweet.AbstractTweetLoader;
import ag.twittersimulation.tweet.AsciiFileTweetLoader;
import ag.twittersimulation.tweet.TextFileTweetLoader;

public class TweetLoaderFactory {
	public static AbstractTweetLoader getTweetLoader(String encoding, String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		AbstractTweetLoader loader = null;
		
		switch (encoding.toUpperCase()) {
		case "ASCII": 
			loader = new AsciiFileTweetLoader(new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "US-ASCII")));
			break;
			
		case "PLAINTEXT":
			loader = new TextFileTweetLoader(new BufferedReader(new FileReader(fileName)));
			break;
		}
		return loader;
		
	}
}
