package ag.twittersimulation.user;

import java.util.List;

public class User {
	private String name;
	private List<User> follows;
	
	User(String name) {
		this.name = name;
	}
	
	public void AddFollower(User follower) {
		if(!follows.contains(follower)) {
			follows.add(follower);
		}
	}
	
	
}
