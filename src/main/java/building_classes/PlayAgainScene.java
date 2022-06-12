package building_classes;

import entities.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.StyleGetter;

public class PlayAgainScene extends GridPane {

	private Stage stage;

	/***
	 * Method that creates the Play Again scene
	 * @param stage
	 * @param user
	 * @param word
	 */
	public PlayAgainScene(Stage stage, User user, String word) {

		this.stage = stage;

		//imports
		Image icon = new Image("wordle-game-icon.png");

		StyleGetter styleGetter = new StyleGetter();
		this.getStylesheets().add(styleGetter.getStyle());

		//ELEMENTS
		Label finishLabel = new Label("GAME OVER");
		this.add(finishLabel, 0, 0, 2, 1);

		Label messageLabel = new Label("Sorry " + user.getUsername() + "..." );
		this.add(messageLabel, 0, 1);

		Label messageLabelDescription = new Label("You didn't get the word " + word + " right...");
		this.add(messageLabelDescription, 0, 2);

		//BUTTONS
		Button playAgainBtn = new Button("Play again");

		Button exitBtn = new Button("Exit");

		HBox hbButtons = new HBox();

		playAgainBtn.getStyleClass().add("buttons");

		exitBtn.getStyleClass().add("buttons");

		finishLabel.getStyleClass().add("finish-text");

		messageLabel.getStyleClass().add("score-overview");

		messageLabelDescription.getStyleClass().add("score-overview");

		this.getStyleClass().add("paneBackground");
		this.setPadding(new Insets(25, 25, 25, 25));

		hbButtons.getChildren().addAll(playAgainBtn, exitBtn);
		hbButtons.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		hbButtons.setAlignment(Pos.CENTER);
		hbButtons.setPadding(new Insets(5, 5, 5, 5));
		hbButtons.setSpacing(20);

		this.add(hbButtons, 0, 4);

		this.stage.setTitle("GAME OVER");
		this.stage.getIcons().add(icon);
		this.stage.setResizable(false);
		this.stage.show();

		playAgainBtn.setOnAction(e -> {
			Scene scene = new Scene(new GameScenePrimary(stage, user), 1200, 700);
			stage.setScene(scene);
			stage.setTitle("Wordle");
			stage.show();
		});

		exitBtn.setOnAction(e -> {
			this.stage.close();
		});

		this.stage.centerOnScreen();
	}
}
