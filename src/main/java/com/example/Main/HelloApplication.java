package com.example.Main;

import building_classes.GameScenePrimary;
import building_classes.LoginScene;
import entities.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class HelloApplication extends Application {

	Image icon = new Image("wordle-game-icon.png");

	/***
	 * Main starting method that starts up the application
	 * @param stage
	 */
	@Override
	public void start(Stage stage) {

		Scene loginFormScene = new Scene(new LoginScene(stage), 500, 400);
		stage.setScene(loginFormScene);
		stage.getIcons().add(icon);
		stage.show();

	}

	public static void main(String[] args) {
		launch();
	}
}