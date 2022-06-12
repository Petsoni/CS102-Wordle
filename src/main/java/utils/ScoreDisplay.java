package utils;

import controllers.ScoreController;
import entities.Score;
import entities.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class ScoreDisplay extends Node {

	/***
	 * Method that returns the node of the score display
	 * @return
	 */
	public static Node scoreDisplay(User user) {

		//imports
		HBox hBoxScoreTable = new HBox();

		HBox hBoxCurrentScore = new HBox();

		VBox vBoxScore = new VBox();

		Score score = ScoreController.getUsersTotalScore(user.getId());

		StyleGetter styleGetter = new StyleGetter();

//		Score score = ScoreController.getUsersTotalScore(user.getId());

		TableView<Score> tableView = new TableView<>();

		ObservableList<Score> data = FXCollections.observableArrayList(
				ScoreController.getAllScoresForUser(user.getId()));

		TableColumn<Score, Double> scoreValues = new TableColumn<>("Scores");

		tableView.setEditable(false);

		scoreValues.setMinWidth(225);
		scoreValues.setCellValueFactory(new PropertyValueFactory<>("value"));

		Label labelScore = new Label("Total score:");

		Label scoreNumber = new Label(" " + score.getValue());

		//styleGetter
		labelScore.getStylesheets().add(styleGetter.getStyle());
		scoreNumber.getStylesheets().add(styleGetter.getStyle());

		//style
		labelScore.getStyleClass().add("score");
		scoreNumber.getStyleClass().add("score");

		if (score.getValue() < 500) {
			scoreNumber.getStyleClass().add("score-low");
		} else {
			scoreNumber.getStyleClass().add("score-high");
		}


		tableView.setItems(data);

		tableView.getStyleClass().add("score-table");

		tableView.getColumns().add(scoreValues);

		hBoxScoreTable.getChildren().addAll(tableView);
		hBoxScoreTable.setAlignment(Pos.CENTER);

		hBoxCurrentScore.getChildren().addAll(labelScore, scoreNumber);
		hBoxCurrentScore.setAlignment(Pos.CENTER);

		vBoxScore.getChildren().addAll(hBoxScoreTable, hBoxCurrentScore);

		return vBoxScore;

	}
}
