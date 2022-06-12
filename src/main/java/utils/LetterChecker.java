package utils;

import building_classes.FinishScene;
import building_classes.GameScenePrimary;
import controllers.ScoreController;
import entities.Score;
import entities.User;
import exceptions.alerts.AlertUtil;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
	public boolean checkGuess(List<TextField> textFieldList, String answer, User user, Stage stage) {

		StyleGetter styleGetter = new StyleGetter();

		int count = 0;

		double value = 0;

		int rowCount = 0;

		for (int i = 0; i < textFieldList.size(); i++) {

			TextField textField = textFieldList.get(i);

			String playerLetter = textField.getText();

			textField.getStylesheets().add(styleGetter.getStyle());

			if (playerLetter.equals(answer.substring(i, i + 1))) {

				textField.getStyleClass().add("field-green");

				count++;

				rowCount = i;

				System.out.println("Correct letter");

			} else if (answer.contains(playerLetter)) {

				textField.getStyleClass().add("field-yellow");

				System.out.println("Correct letter but not in the right position");

			} else {

				textField.getStyleClass().add("square");

			}
		}

		if (count == 5) {



			return true;
		}

		return false;

	}

}


