package ag.twittersimulation.user;

import java.util.List;

public class User {
	private String name;
	private List<User> follows;
	private List<User> imFollowing;
	
	User(String name) {
		this.name = name.toUpperCase();
	}
	
	public void AddFollower(User follower) {
		if(!follows.contains(follower)) {
			follows.add(follower);
		}
	}
	
	public void AddFollowing(User following) {
		if(!imFollowing.contains(following)) {
			imFollowing.add(following);
		}
	}

	public String getName() {
		return name;
	}
	
}
