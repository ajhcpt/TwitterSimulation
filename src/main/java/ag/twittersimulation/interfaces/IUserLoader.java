package ag.twittersimulation.interfaces;

import java.io.IOException;
import java.util.HashMap;

import ag.twittersimulation.user.User;

public interface IUserLoader {
	public HashMap<String, User> LoadUsers() throws IOException;
	
}
