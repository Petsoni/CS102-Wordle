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

				value += 20;

			} else {

				textField.getStyleClass().add("square");

			}
		}

		if (count == 5) {

			Scene scene = new Scene(new FinishScene(stage, user, answer), 450, 300);
			stage.setScene(scene);
			stage.show();

			value += 75;

			score.setValue(value);

			ScoreController.save(score);

			System.out.println(score.getValue());
			System.out.println(score.getUser());

			return true;
		}

		return false;

	}

}


