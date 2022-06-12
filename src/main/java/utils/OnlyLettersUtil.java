package utils;

import javafx.scene.control.TextField;

public class OnlyLettersUtil {

	/***
	 * Method that checks if the limits the text field to accept only letters
	 * @param textField
	 */
	public static void allowOnlyLetters(TextField textField) {

		textField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("\\sa-zA-Z*")) {
				textField.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
			}
		});
	}
}
