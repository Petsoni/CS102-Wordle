package building_classes;

import controllers.WordController;
import entities.User;
import entities.Word;
import exceptions.WordToLongException;
import exceptions.alerts.AlertUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.CharLimiter;
import utils.SceneSwitch;
import utils.StyleGetter;

public class NewWordScene extends GridPane {

	private Stage stage;

	public NewWordScene(Stage stage, User user) {

		this.stage = stage;

		//imports
		Image icon = new Image("wordle-game-icon.png");

		SceneSwitch sceneSwitch = new SceneSwitch();

		StyleGetter styleGetter = new StyleGetter();

		//ELEMENTS
		Label newWordTitleLabel = new Label("New Word");
		this.add(newWordTitleLabel, 0, 0, 2, 1);

		Label newWordLabel = new Label("Word:");
		this.add(newWordLabel, 0, 1);

		TextField newWordField = new TextField();
		newWordField.setPromptText("Type in your new word");
		this.add(newWordField, 1, 1);

		newWordField.setTextFormatter(new TextFormatter<>((change) -> {
			change.setText(change.getText().toUpperCase());
			return change;
		}));

		//BUTTONS
		Button addWordBtn = new Button("Add word");
		HBox hbLoginBtn = new HBox(10);
		hbLoginBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbLoginBtn.getChildren().add(addWordBtn);
		this.add(hbLoginBtn, 1, 4);

		Button backBtn = new Button("Play game");
		HBox hbBackBtn = new HBox(10);
		hbBackBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBackBtn.getChildren().add(backBtn);
		this.add(hbBackBtn, 0, 4);

		//GRIDING
		this.setAlignment(Pos.CENTER);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));

		//STYLE
		this.getStylesheets().add(styleGetter.getStyle());
		this.getStyleClass().add("paneBackground");

		newWordTitleLabel.getStyleClass().add("loginTitle");

		newWordField.getStyleClass().add("loginField");

		addWordBtn.setOnAction(e -> {

			try {

				boolean wordToLong = WordController.checkIfWordIsTooLongOrTooShort(newWordField.getText());

				if (wordToLong) {
					throw new WordToLongException("Word is too long");
				} else {

					Word word = new Word(newWordField.getText());
					WordController.save(word);
					AlertUtil.showAlert("Word added", "Your word has been added to the database", "",
							Alert.AlertType.CONFIRMATION);

				}

			} catch (WordToLongException exception) {
				AlertUtil.showAlert("Can't add word", "Your word is too long or too short", "The word " +
						"must be 5 characters long", Alert.AlertType.ERROR);
				exception.printStackTrace();
			}


		});

		backBtn.setOnAction(e -> {
			Scene scene = new Scene(new GameScenePrimary(this.stage, new User()), 1200, 700);
		});

	}

}
