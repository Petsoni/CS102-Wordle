package building_classes;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.GameGridMaker;
import utils.SetOnActionUtil;
import utils.StyleGetter;

import java.util.List;

public class GameScenePrimary extends BorderPane {

	private Stage stage;

	/***
	 * Method that returns the main pane for the game with all of its assets
	 * @return borderPane
	 */
	public GameScenePrimary(Stage stage) {

		this.stage = stage;

		VBox vBoxGrid = new VBox();

		GameGridMaker gameGridMaker = new GameGridMaker();

		HBox hBoxGrid = new HBox();

		StyleGetter styleGetter = new StyleGetter();

		Label gameName = GameName.labelCreate("WORDLE");
		gameName.setAlignment(Pos.TOP_CENTER);

		//positioning
		this.setTop(gameName);

		//GAME GRID
		this.maxWidth(1000);
		this.maxHeight(600);

		vBoxGrid.getChildren().addAll(gameGridMaker.gameGrid());
		vBoxGrid.setAlignment(Pos.TOP_CENTER);

		hBoxGrid.getChildren().add(vBoxGrid);
		hBoxGrid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		hBoxGrid.setAlignment(Pos.CENTER);

		this.setCenter(hBoxGrid);

		var textFieldListByRow = gameGridMaker.getTextFieldListByRow();


		List<TextField> textFieldListForFirstRow = textFieldListByRow.get(0);

		SetOnActionUtil.setOnAction(textFieldListByRow);

//		textFieldListForFirstRow.get(0).setOnKeyTyped(e -> {
//
//			if (textFieldListForFirstRow.get(0).getText().length() == 1) {
//
//				textFieldListForFirstRow.get(1).requestFocus();
//
//			}
//
//		});
//
//		textFieldListForFirstRow.get(1).setOnKeyTyped(e -> {
//
//			if (textFieldListForFirstRow.get(1).getText().length() == 1) {
//
//				textFieldListForFirstRow.get(2).requestFocus();
//
//			}
//
//		});
//
//		textFieldListForFirstRow.get(2).setOnKeyTyped(e -> {
//
//			if (textFieldListForFirstRow.get(2).getText().length() == 1) {
//
//				textFieldListForFirstRow.get(3).requestFocus();
//
//			}
//
//		});
//
//		textFieldListForFirstRow.get(3).setOnKeyTyped(e -> {
//
//			if (textFieldListForFirstRow.get(3).getText().length() == 1) {
//
//				textFieldListForFirstRow.get(4).requestFocus();
//
//			}
//
//		});

		//put event listener on every text field in row
//		for (int i = 0; i < textFieldListByRow.size(); i++) {
//
//			List<TextField> textFieldListForRow = textFieldListByRow.get(i);
//
//			for (int j = 0; j < textFieldListForRow.size(); j++) {
//
//				TextField textField = textFieldListForRow.get(j);
//
//				int finalJ = j;
//				int finalI = i;
//				textField.setOnKeyTyped(e -> {
//
//					if (textField.getText().length() == 1) {
//
//						if (finalJ == textFieldListForRow.size() - 1) {
//
//							if (finalI == textFieldListByRow.size() - 1) {
//
//								textFieldListByRow.get(0).get(0).requestFocus();
//
//							} else {
//
//								textFieldListByRow.get(finalI + 1).get(0).requestFocus();
//
//							}
//
//						} else {
//
//							textFieldListForRow.get(finalJ + 1).requestFocus();
//
//						}
//
//					}
//
//				});
//
//			}
//
//		}

//		textFieldListForFirstRow.get(4).setOnKeyTyped(e -> {
//
//
//
//		});


		//style
		this.stage.setResizable(false);
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");


	}
}
