package com.example.cs102wordle;

import building_classes.GameScenePrimary;
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

		Scene loginFormScene = new Scene(new GameScenePrimary(stage), 1000, 800);
		stage.setScene(loginFormScene);
		stage.show();



	}

	public static void main(String[] args) {
		launch();
	}
}