package ag.twittersimulation.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ag.twittersimulation.interfaces.IUserLoader;

public class AsciiFileUserLoader implements IUserLoader {
	BufferedReader reader;
	
	public AsciiFileUserLoader(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public HashMap<String, User> LoadUsers() throws IOException {
		HashMap<String, User> users = new HashMap<String, User>();
		char[] asciiCharacter = new char[3];
		char[] space = new char[1];
		ArrayList<Character> charUsers = new ArrayList<Character>();
		
		while (reader.read(asciiCharacter, 0, 3) != -1) {
			//while not encountering the 013 (vertical tab) character, add to a string. 
			//Once the 013 is encountered, add the existing string to a string list and start creating a new string.
			
			String asciiChar = new String(asciiCharacter);
			reader.read(space, 0, 1);
		}
		return null;
	}
		
}
