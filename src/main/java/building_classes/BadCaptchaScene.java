package building_classes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import utils.StyleGetter;

public class BadCaptchaScene extends GridPane {

	private Stage stage;

	/***
	 * Method that creates a pane with a finish scene
	 * @return gridPane
	 */
	public BadCaptchaScene(Stage stage) {

		this.stage = stage;

		//imports
		Image icon = new Image("wordle-game-icon.png");

		StyleGetter styleGetter = new StyleGetter();
		this.getStylesheets().add(styleGetter.getStyle());

		//ELEMENTS
		Label badCaptchaTitleLabel = new Label("BAD CAPTCHA");
		this.add(badCaptchaTitleLabel, 0, 0, 2, 1);

		Label badCaptchaDescription = new Label("The captcha you entered is incorrect !");
		this.add(badCaptchaDescription, 0, 2);

		//BUTTONS
		Button tryAgainBtn = new Button("Try again");

		tryAgainBtn.getStyleClass().add("buttons");

		badCaptchaTitleLabel.getStyleClass().add("captcha-title");

		badCaptchaDescription.getStyleClass().add("score-overview");

		this.getStyleClass().add("paneBackground");
		this.setPadding(new Insets(25, 25, 25, 25));

		HBox hbButtons = new HBox();

		hbButtons.getChildren().addAll(tryAgainBtn);
		hbButtons.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		hbButtons.setAlignment(Pos.CENTER);
		hbButtons.setSpacing(20);

		this.add(hbButtons, 0, 4);

		this.stage.setTitle("Congratulations!");
		this.stage.getIcons().add(icon);
		this.stage.setResizable(false);
		this.stage.show();

		tryAgainBtn.setOnAction(e -> {
			Scene scene = new Scene(new DeleteAccountScene(stage), 500, 400);
			stage.setScene(scene);
			stage.setTitle("Wordle");
			stage.show();
		});

		this.stage.centerOnScreen();

	}
}
