package ag.twittersimulation.user;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserLoaderTest {

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
	public void testRemoveSpaces() {
		String stringWithSpaces = " fsdf, fdfiij   998jnndDSA hdsdDD9 98 bn bv   v ";
		assertEquals("fsdf,fdfiij998jnndDSAhdsdDD998bnbvv", UserLoader.RemoveSpaces(stringWithSpaces));
	}
	
	@Test
	public void testGetFollowerName() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetFolloweeNames() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddUsers() {
		fail("Not yet implemented");
	}
	

}
