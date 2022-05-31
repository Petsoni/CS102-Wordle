package building_classes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.GameGridMaker;
import utils.StyleGetter;

public class GameScenePrimary extends BorderPane {

	private Stage stage;

	/***
	 * Method that returns the main pane for the game with all of its assets
	 * @return borderPane
	 */
	public GameScenePrimary(Stage stage) {

		this.stage = stage;

		VBox vBoxGrid = new VBox();

		HBox hBoxGrid = new HBox();

		StyleGetter styleGetter = new StyleGetter();

		Label gameName = GameName.labelCreate("WORDLE");
		gameName.setAlignment(Pos.TOP_CENTER);

		//positioning
		this.setTop(gameName);

		//GAME GRID
		this.maxWidth(1000);
		this.maxHeight(600);

		vBoxGrid.getChildren().add(GameGridMaker.gameGrid());
		vBoxGrid.setAlignment(Pos.TOP_CENTER);

		hBoxGrid.getChildren().add(vBoxGrid);
		hBoxGrid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		hBoxGrid.setAlignment(Pos.CENTER);

		this.setCenter(hBoxGrid);

		//style
		this.stage.setResizable(false);
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");

	}
}
