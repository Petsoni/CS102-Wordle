package utils;

import controllers.ScoreController;
import entities.Score;
import entities.User;
import exceptions.alerts.AlertUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.List;

/***
 * Class for all the methods that are used in the game for player inputs
 */
public class LetterChecker {

	/***
	 * Method that checks if the characters in a word match the characters in the answer
	 * @param textFieldList
	 * @param answer
	 */
	public boolean checkGuess(List<TextField> textFieldList, String answer, User user) {

		StyleGetter styleGetter = new StyleGetter();

		Score score = new Score();
		score.setUser(user);

		int count = 0;
		double value = 0;

		for (int i = 0; i < textFieldList.size(); i++) {

			TextField textField = textFieldList.get(i);

			String playerLetter = textField.getText();

			textField.getStylesheets().add(styleGetter.getStyle());

			if (playerLetter.equals(answer.substring(i, i + 1))) {

				textField.getStyleClass().add("field-green");

				count++;

				value += 50;

			} else if (answer.contains(playerLetter)) {

				textField.getStyleClass().add("field-yellow");

				value += 25;

			} else {

				textField.getStyleClass().add("square");

			}
		}

		if (count == 5) {
			AlertUtil.showAlert("You won!", "You won the game!", "", Alert.AlertType.INFORMATION);

			value += 75;

			score.setValue(value);

			ScoreController.save(score);

			System.out.println(score.getValue());
			System.out.println(score.getUser());

			return true;
		}

		return false;

	}

	/***
	 * Method that combines the characters in a a list of text fields to make a word
	 * @param textFieldList
	 * @return word
	 */
	public String combineCharsToMakeAWord(List<TextField> textFieldList) {

		String word = "";

		for (int i = 0; i < textFieldList.size(); i++) {

			TextField textField = textFieldList.get(i);

			word += textField.getText();
		}

		return word;
	}

}


