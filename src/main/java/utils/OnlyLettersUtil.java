package utils;

import javafx.scene.control.TextField;

public class OnlyLettersUtil {

	public static void allowOnlyLetters(TextField textField) {

		textField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("\\sa-zA-Z*")) {
				textField.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
			}
		});
	}
}
