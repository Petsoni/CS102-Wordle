package exceptions.alerts;

import javafx.scene.control.Alert;

public class AlertUtil {

	/***
	 * Method that takes in a message and displays an alert with the message
	 * @param title
	 * @param header
	 * @param content
	 * @param type
	 */
	public static void showAlert(String title, String header, String content, Alert.AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

}
