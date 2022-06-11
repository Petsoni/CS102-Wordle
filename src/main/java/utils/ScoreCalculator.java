package utils;

import entities.Score;
import javafx.scene.control.TextField;

import java.util.List;

public class ScoreCalculator {

	/***
	 * Method that calculates the score of the player by checking which row is completed
	 * @param textFieldsList, score
	 * @return
	 */
	public static Double calculateScore(List<TextField> textFieldsList, Score score) {

		Double calculatedScore = 0.0;

		for (int i = 0; i < textFieldsList.size(); i++) {

			TextField textField = textFieldsList.get(i);

			if (textField.getText().length() == 1) {

				calculatedScore += 50;

			} else if (textField.getText().length() > 1) {

				calculatedScore += 25;

			}
		}

		return calculatedScore;

	}
}