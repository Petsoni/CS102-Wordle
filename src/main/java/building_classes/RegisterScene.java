package building_classes;

import controllers.UserController;
import entities.User;
import exceptions.UserAlreadyExistsException;
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
import utils.RegisterFormFieldCheck;
import utils.StyleGetter;

public class RegisterScene extends GridPane {

	private Stage stage;

	/***
	 * Method that creates a pane with a register form
	 * @return gridPane
	 */

	public RegisterScene(Stage stage) {

		this.stage = stage;

		//IMPORTS
		Image icon = new Image("wordle-game-icon.png");

		StyleGetter styleGetter = new StyleGetter();

		//ELEMENTS
		Label registerText = new Label("Register");
		this.add(registerText, 0, 0, 2, 1);

		Label nameLabel = new Label("Name:");
		this.add(nameLabel, 0, 1);
		nameLabel.getStyleClass().add("all-labels");

		TextField nameTextField = new TextField();
		nameTextField.setPromptText("Name");
		this.add(nameTextField, 1, 1);

		Label surnameLabel = new Label("Surname:");
		this.add(surnameLabel, 0, 2);
		surnameLabel.getStyleClass().add("all-labels");

		TextField surnameTextField = new TextField();
		surnameTextField.setPromptText("Surname");
		this.add(surnameTextField, 1, 2);

		Label usernameLabel = new Label("Username:");
		this.add(usernameLabel, 0, 3);
		usernameLabel.getStyleClass().add("all-labels");

		TextField usernameTextField = new TextField();
		usernameTextField.setPromptText("Username");
		this.add(usernameTextField, 1, 3);

		Label passwordLabel = new Label("Password:");
		this.add(passwordLabel, 0, 4);
		passwordLabel.getStyleClass().add("all-labels");

		PasswordField passwordTextField = new PasswordField();
		passwordTextField.setPromptText("Password");
		this.add(passwordTextField, 1, 4);

		//GRIDING
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));

		//STYLE
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");

		registerText.getStyleClass().add("registerTitle");

		nameTextField.getStyleClass().add("registerField");
		surnameTextField.getStyleClass().add("registerField");
		usernameTextField.getStyleClass().add("registerField");
		passwordTextField.getStyleClass().add("registerField");

		//BUTTONS
		Button registerBtn = new Button("Register");
		HBox hbRegisterBtn = new HBox(10);
		hbRegisterBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbRegisterBtn.getChildren().add(registerBtn);
		this.add(hbRegisterBtn, 1, 5);

		Button backBtn = new Button("Go back");
		HBox hbBackBtn = new HBox(10);
		hbBackBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBackBtn.getChildren().add(backBtn);
		this.add(hbBackBtn, 0, 5);

		//ACTIONS
		passwordTextField.setOnKeyPressed(e -> {
			if (e.getCode().equals(javafx.scene.input.KeyCode.ENTER)) {
				registerBtn.fire();
			}
		});

		registerBtn.setOnAction(e -> {
			String name = nameTextField.getText();
			String surname = surnameTextField.getText();
			String username = usernameTextField.getText();
			String password = passwordTextField.getText();

			if (!FieldsEmptyCheck.check(name, surname, username, password)) {

				AlertUtil.showAlert("Fields are not filled", "Please fill in all fields", "",
						Alert.AlertType.ERROR);

			} else if (!RegisterFormFieldCheck.checkFileds(username, password)) {

				AlertUtil.showAlert("Incorrect user details", "Inputs are not eligible", "Please " +
								"enter your details according to the specification",
						Alert.AlertType.ERROR);

			} else {

				try {

					boolean result = UserController.checkUsername(username);

					if (result) {
						throw new UserAlreadyExistsException("Username already exists");
					} else {


						User newUser = new User(name, surname, username, password);

						UserController.save(newUser);

						AlertUtil.showAlert("Success", "Successful registration",
								"User registered successfully",
								Alert.AlertType.INFORMATION);

						Scene scene = new Scene(new LoginScene(this.stage), 500, 400);
						stage.setScene(scene);
						stage.show();
					}

				} catch (UserAlreadyExistsException exception) {
					AlertUtil.showAlert("Username already exists", "Username already exists",
							"Please choose " +
									"another username", Alert.AlertType.ERROR);
					exception.printStackTrace();
				}
			}
		});

		registerBtn.getStyleClass().

				add("buttons");

		backBtn.setOnAction(e ->

		{
			Scene scene = new Scene(new LoginScene(stage), 500, 400);
			stage.setScene(scene);
			stage.show();
		});

		backBtn.getStyleClass().

				add("buttons");

		this.stage.centerOnScreen();
		this.stage.setResizable(false);

	}
}
