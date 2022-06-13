package utils;

import exceptions.alerts.AlertUtil;
import javafx.scene.control.Alert;

public class RegisterFormFieldCheck {

	public static boolean checkFileds(String username, String password) {

		if (username.length() < 5) {
			AlertUtil.showAlert("Incorrect user details", "Username is too short",
					"Your username has to be at least 5 characters long and",
					Alert.AlertType.ERROR);
			return false;
		} else if (password.length() < 8) {
			AlertUtil.showAlert("Incorrect user details", "Password is too short",
					"Your password " +
							"needs to be at least 8 characters long",
					Alert.AlertType.ERROR);
			return false;
		} else
			return true;


	}

}
