package building_classes;

import controllers.UserController;
import entities.User;
import exceptions.alerts.AlertUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.FieldsEmptyCheck;
import utils.SceneSwitch;
import utils.StyleGetter;

public class UpdatePasswordScene extends GridPane {

	private Stage stage;

	public UpdatePasswordScene(Stage stage) {
		this.stage = stage;

		//IMPORTS
		Image icon = new Image("wordle-game-icon.png");

		StyleGetter styleGetter = new StyleGetter();

		//ELEMENTS
		Label updatePassword = new Label("Update Password");
		this.add(updatePassword, 0, 0, 2, 1);

		Label usernameLabel = new Label("Username:");
		this.add(usernameLabel, 0, 1);

		TextField usernameTextField = new TextField();
		usernameTextField.setPromptText("Username");
		this.add(usernameTextField, 1, 1);

		Label currentPasswordLabel = new Label("Current password:");
		this.add(currentPasswordLabel, 0, 2);

		PasswordField currentPasswordField = new PasswordField();
		currentPasswordField.setPromptText("Current password");
		this.add(currentPasswordField, 1, 2);

		Label newPasswordLabel = new Label("New password:");
		this.add(newPasswordLabel, 0, 3);

		PasswordField newPasswordField = new PasswordField();
		newPasswordField.setPromptText("New password");
		this.add(newPasswordField, 1, 3);

		Label confirmNewPasswordLabel = new Label("Confirm new password:");
		this.add(confirmNewPasswordLabel, 0, 4);

		PasswordField confirmNewPasswordField = new PasswordField();
		confirmNewPasswordField.setPromptText("Confirm new");
		this.add(confirmNewPasswordField, 1, 4);

		//GRIDING
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));

		//STYLE
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");

		updatePassword.getStyleClass().add("registerTitle");

		usernameLabel.getStyleClass().add("registerField");
		currentPasswordLabel.getStyleClass().add("registerField");
		newPasswordLabel.getStyleClass().add("registerField");
		confirmNewPasswordLabel.getStyleClass().add("registerField");

		usernameTextField.getStyleClass().add("registerField");
		currentPasswordField.getStyleClass().add("registerField");
		newPasswordField.getStyleClass().add("registerField");
		confirmNewPasswordField.getStyleClass().add("registerField");

		//BUTTONS
		Button updateButton = new Button("Update");
		HBox hbRegisterBtn = new HBox(10);
		hbRegisterBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbRegisterBtn.getChildren().add(updateButton);
		this.add(hbRegisterBtn, 1, 5);

		Button backBtn = new Button("Go back");
		HBox hbBackBtn = new HBox(10);
		hbBackBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBackBtn.getChildren().add(backBtn);
		this.add(hbBackBtn, 0, 5);

		updateButton.getStyleClass().add("buttons");
		backBtn.getStyleClass().add("buttons");

		updateButton.setOnAction(e -> {

			String username = usernameTextField.getText();
			String currentPassword = currentPasswordField.getText();
			String newPassword = newPasswordField.getText();
			String confirmNewPassword = confirmNewPasswordField.getText();

			if (!FieldsEmptyCheck.check(username, currentPassword, newPassword, confirmNewPassword)) {

				AlertUtil.showAlert("Fields are not filled", "Please fill in all fields", "",
						Alert.AlertType.ERROR);

			} else if (!newPassword.equals(confirmNewPassword)) {

				AlertUtil.showAlert("Passwords do not match", "New password and the confirmation password " +
						"do not match", "", Alert.AlertType.ERROR);

			} else {

				if (!UserController.checkUsername(username)) {
					AlertUtil.showAlert("Username does not exist",
							"The user with that username does not exist", "",
							Alert.AlertType.ERROR);
				} else {

					User user = UserController.getUserByUsername(username);

					if (!UserController.checkPassword(currentPassword)) {
						AlertUtil.showAlert("Wrong password", "The current password is wrong", "",
								Alert.AlertType.ERROR);
					} else {

						if (user.getPassword().equals(newPassword)) {
							AlertUtil.showAlert("Password is the same", "The new password can't be the same" +
											" as the old password",	"",
									Alert.AlertType.ERROR);
						} else {

							user.setPassword(newPassword);

							UserController.updateUserPassword(user);

							Scene scene = new Scene(new LoginScene(stage), 500, 400);
							stage.setScene(scene);
							stage.show();
						}
					}
				}
			}
		});

		backBtn.setOnAction(e -> {
			Scene scene = new Scene(new LoginScene(stage), 500, 400);
			stage.setScene(scene);
			stage.show();
		});

	}

}
