package ag.twittersimulation.user;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCreateUserWithFollowersList() {
		ArrayList<String> listOfFollowers = new ArrayList<String>();
		listOfFollowers.add("Tom");
		listOfFollowers.add("Jack");
		listOfFollowers.add("Sue");
		listOfFollowers.add("Paul");
		listOfFollowers.add("Jane");
		User user = new User("Phil", listOfFollowers);

		assertEquals(5, user.getFollowers().size());
	}

	@Test
	public void testAddFollowersViaSingleString() {
		User user = new User("TestName");
		user.AddFollower("James");
		user.AddFollower("Peter");
		user.AddFollower("Jenny");
		assertEquals(3, user.getFollowers().size());
	}
	
	@Test
	public void testAddFollowersList() {
		User user = new User("TestName");
		ArrayList<String> listOfFollowers = new ArrayList<String>();
		listOfFollowers.add("Tom");
		listOfFollowers.add("Jack");
		listOfFollowers.add("Sue");
		listOfFollowers.add("Paul");
		listOfFollowers.add("Jane");
		user.AddFollower(listOfFollowers);
		assertEquals(5, user.getFollowers().size());
	}

}
