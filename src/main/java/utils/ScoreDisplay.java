package utils;

import controllers.ScoreController;
import entities.Score;
import entities.User;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ScoreDisplay extends Node {

	/***
	 * Method that returns the node of the score display
	 * @return
	 */
	public static Node scoreDisplay(User user) {

		//imports
		HBox hBoxScore = new HBox();

		VBox vBoxScore = new VBox();

		StyleGetter styleGetter = new StyleGetter();

		Score score = ScoreController.getUsersTotalScore(user.getId());

		Label labelScore = new Label("Score:");

		Label scoreNumber = new Label(" " + score.getValue());

		//styleGetter
		labelScore.getStylesheets().add(styleGetter.getStyle());
		scoreNumber.getStylesheets().add(styleGetter.getStyle());

		//style
		labelScore.getStyleClass().add("score");

		if(score.getValue() < 500) {
			scoreNumber.getStyleClass().add("score-low");
		} else {
			scoreNumber.getStyleClass().add("score-high");
		}


		hBoxScore.getChildren().addAll(labelScore, scoreNumber);
		hBoxScore.setAlignment(Pos.CENTER);

		vBoxScore.getChildren().add(hBoxScore);

		return vBoxScore;

	}
}
