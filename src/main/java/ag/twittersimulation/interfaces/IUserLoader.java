package ag.twittersimulation.interfaces;

import java.util.List;
import ag.twittersimulation.user.User;

public interface IUserLoader {
	List<User> LoadDistinctUserList();
	
}
