package building_classes;

import controllers.ScoreController;
import entities.Score;
import entities.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.*;

import java.util.concurrent.atomic.AtomicBoolean;

public class GameScenePrimary extends BorderPane {

	private Stage stage;

	/***
	 * Method that returns the main pane for the game with all of its assets
	 * @return borderPane
	 */
	public GameScenePrimary(Stage stage, User user) {

		this.stage = stage;

		User currentUser = user;

		System.out.println(currentUser.getId());

		Score score = ScoreController.getScoreForUser(currentUser.getId());

		//IMPORTS
		VBox vBoxGrid = new VBox();

		Button newWordButton = new Button("Add New Word");

		GameGridMaker gameGridMaker = new GameGridMaker();

		Label usernameLabel = new Label("Playing as: " + currentUser.getUsername());
		usernameLabel.getStyleClass().add("score");

		HBox hBoxGrid = new HBox();

		StyleGetter styleGetter = new StyleGetter();

		String answer = RandomWordSelector.getRandomWord();

		Label gameName = GameName.labelCreate("WORDLE");
		gameName.setAlignment(Pos.TOP_CENTER);

		//positioning
		this.setTop(gameName);
		this.setLeft(ScoreDisplay.scoreDisplay(score));
		newWordButton.setFocusTraversable(false);

		//GAME GRID
		this.maxWidth(1000);
		this.maxHeight(600);

		vBoxGrid.getChildren().addAll(gameGridMaker.gameGrid());
		vBoxGrid.setAlignment(Pos.TOP_CENTER);
		vBoxGrid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		hBoxGrid.getChildren().add(vBoxGrid);
		hBoxGrid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		hBoxGrid.setAlignment(Pos.CENTER);

		this.setCenter(hBoxGrid);
		this.setBottom(newWordButton);
		this.setRight(usernameLabel);

		var textFieldListByRow = gameGridMaker.getTextFieldListByRow();

		SetOnActionUtil.setOnAction(textFieldListByRow, answer, user);

		System.out.println(answer);

		System.out.println(currentUser.toString());

		newWordButton.setOnAction(e -> {
			Scene scene = new Scene(new NewWordScene(stage, new User()), 500, 400);
			stage.setScene(scene);
			stage.show();
		});

		//style
		this.stage.setResizable(false);
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");


	}
}
