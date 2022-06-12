package building_classes;

import controllers.UserController;
import entities.Score;
import entities.User;
import exceptions.WrongUsernameOrPasswordException;
import exceptions.alerts.AlertUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.SceneSwitch;
import utils.StyleGetter;

public class LoginScene extends GridPane {

	private Stage stage;

	/***
	 * Method that creates a pane with a login form
	 * @return gridPane
	 */
	public LoginScene(Stage stage) {

		this.stage = stage;

		//imports
		Image icon = new Image("wordle-game-icon.png");

		SceneSwitch sceneSwitch = new SceneSwitch();

		StyleGetter styleGetter = new StyleGetter();

		//ELEMENTS
		Label loginText = new Label("Login");
		this.add(loginText, 0, 0, 2, 1);

		Label usernameLabel = new Label("Username:");
		this.add(usernameLabel, 0, 1);

		TextField userTextField = new TextField();
		userTextField.setPromptText("Username");
		this.add(userTextField, 1, 1);

		Label passwordLabel = new Label("Password:");
		this.add(passwordLabel, 0, 2);

		PasswordField pwField = new PasswordField();
		pwField.setPromptText("Password");
		this.add(pwField, 1, 2);

		//BUTTONS
		Button loginBtn = new Button("Login");
		HBox hbLoginBtn = new HBox(10);
		hbLoginBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbLoginBtn.getChildren().add(loginBtn);
		this.add(hbLoginBtn, 1, 4);

		Button registerBtn = new Button("Register");
		HBox hbRegisterBtn = new HBox(10);
		hbRegisterBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbRegisterBtn.getChildren().add(registerBtn);
		this.add(hbRegisterBtn, 0, 4);

		//GRIDING
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));
		this.stage.centerOnScreen();

		//STYLE
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");

		loginText.getStyleClass().add("loginTitle");

		userTextField.getStyleClass().add("loginField");
		pwField.getStyleClass().add("loginField");

		//ACTION FUNCTIONS
		loginBtn.setOnAction(e -> {

			try {

				boolean result = UserController.checkLoginDetails(userTextField.getText(),
						pwField.getText());

				if(!result){
					throw new WrongUsernameOrPasswordException("Wrong username or password!");
				}

				User currentUser = UserController.getUserByUsername(userTextField.getText());

				AlertUtil.showAlert("Login Successful",
						"Welcome " + currentUser.getUsername() + "!",
						"",
						Alert.AlertType.INFORMATION);

				Scene gameScene = new Scene(new GameScenePrimary(this.stage, currentUser), 1300, 700);
				stage.setScene(gameScene);
				stage.getIcons().add(icon);
				stage.show();


			} catch (WrongUsernameOrPasswordException exception) {
				AlertUtil.showAlert("Bad login", "Incorrect username or password", "",
						Alert.AlertType.ERROR);
				exception.printStackTrace();
			}

		});

		loginBtn.getStyleClass().add("buttons");

		registerBtn.setOnAction(e -> {
			Scene registerScene = new Scene(new RegisterScene(this.stage), 500, 400);
			stage.setScene(registerScene);
			stage.getIcons().add(icon);
			stage.show();
		});

		registerBtn.getStyleClass().add("buttons");
	}
}
