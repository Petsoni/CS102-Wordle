package exceptions.alerts;

import javafx.scene.control.Alert;

public class AlertUtil {

	public static void showAlert(String title, String header, String content, Alert.AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

}
