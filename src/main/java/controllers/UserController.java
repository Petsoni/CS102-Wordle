package controllers;

import connection.DBConnection;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserController {

	private static Connection connection;

	/***
	 * Method that returns all words from the database
	 * @return words
	 */
	public static List<User> getAllUsers() {

		List<User> userList = new ArrayList<>();

		try {

			connection = DBConnection.openConnection();

			PreparedStatement getAllStmt = connection.prepareStatement("SELECT * FROM user;");

			ResultSet set = getAllStmt.executeQuery();

			while (set.next()) {
				User user = new User();

				user.setId(set.getInt("id"));
				user.setName(set.getString("name"));
				user.setSurname(set.getString("surname"));
				user.setUsername(set.getString("username"));
				user.setPassword(set.getString("password"));

				userList.add(user);
			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	/***
	 * Method that takes in a word and saves it in the database
	 * @param user
	 */
	public static User save(User user) {

		try {

			connection = DBConnection.openConnection();

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO user" + "(name,surname," +
					"username,password) VALUES (?,?,?,?)");

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getSurname());
			stmt.setString(3, user.getUsername());
			stmt.setString(4, user.getPassword());

			stmt.execute();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;

	}

	/***
	 * Method that updates the given word in the database
	 * @param user
	 */
	public static User update(User user) {

		try {

			connection = DBConnection.openConnection();

			PreparedStatement updateStmt = connection.prepareStatement(
					"UPDATE user SET name = ?, surname = ?, username = ?, password = ? WHERE id = ?");

			updateStmt.setString(1, user.getName());
			updateStmt.setString(2, user.getSurname());
			updateStmt.setString(3, user.getUsername());
			updateStmt.setString(4, user.getPassword());

			updateStmt.execute();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;

	}

	/***
	 * Method that deletes the given word from the database
	 * @param user
	 */
	public static void delete(User user) {

		try {

			connection = DBConnection.openConnection();

			PreparedStatement deleteStmt = connection.prepareStatement(
					"DELETE FROM user WHERE id= ?");

			deleteStmt.setInt(1, user.getId());

			deleteStmt.execute();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/***
	 * Method that checks if the login details are correct
	 * @param username
	 * @param password
	 * @return true if the login details are correct
	 */
	public static boolean checkLoginDetails(String username, String password) {

		try {

			connection = DBConnection.openConnection();

			PreparedStatement stmt = connection.prepareStatement(
					"SELECT * FROM user WHERE username = ? AND password = ?;");

			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet set = stmt.executeQuery();

			if (set.next()) {
				return true;
			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	/***
	 * Method that checks if the username is already taken
	 * @param username
	 * @return true if the username is already taken
	 */
	public static boolean checkUsername(String username) {

		try {

			connection = DBConnection.openConnection();

			PreparedStatement stmt = connection.prepareStatement(
					"SELECT * FROM user WHERE username = ?;");

			stmt.setString(1, username);

			ResultSet set = stmt.executeQuery();

			if (set.next()) {
				return true;
			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}




