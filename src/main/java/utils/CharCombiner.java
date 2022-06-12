package utils;

import javafx.scene.control.TextField;

import java.util.List;

public class CharCombiner {

	/***
	 * Method that combines the characters in a list of text fields to make a word
	 * @param textFieldList
	 * @return word
	 */
	public static String combineCharsToMakeAWord(List<TextField> textFieldList) {

		String word = "";

		for (int i = 0; i < textFieldList.size(); i++) {

			TextField textField = textFieldList.get(i);

			word += textField.getText();
		}

		return word;
	}
}
