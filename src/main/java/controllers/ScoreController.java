package controllers;

import connection.DBConnection;
import entities.Score;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreController {

	public static Connection connection;

	/***
	 * Method that returns all scores from the database
	 * @return scoreList
	 */
	public static List<Score> getAllScores() {

		List<Score> scoreList = new ArrayList<>();

		try {

			connection = DBConnection.openConnection();

			PreparedStatement getAllStmt = connection.prepareStatement("SELECT * FROM score;");

			ResultSet set = getAllStmt.executeQuery();

			while (set.next()) {
				Score score = new Score();

				score.setId(set.getInt("id"));
				score.setValue(set.getDouble("value"));

			}

			connection.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return scoreList;

	}

	/***
	 * Method that takes in a score and saves it in the database
	 * @return score
	 */
	public static Score save(Score score) {

		try {

			connection = DBConnection.openConnection();


			PreparedStatement saveStmt = connection.prepareStatement("INSERT INTO score (value, user_fk) " +
					"VALUES (?,?);");

			saveStmt.setDouble(1, score.getValue());
			saveStmt.setDouble(2, score.getUser().getId());

			saveStmt.executeUpdate();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return score;

	}

	/***
	 * Method that updates the given score in the database
	 * @param score
	 */
	public static Score update(Score score) {

		try {

			connection = DBConnection.openConnection();

			PreparedStatement updateStmt = connection.prepareStatement(
					"UPDATE score SET value = ? WHERE id = ?");

			updateStmt.setDouble(1, score.getValue());

			updateStmt.execute();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return score;

	}

	/***
	 * Method that deletes the given score in the database
	 * @param score
	 */
	public static void delete(Score score) {

		try {

			connection = DBConnection.openConnection();

			PreparedStatement deleteStmt = connection.prepareStatement(
					"DELETE FROM score WHERE id= ?");

			deleteStmt.setInt(1, score.getId());

			deleteStmt.execute();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/***
	 * Method that returns the score based on the given userId
	 * @return scoreList
	 */
	public static Score getScoreForUser(int userId) {

		List<User> userList = UserController.getAllUsers();

		Score score = new Score();

		for (User user : userList) {
			if (user.getId() == userId) {
				score.setUser(user);
			}
		}

		return score;

	}


	public static Score getUsersTotalScore(int userId) {

		Score score = new Score();

		try {

			connection = DBConnection.openConnection();

			PreparedStatement getTotalScoreStmt = connection.prepareStatement("SELECT SUM(value) AS total_score FROM score WHERE user_fk = ?;");

			getTotalScoreStmt.setInt(1, userId);

			ResultSet set = getTotalScoreStmt.executeQuery();

			while (set.next()) {
				score.setValue(set.getDouble("total_score"));
			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return score;

	}
}
