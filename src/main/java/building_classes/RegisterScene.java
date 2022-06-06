package building_classes;

import controllers.UserController;
import entities.User;
import exceptions.UserAlreadyExistsException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.SceneSwitch;
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

		SceneSwitch sceneSwitch = new SceneSwitch();

		StyleGetter styleGetter = new StyleGetter();

		//ELEMENTS
		Label registerText = new Label("Register");
		this.add(registerText, 0, 0, 2, 1);

		Label nameLabel = new Label("Name:");
		this.add(nameLabel, 0, 1);

		TextField nameTextField = new TextField();
		nameTextField.setPromptText("Name");
		this.add(nameTextField, 1, 1);

		Label surnameLabel = new Label("Surname:");
		this.add(surnameLabel, 0, 2);

		TextField surnameTextField = new TextField();
		surnameTextField.setPromptText("Surname");
		this.add(surnameTextField, 1, 2);

		Label usernameLabel = new Label("Username:");
		this.add(usernameLabel, 0, 3);

		TextField usernameTextField = new TextField();
		usernameTextField.setPromptText("Username");
		this.add(usernameTextField, 1, 3);

		Label passwordLabel = new Label("Password:");
		this.add(passwordLabel, 0, 4);

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

		//ACTIONS
		registerBtn.setOnAction(e -> {
			String name = nameTextField.getText();
			String surname = surnameTextField.getText();
			String username = usernameTextField.getText();
			String password = passwordTextField.getText();

			boolean result = UserController.checkUsername(username);

			System.out.println(result);

			if (result) {
				throw new UserAlreadyExistsException("Username already exists");
			} else {

				User newUser = new User(name, surname, username, password);

				UserController.save(newUser);

				Scene scene = new Scene(new LoginScene(this.stage), 500, 400);
				stage.setScene(scene);
				stage.show();
			}
		});

	}
}
