package com.example.cs102wordle;

import building_classes.GameScenePrimary;
import building_classes.LoginScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

	/***
	 * Main starting method that starts up the application
	 * @param stage
	 */
	@Override
	public void start(Stage stage) {

		Scene loginFormScene = new Scene(new LoginScene(stage), 500, 400);
		stage.setScene(loginFormScene);
		stage.show();



	}

	public static void main(String[] args) {
		launch();
	}
}