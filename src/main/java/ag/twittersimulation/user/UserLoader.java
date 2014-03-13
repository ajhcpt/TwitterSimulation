package ag.twittersimulation.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class UserLoader {
	public abstract HashMap<String, User> LoadUsers() throws IOException;
	
	protected static String RemoveSpaces(String stringWithSpaces) {
		char[] charArrayWithSpaces = stringWithSpaces.toCharArray();
		StringBuilder stringWithoutSpaces = new StringBuilder();
		
		for (char c: charArrayWithSpaces) {
			if (c != ' ') {
				stringWithoutSpaces.append(c);
			}
		}
		return stringWithoutSpaces.toString();
		
	}
	
	protected static String GetFollowerName(String userFileLine) {
		int followerNameEnds = userFileLine.indexOf(" follows ");
		return userFileLine.substring(0, followerNameEnds);
	}
	
	protected static ArrayList<String> GetFolloweeNames(String userFileLine) {
		int followerNameEnds = userFileLine.indexOf(" follows ");
		int followeeNamesStart = followerNameEnds + 9;
		String strFolloweeNames = RemoveSpaces(userFileLine.substring(followeeNamesStart));
		ArrayList<String> followeeNames = new ArrayList<String>(Arrays.asList(strFolloweeNames.split(",")));
		return followeeNames;
	}

	protected static HashMap<String, User> AddUsers(HashMap<String, User> users, String followerName, ArrayList<String> followeeNames) {
		HashMap<String, User> tempUsers = users;
		if (tempUsers.get(followerName) == null) {
			User followerUser = new User(followerName, followeeNames);
			tempUsers.put(followerName, followerUser);
		} else {
			User existingUser = tempUsers.get(followerName);
			existingUser.AddFollower(followeeNames);
			tempUsers.put(followerName, existingUser);
		}
		
		for (String followee: followeeNames) {
			if (tempUsers.get(followee) == null) {
				User followeeUser = new User(followee, null);
				if (tempUsers.get(followeeUser) == null) {
					tempUsers.put(followee, followeeUser);
				}
			}	 
		}		
		return tempUsers;
	}
	
}
