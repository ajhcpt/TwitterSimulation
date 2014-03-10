package ag.twittersimulation.user;

import java.io.BufferedReader;
import java.util.HashMap;

import ag.twittersimulation.interfaces.IUserLoader;

public class AsciiFileUserLoader implements IUserLoader {
	BufferedReader reader;
	
	public AsciiFileUserLoader(BufferedReader reader) {
		this.reader = reader;
	}

	@Override
	public HashMap<String, User> LoadUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}
