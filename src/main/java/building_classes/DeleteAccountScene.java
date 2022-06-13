package building_classes;

import controllers.UserController;
import entities.User;
import exceptions.alerts.AlertUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.FieldsEmptyCheck;
import utils.RandomWordSelector;
import utils.StyleGetter;

public class DeleteAccountScene extends GridPane {

	private Stage stage;

	/***
	 * Method that creates a pane with an update password form
	 * @return gridPane
	 */
	public DeleteAccountScene(Stage stage) {
		this.stage = stage;

		//IMPORTS
		StyleGetter styleGetter = new StyleGetter();

		//ELEMENTS
		Label deleteAccountLabel = new Label("Delete Account");
		this.add(deleteAccountLabel, 0, 0, 2, 1);

		Label usernameLabel = new Label("Username:");
		this.add(usernameLabel, 0, 1);
		usernameLabel.getStyleClass().add("all-labels");

		TextField usernameTextField = new TextField();
		usernameTextField.setPromptText("Username");
		this.add(usernameTextField, 1, 1);

		Label passwordLabel = new Label("Password:");
		this.add(passwordLabel, 0, 2);
		passwordLabel.getStyleClass().add("all-labels");

		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Password");
		this.add(passwordField, 1, 2);

		Label captchaLabel = new Label("Captcha:");
		this.add(captchaLabel, 0, 3);
		captchaLabel.getStyleClass().add("all-labels");

		PasswordField captchaField = new PasswordField();
		captchaField.setPromptText("Enter the word to your right");
		this.add(captchaField, 1, 3);

		Label captchaWord = new Label(RandomWordSelector.getRandomWord());
		this.add(captchaWord, 4, 3);
		captchaWord.getStyleClass().add("captcha");

		//GRIDING
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));

		//STYLE
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");

		deleteAccountLabel.getStyleClass().add("registerTitle");

		usernameLabel.getStyleClass().add("registerField");
		passwordLabel.getStyleClass().add("registerField");
		captchaLabel.getStyleClass().add("registerField");

		usernameTextField.getStyleClass().add("registerField");
		passwordField.getStyleClass().add("registerField");
		captchaField.getStyleClass().add("registerField");
		captchaLabel.getStyleClass().add("registerField");

		//BUTTONS
		Button deleteAccountBtn = new Button("Delete account");
		HBox hbDeleteBtn = new HBox(10);
		hbDeleteBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbDeleteBtn.getChildren().add(deleteAccountBtn);
		this.add(hbDeleteBtn, 1, 5);

		Button backBtn = new Button("Go back");
		HBox hbBackBtn = new HBox(10);
		hbBackBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBackBtn.getChildren().add(backBtn);
		this.add(hbBackBtn, 0, 5);

		deleteAccountBtn.getStyleClass().add("delete");
		backBtn.getStyleClass().add("buttons");

		captchaField.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.ENTER)) {
				deleteAccountBtn.fire();
			}
		});

		deleteAccountBtn.setOnAction(e -> {

			String username = usernameTextField.getText();
			String password = passwordField.getText();
			String captcha = captchaField.getText();

			if(!FieldsEmptyCheck.check(username, password, captcha)) {

				AlertUtil.showAlert("Incorrect user details", "Please fill in all fields",
						"Please fill in all fields", Alert.AlertType.ERROR);

			} else if(!captcha.equals(captchaWord.getText())) {

				Scene scene = new Scene(new BadCaptchaScene(stage), 450, 200);
				stage.setScene(scene);
				stage.show();

			} else {

				if(UserController.getUserByUsername(username) == null) {

					AlertUtil.showAlert("User not found", "User does not exist",
							"", Alert.AlertType.ERROR);

				} else {

					User user = UserController.getUserByUsername(username);

					if (!UserController.checkLoginDetails(username, password)) {

						AlertUtil.showAlert("Incorrect user details", "Please enter the correct user details",
								"", Alert.AlertType.ERROR);

					} else {

						UserController.delete(user);

						AlertUtil.showAlert("Account deleted", "Account deleted successfully",
								"Your account has been deleted", Alert.AlertType.INFORMATION);

						Scene scene = new Scene(new LoginScene(stage), 500, 400);
						stage.setScene(scene);
						stage.setTitle("Login");
						stage.show();

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
