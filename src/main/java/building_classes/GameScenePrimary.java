package building_classes;

import controllers.ScoreController;
import entities.User;
import exceptions.alerts.AlertUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.*;

public class GameScenePrimary extends BorderPane {

	private Stage stage;

	/***
	 * Method that returns the main pane for the game with all of its assets
	 * @return borderPane
	 */
	public GameScenePrimary(Stage stage, User user) {

		this.stage = stage;

		SetOnActionUtil setOnActionUtil = new SetOnActionUtil();

		User currentUser = user;

		System.out.println(currentUser.getId());

//		Score score = ScoreController.getLatestScoreForUser(currentUser.getId());

		System.out.println(ScoreController.getAllScoresForUser(currentUser.getId()));

		//IMPORTS
		VBox vBoxGrid = new VBox();
		VBox vBoxUsername = new VBox();

		Button newWordButton = new Button("Add New Word");

		Button exitButton = new Button("Exit");

		GameGridMaker gameGridMaker = new GameGridMaker();

		Label usernameLabel = new Label("Playing as: " + currentUser.getUsername());
		usernameLabel.getStyleClass().add("score");


		HBox hBoxGrid = new HBox();
		HBox hBoxButtons = new HBox();
		HBox hBoxUsername = new HBox();

		StyleGetter styleGetter = new StyleGetter();

		String answer = RandomWordSelector.getRandomWord();

		Label gameName = GameName.labelCreate("WORDLE");
		gameName.setAlignment(Pos.TOP_CENTER);

		//positioning
		this.setTop(gameName);
		this.setLeft(ScoreDisplay.scoreDisplay(currentUser));
		newWordButton.setFocusTraversable(false);

		//GAME GRID
		this.maxWidth(1000);
		this.maxHeight(600);
		this.setPadding(new Insets(25, 25, 25, 25));

		hBoxUsername.getChildren().add(usernameLabel);
		vBoxGrid.setAlignment(Pos.CENTER);
		vBoxUsername.setMaxSize(360, Double.MAX_VALUE);

		vBoxUsername.getChildren().add(hBoxUsername);
		vBoxGrid.setAlignment(Pos.CENTER);
		vBoxUsername.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		vBoxGrid.getChildren().addAll(gameGridMaker.gameGrid());
		vBoxGrid.setAlignment(Pos.TOP_CENTER);
		vBoxGrid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		hBoxGrid.getChildren().add(vBoxGrid);
		hBoxGrid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		hBoxGrid.setAlignment(Pos.CENTER);

		hBoxButtons.getChildren().addAll(newWordButton, exitButton);
		hBoxButtons.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		hBoxButtons.setAlignment(Pos.CENTER);
		hBoxButtons.setSpacing(20);

		this.setCenter(hBoxGrid);
		this.setBottom(hBoxButtons);
		this.setRight(vBoxUsername);

		var textFieldListByRow = gameGridMaker.getTextFieldListByRow();

		setOnActionUtil.setOnAction(textFieldListByRow, answer, user, stage);

		System.out.println(answer);

		System.out.println(currentUser.toString());

		newWordButton.setOnAction(e -> {
			Scene scene = new Scene(new NewWordScene(stage, currentUser), 500, 400);
			stage.setScene(scene);
			stage.setTitle("Add new word");
			stage.show();
		});

		newWordButton.getStyleClass().add("buttons");

		exitButton.setOnAction(e -> {
			AlertUtil.showAlert("Thank you for playing!", "Have a nice day!", "Goodbye!", Alert.AlertType.WARNING);
			stage.close();
		});

		exitButton.getStyleClass().add("buttons");

		//style
		this.stage.setResizable(false);
		this.stage.centerOnScreen();
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");


	}
}
