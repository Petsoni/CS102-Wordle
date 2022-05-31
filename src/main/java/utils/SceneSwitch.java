package utils;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitch {

	/***
	 * Method that allows to switch between given scenes
	 * @param scene
	 */
	public void switchScenes(Stage currentStage, Scene scene) {
		currentStage.setScene(scene);
	}
}
