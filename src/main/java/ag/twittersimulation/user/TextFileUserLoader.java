package ag.twittersimulation.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TextFileUserLoader extends UserLoader {
	BufferedReader reader;
	
	public TextFileUserLoader(BufferedReader reader) {
		this.reader = reader;
	}

	public HashMap<String, User> LoadUsers() throws IOException {
		HashMap<String, User> users = new HashMap<String, User>();
		
		String lineFromUserFile = null;
		while ((lineFromUserFile = reader.readLine()) != null) {
			String followerName =  GetFollowerName(lineFromUserFile);
			ArrayList<String> followeeNames = GetFolloweeNames(lineFromUserFile);
			users = AddUsers(users, followerName, followeeNames);	
		}
		return users;
	}
		
}
