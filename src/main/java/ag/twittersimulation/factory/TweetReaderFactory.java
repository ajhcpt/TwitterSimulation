package ag.twittersimulation.factory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import ag.twittersimulation.interfaces.TweetLoader;
import ag.twittersimulation.tweet.AsciiFileTweetLoader;
import ag.twittersimulation.tweet.TextFileTweetLoader;

public class TweetReaderFactory {
	public static TweetLoader getTweetReader(String encoding, String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		TweetLoader reader = null;
		
		switch (encoding.toUpperCase()) {
		case "ASCII": 
			reader = new AsciiFileTweetLoader(new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "US-ASCII")));
			break;
			
		case "PLAINTEXT":
			reader = new TextFileTweetLoader(new BufferedReader(new FileReader(fileName)));
			break;
		}
		return reader;
		
	}
}
