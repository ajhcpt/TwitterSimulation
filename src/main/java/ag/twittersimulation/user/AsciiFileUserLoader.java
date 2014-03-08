package ag.twittersimulation.user;

import java.io.BufferedReader;
import java.util.List;

import ag.twittersimulation.interfaces.IUserLoader;

public class AsciiFileUserLoader implements IUserLoader {
	BufferedReader reader;
	
	public AsciiFileUserLoader(BufferedReader reader) {
		this.reader = reader;
	}
	
	@Override
	public List<User> LoadDistinctUserList() {
		// TODO Auto-generated method stub
		return null;
	}


}
