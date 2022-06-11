package building_classes;

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

public class FinishScene {



	/***
	 * Method that creates a pane with a login form
	 * @return gridPane
	 */
	public GridPane FinishScene() {



		GridPane gridPane = new GridPane();

		//imports
		Image icon = new Image("wordle-game-icon.png");

		SceneSwitch sceneSwitch = new SceneSwitch();

		StyleGetter styleGetter = new StyleGetter();

		//ELEMENTS
		Label finishText = new Label("YOU GOT IT RIGHT");
		gridPane.add(finishText, 0, 0, 2, 1);

		Label usernameLabel = new Label("Congratulations:");
		gridPane.add(usernameLabel, 0, 1);

		//BUTTONS
		Button playAgainBtn = new Button("Play again");
		HBox hbPlayAgainBtn = new HBox(10);
		hbPlayAgainBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbPlayAgainBtn.getChildren().add(playAgainBtn);
		gridPane.add(hbPlayAgainBtn, 1, 4);

		Button exitBtn = new Button("Exit");
		HBox hbExitBtn = new HBox(10);
		hbExitBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbExitBtn.getChildren().add(exitBtn);
		gridPane.add(hbExitBtn, 0, 4);

		Stage stage = new Stage();

		Scene scene = new Scene(gridPane, 300, 250);
		stage.setScene(scene);
		stage.setTitle("SCREEN");
		stage.getIcons().add(icon);
		stage.show();

		return gridPane;
	}
}
