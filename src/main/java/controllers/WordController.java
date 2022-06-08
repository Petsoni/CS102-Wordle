package controllers;

import connection.DBConnection;
import entities.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordController {

	private static Connection connection;

	/***
	 * Method that returns all words from the database
	 * @return words
	 */
	public static List<Word> getAllWords() {

		List<Word> wordList = new ArrayList<>();

		try {

			connection = DBConnection.openConnection();

			PreparedStatement getAllStmt = connection.prepareStatement("SELECT * FROM word;");

			ResultSet set = getAllStmt.executeQuery();

			while (set.next()) {
				Word word = new Word();

				word.setId(set.getInt("id"));
				word.setValue(set.getString("value"));

				wordList.add(word);
			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return wordList;
	}

	/***
	 * Method that takes in a word and saves it in the database
	 * @param word
	 * @return word
	 */
	public static void save(Word word) {

		try {

			connection = DBConnection.openConnection();

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO word" + "(value) VALUES (?)");

			stmt.setString(1, word.getValue());

			stmt.execute();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/***
	 * Method that updates the given word in the database
	 * @param word
	 */
	public static void update(Word word) {

		try {

			connection = DBConnection.openConnection();

			PreparedStatement updateStmt = connection.prepareStatement(
					"UPDATE word SET value = ? WHERE id = ?");

			updateStmt.setString(1, word.getValue());
			updateStmt.setInt(2, word.getId());

			updateStmt.execute();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/***
	 * Method that deletes the given word from the database
	 * @param word
	 */
	public static void delete(Word word) {

		try {

			connection = DBConnection.openConnection();

			PreparedStatement deleteStmt = connection.prepareStatement(
					"DELETE FROM word WHERE id= ?");

			deleteStmt.setInt(1, word.getId());

			deleteStmt.execute();

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
