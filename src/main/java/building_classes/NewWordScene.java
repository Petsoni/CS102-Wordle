package building_classes;

import controllers.WordController;
import entities.User;
import entities.Word;
import exceptions.WordAlreadyExistsException;
import exceptions.WordToLongException;
import exceptions.alerts.AlertUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.StyleGetter;
import utils.WordLengthCheck;

public class NewWordScene extends GridPane {

	private Stage stage;

	/***
	 * Method that creates a New Word scene.
	 * @param stage
	 * @param user
	 */
	public NewWordScene(Stage stage, User user) {

		this.stage = stage;

		//imports
		StyleGetter styleGetter = new StyleGetter();

		//ELEMENTS
		Label newWordTitleLabel = new Label("New Word");
		this.add(newWordTitleLabel, 0, 1, 2, 1);

		Label newWordDescriptionLabel = new Label("The word you are about to add to the database needs to " +
				"be 5 characters long and cannot already exist in the database!");
		this.add(newWordDescriptionLabel, 0, 5, 3, 2);
		newWordDescriptionLabel.setMaxWidth(250);
		newWordDescriptionLabel.setWrapText(true);
		newWordDescriptionLabel.getStyleClass().add("new-word-desc");

		Label newWordLabel = new Label("Word:");
		this.add(newWordLabel, 0, 3);
		newWordLabel.getStyleClass().add("all-labels");

		TextField newWordField = new TextField();
		newWordField.setPromptText("Type in your new word");
		this.add(newWordField, 1, 3);

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

		newWordField.setOnKeyPressed(e -> {
			if (e.getCode().equals(javafx.scene.input.KeyCode.ENTER)) {
				addWordBtn.fire();
			}
		});

		addWordBtn.getStyleClass().add("buttons");
		backBtn.getStyleClass().add("buttons");

		addWordBtn.setOnAction(e -> {

			try {

				boolean wordToLong = WordLengthCheck.checkIfWordIsTooLongOrTooShort(newWordField.getText());
				boolean wordAlreadyExists = WordController.checkIfWordExists(newWordField.getText());

				if (wordToLong) {

					throw new WordToLongException("Word is too long");

				} else if (wordAlreadyExists) {

					throw new WordToLongException("Word already exists");

				} else {

					Word word = new Word(newWordField.getText());
					WordController.save(word);
					AlertUtil.showAlert("Word added", "Your word has been added to the database", "",
							Alert.AlertType.CONFIRMATION);

				}

			} catch (WordToLongException | WordAlreadyExistsException exception) {
				AlertUtil.showAlert("Can't add word", newWordField.getText(),
						"The word is too long, too short or it's already in the database!",
						Alert.AlertType.ERROR);
				exception.printStackTrace();
			}


		});

		backBtn.setOnAction(e -> {
			Scene scene = new Scene(new GameScenePrimary(this.stage, user), 1200, 700);
			stage.setScene(scene);
			stage.setTitle("Wordle");
			stage.show();
		});

		this.stage.centerOnScreen();


	}

}
