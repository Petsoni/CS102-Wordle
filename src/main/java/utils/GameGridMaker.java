package utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class GameGridMaker {

	private List<List<TextField>> textFieldListByRow = new ArrayList<>();

	public List<List<TextField>> getTextFieldListByRow() {
		return textFieldListByRow;
	}

	/***
	 * Method that makes the primary game grid
	 * @return gameGrid
	 */
	public GridPane gameGrid() {

		GridPane gameGrid = new GridPane();

		StyleGetter styleGetter = new StyleGetter();

		gameGrid.getStyleClass().add(styleGetter.getStyle());

		//TODO: FIGURE OUT HOW TO CHANGE FOCUS ON FULL TEXT FIELD
		for (int row = 0; row < 6; row++) {

			List<TextField> textFieldListForRow = new ArrayList<>();

			for (int col = 0; col < 5; col++) {

				TextField charSquare = new TextField();

				if (row != 0) {
					charSquare.setDisable(true);
				}

				charSquare.setMaxSize(60, 40);
				charSquare.setAlignment(Pos.CENTER);

				GridPane.setRowIndex(charSquare, row);
				GridPane.setColumnIndex(charSquare, col);

				GridPane.setMargin(charSquare, new Insets(7));

				gameGrid.add(charSquare, col, row);

				charSquare.getStyleClass().add("square");

				charSquare.setPadding(new Insets(5));

				//MAKES ALL LETTERS UPPER CASE
				charSquare.setTextFormatter(new TextFormatter<>((change) -> {
					change.setText(change.getText().toUpperCase());
					return change;
				}));

				CharLimiter.Limit(charSquare, 1);

				textFieldListForRow.add(charSquare);

			}

			textFieldListByRow.add(textFieldListForRow);

		}

		return gameGrid;
	}
}
