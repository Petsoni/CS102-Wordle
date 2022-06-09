package utils;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Locale;

public class LetterChecker {

	//method that combines the characters of a given word into a string
	public static String getWordAndCheckWithAnswer(List<List<TextField>> textFieldList, String answer) {

		String word = "";

		for (int i = 0; i < textFieldList.size(); i++) {

			List<TextField> textFieldListForRow = textFieldList.get(i);

			for (int j = 0; j < textFieldListForRow.size(); j++) {

				TextField textField = textFieldListForRow.get(j);

				word += textField.getText();

				word = word.toUpperCase();

			}
		}

		if (word.equals(answer)) {
			return "Correct";
		} else {
			return "Incorrect";
		}

	}


}
