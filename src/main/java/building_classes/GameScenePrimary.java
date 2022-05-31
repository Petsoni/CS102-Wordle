package building_classes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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

		StyleGetter styleGetter = new StyleGetter();

		Label gameName = GameName.labelCreate("WORDLE");
		gameName.setAlignment(Pos.TOP_CENTER);

		//positioning
		this.setTop(gameName);

		//GAME GRID
		this.maxWidth(Double.MAX_VALUE);
		this.setMaxHeight(Double.MAX_VALUE);
		this.setCenter(GameGridMaker.gameGrid());

		//style
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");

	}
}
