package ag.twittersimulation.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AsciiFileUserLoader extends UserLoader {
	BufferedReader reader;
	
	public AsciiFileUserLoader(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public HashMap<String, User> LoadUsers() throws IOException {
		HashMap<String, User> users = new HashMap<String, User>();
		char[] asciiCharacter = new char[3];
		char[] space = new char[1];
		StringBuilder stringUsers = new StringBuilder(); 
		
		while (reader.read(asciiCharacter, 0, 3) != -1) {
			String asciiChar = new String(asciiCharacter);
			int asciiVal =  Integer.parseInt(asciiChar);
			stringUsers.append(String.valueOf(Character.toChars(asciiVal)));
			
			reader.read(space, 0, 1);
		}
		
		ArrayList<String> userFile = new ArrayList<String>(Arrays.asList(stringUsers.toString().split("\r")));
		
		for (String userString: userFile) {
			String followerName =  GetFollowerName(userString);
			ArrayList<String> followeeNames = GetFolloweeNames(userString);
			users = AddUsers(users, followerName, followeeNames);			
		}
		return users;		
	}
		
	
}
