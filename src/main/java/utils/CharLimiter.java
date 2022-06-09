package utils;

import javafx.scene.control.TextField;

public class CharLimiter {

	/***
	 * Method that limits the number of characters that a TextField can accept
	 * @param textField
	 */
	public static void Limit(TextField textField, int limit) {

		textField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (textField.getText().length() > limit) {
				String s = textField.getText().substring(0, 1);
				textField.setText(s);
			}
		});
	}
}
