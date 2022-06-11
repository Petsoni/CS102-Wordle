package building_classes;

import controllers.ScoreController;
import entities.Score;
import entities.User;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.StyleGetter;

public class ScoreOverviewScene extends BorderPane {

	private Stage stage;


	public ScoreOverviewScene(Stage stage, User user) {

		this.stage = stage;

		//imports
		Image icon = new Image("wordle-game-icon.png");

		StyleGetter styleGetter = new StyleGetter();

		User currentUser = user;

		Score score = ScoreController.getUsersTotalScore(currentUser.getId());

		Label usernameDisplay = new Label("Username: " + currentUser.getUsername());

		Label scoreDisplay = new Label("Score for all games: " + score.getValue());

		VBox vbScoreUser = new VBox();

		HBox hbScoreUser = new HBox();

		usernameDisplay.getStyleClass().add("login-title");
		scoreDisplay.getStyleClass().add("login-title");

		//ELEMENTS
		vbScoreUser.getChildren().addAll(usernameDisplay, scoreDisplay);
		vbScoreUser.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		hbScoreUser.getChildren().addAll(vbScoreUser);
		hbScoreUser.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		this.setCenter(hbScoreUser);

		this.stage.setResizable(false);
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");


	}

}
