package utils;

import entities.Score;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Locale;

public class LetterChecker {

	//method that combines the characters of a given word into a string
	public void checkGuess(List<TextField> textFieldList, String answer) {

		StyleGetter styleGetter = new StyleGetter();

		for (int i = 0; i < textFieldList.size(); i++) {

			TextField textField = textFieldList.get(i);

			String playerLetter = textField.getText();

			textField.getStylesheets().add(styleGetter.getStyle());

			if (playerLetter.equals(answer.substring(i, i + 1))) {

				textField.getStyleClass().add("field-green");

			} else if (answer.indexOf(playerLetter) > -1) {

				textField.getStyleClass().add("field-yellow");

			} else {

				textField.getStyleClass().add("square");

			}
		}
	}

}


