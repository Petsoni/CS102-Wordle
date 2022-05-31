package utils;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

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

				gameGrid.add(rec, row, col);

				rec.getStyleClass().add("square");

				CharLimiter.Limit(rec);

				rec.setOnAction(e -> {
					rec.requestFocus();
				});

			}
		}

		return gameGrid;
	}
}
