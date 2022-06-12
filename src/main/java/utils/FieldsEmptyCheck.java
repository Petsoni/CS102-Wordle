package utils;

import exceptions.alerts.AlertUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FieldsEmptyCheck {

	public static boolean check(String... textFields) {

		for (String textField : textFields) {

			if (textField.equals("")) {

				return false;
			}
		}

		return true;
	}
}
