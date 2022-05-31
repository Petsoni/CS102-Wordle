package utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GameGridMaker {

	/***
	 * Method that makes the primary game grid
	 * @return gameGrid
	 */
	public static GridPane gameGrid() {

		GridPane gameGrid = new GridPane();

		StyleGetter styleGetter = new StyleGetter();

		gameGrid.getStyleClass().add(styleGetter.getStyle());

		//TODO: FIGURE OUT HOW TO CHANGE FOCUS ON FULL TEXT FIELD
		for (int col = 0; col < 6; col++) {
			for (int row = 0; row < 5; row++) {

				TextField rec = new TextField();

				rec.setMaxSize(60, 40);
				rec.setAlignment(Pos.CENTER);

				GridPane.setRowIndex(rec, col);
				GridPane.setColumnIndex(rec, row);

				GridPane.setMargin(rec, new Insets(7));

				gameGrid.add(rec, row, col);

				rec.getStyleClass().add("square");

				rec.setPadding(new Insets(5));

				//MAKES ALL LETTERS UPPER CASE
				rec.setTextFormatter(new TextFormatter<>((change) -> {
					change.setText(change.getText().toUpperCase());
					return change;
				}));

				rec.setBackground(new Background(new BackgroundFill(Color.DARKGREY, new CornerRadii(5),
						Insets.EMPTY)));

				CharLimiter.Limit(rec);

			}

		}


		return gameGrid;
	}
}
