package ag.twittersimulation.factory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import ag.twittersimulation.tweet.AsciiFileTweetLoader;
import ag.twittersimulation.tweet.TextFileTweetLoader;
import ag.twittersimulation.tweet.TweetLoader;

public class TweetLoaderFactory {
	public static TweetLoader getTweetLoader(String encoding, String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		TweetLoader loader = null;
		
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
