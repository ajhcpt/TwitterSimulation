package ag.twittersimulation.factory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import ag.twittersimulation.interfaces.IUserLoader;
import ag.twittersimulation.user.AsciiFileUserLoader;
import ag.twittersimulation.user.TextFileUserLoader;

public class UserReaderFactory {
	public static IUserLoader getUserLoader(String encoding, String fileName) throws UnsupportedEncodingException, FileNotFoundException {
		IUserLoader reader = null;
		
		switch (encoding.toUpperCase()) {
		case "ASCII": 
			reader = new AsciiFileUserLoader(new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "ASCII")));
			break;
		
		case "PLAINTEXT":
			reader = new TextFileUserLoader(new BufferedReader(new FileReader(fileName)));
			break;
		}
		return reader;
	}

}
