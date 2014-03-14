package ag.twittersimulation.user;

import java.util.ArrayList;

public class User implements Comparable<User> {
	private String name;
	private ArrayList<String> follows;
	
	public User(String name) {
		this.name = name;
	}

	public User(String name, ArrayList<String> follows) {
		this.name = name;
		this.follows = follows;
	}

	
	public void AddFollower(String follows) {
		if(!this.follows.contains(follows)) {
			this.follows.add(follows);
		}
	}
	
	public void AddFollower(ArrayList<String> followsList) {
		if (follows != null) {		
			for (String follow: followsList) {
				if (!follows.contains(follow)) {
					follows.add(follow);
				}
			}
		} else {
			follows = followsList;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getFollows() {
		return follows;
	}

	@Override
	public int compareTo(User compareUser) {
		return this.name.compareTo(compareUser.name);
	}
	
}
