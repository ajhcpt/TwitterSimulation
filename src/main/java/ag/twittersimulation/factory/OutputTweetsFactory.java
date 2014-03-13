package ag.twittersimulation.factory;

import ag.twittersimulation.interfaces.IOutputTweets;
import ag.twittersimulation.output.OutputTweetsToConsole;
import ag.twittersimulation.output.OutputTweetsToFile;

public class OutputTweetsFactory {
	public static IOutputTweets GetOutputFormat(String outputFormat) {
		IOutputTweets outFormat = null;
		
		switch (outputFormat.toUpperCase()) {
		case "CONSOLE": 
			outFormat = new OutputTweetsToConsole();
			break;
			
		case "FILE":
			outFormat = new OutputTweetsToFile();
			break;			
		}
		return outFormat;
	}
}
