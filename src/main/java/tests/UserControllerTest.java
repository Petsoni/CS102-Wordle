package tests;

import controllers.ScoreController;
import controllers.UserController;
import entities.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserControllerTest {

	private static User user = new User();

	private static String name = "Test";
	private static String surname = "Testovic";
	private static String username = "Test123";
	private static String password = "test123";
	private static String badPassword = "test123535";

	@BeforeTest
	public static void setUp() {

		user = new User(name, surname, username, password);

		UserController.save(user);

	}

	@AfterTest
	public static void tearDown() {

		user = UserController.getUserByUsername(username);

		UserController.delete(user);

	}

	@Test
	public void testUpdateUserPassword() {

		String newPassword = "newPassword";

		user = UserController.getUserByUsername(username);

		user.setPassword(newPassword);

		assertEquals(UserController.updateUserPassword(user).getPassword(), newPassword);

	}

	@Test
	public void testCheckLoginDetails() {

		assertTrue(UserController.checkLoginDetails(username, password));

	}

	@Test
	public void testCheckLoginDetailsIfNotCorrect() {

		assertFalse(UserController.checkLoginDetails(username, badPassword));

	}

	@Test
	public void testCheckUsernameIfExists() {

		assertTrue(UserController.checkUsername(username));

	}

	@Test
	public void testCheckUsernameIfItDoesntExists() {

		assertFalse(UserController.checkUsername("Test1234"));

	}

	@Test
	public void testCheckPassword() {

		assertTrue(UserController.checkPassword(password));

	}

	@Test
	public void testCheckPasswordIfItDoesntExists() {

		assertFalse(UserController.checkPassword("password"));

	}

	@Test
	public void testGetUserByUsername() {

		assertEquals(UserController.getUserByUsername(username).getUsername(), username);

	}

	@Test
	public void testGetUserByUsernameFalse() {

		assertNotEquals(UserController.getUserByUsername(username).getUsername(), "username");

	}

	/*TODO: BUG*/
	@Test
	public void testGetUserByIdNotEqual() {

		user = UserController.getUserByUsername(username);

		assertEquals(UserController.getUserById(user.getId()), user);

	}

	@Test
	public void testGetUserById() {

		user = UserController.getUserByUsername(username);


		assertNotEquals(UserController.getUserById(user.getId()), user);

	}
}