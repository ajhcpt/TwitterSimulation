package ag.twittersimulation.factory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import ag.twittersimulation.user.AbstractUserLoader;
import ag.twittersimulation.user.AsciiFileUserLoader;
import ag.twittersimulation.user.TextFileUserLoader;

public class UserLoaderFactory {
	public static AbstractUserLoader getUserLoader(String encoding, String fileName) throws UnsupportedEncodingException, FileNotFoundException {
		AbstractUserLoader loader = null;
		
		switch (encoding.toUpperCase()) {
		case "ASCII": 
			loader = new AsciiFileUserLoader(new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "ASCII")));
			break;
		
		case "PLAINTEXT":
			loader = new TextFileUserLoader(new BufferedReader(new FileReader(fileName)));
			break;
		}
		return loader;
	}

}
