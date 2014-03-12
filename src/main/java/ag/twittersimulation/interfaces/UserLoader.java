package ag.twittersimulation.interfaces;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ag.twittersimulation.user.User;

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

	protected static void AddFollowerUser(HashMap<String, User> users, String followerName, ArrayList<String> followeeNames) {
		if (users.get(followerName) == null) {
			User followerUser = new User(followerName, followeeNames);
			users.put(followerName, followerUser);
		} else {
			User existingUser = users.get(followerName);
			existingUser.AddFollower(followeeNames);
			users.put(followerName, existingUser);
		}
	}

	protected static void AddFolloweeUsers(HashMap<String, User> users, ArrayList<String> followeeNames) {
		for (String followee: followeeNames) {
			if (users.get(followee) == null) {
				User followeeUser = new User(followee, null);
				if (users.get(followeeUser) == null) {
					users.put(followee, followeeUser);
				}
			}	 
		}			
	}
	
}
