package ag.twittersimulation.user;

import java.io.BufferedReader;
import java.util.List;

import ag.twittersimulation.interfaces.IUserReader;

public class TextFileUserReader implements IUserReader {
	BufferedReader reader;
	
	TextFileUserReader(BufferedReader reader) {
		this.reader = reader;
	}
	
	public List<User> Read() {
		return null;
		
	}

}
