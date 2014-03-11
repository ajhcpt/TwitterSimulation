package ag.twittersimulation.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ag.twittersimulation.interfaces.IUserLoader;

public class TextFileUserLoader implements IUserLoader {
	BufferedReader reader;
	
	public TextFileUserLoader(BufferedReader reader) {
		this.reader = reader;
	}

	public HashMap<String, User> LoadUsers() throws IOException {
		HashMap<String, User> users = new HashMap<String, User>();
		
		String lineFromUserFile = null;
		while ((lineFromUserFile = reader.readLine()) != null) {
			int followerNameEnds = lineFromUserFile.indexOf(" follows ");
			int followeeNamesStart = followerNameEnds + 9;
			String followerName =  lineFromUserFile.substring(0, followerNameEnds);
			String strFolloweeNames = RemoveSpaces(lineFromUserFile.substring(followeeNamesStart));
			ArrayList<String> followeeNames = new ArrayList<String>(Arrays.asList(strFolloweeNames.split(",")));
						
			if (users.get(followerName) == null) {
				User followerUser = new User(followerName, followeeNames);
				users.put(followerName, followerUser);
			} else {
				User existingUser = users.get(followerName);
				existingUser.AddFollower(followeeNames);
				users.put(followerName, existingUser);
			}
			
			for (String followee: followeeNames) {
				if (users.get(followee) == null) {
					User followeeUser = new User(followee, null);
					if (users.get(followeeUser) == null) {
						users.put(followee, followeeUser);
					}
				}	 
			}			
		}
		return users;
	}
	
	private String RemoveSpaces(String stringWithSpaces) {
		char[] charArrayWithSpaces = stringWithSpaces.toCharArray();
		StringBuilder stringWithoutSpaces = new StringBuilder();
		
		for (char c: charArrayWithSpaces) {
			if (c != ' ') {
				stringWithoutSpaces.append(c);
			}
		}
		return stringWithoutSpaces.toString();
		
	}
	
	
}
