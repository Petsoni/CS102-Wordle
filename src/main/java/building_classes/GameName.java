package building_classes;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import utils.StyleGetter;

public class GameName {

	/***
	 * Method that will create the main header title ("WORDLE") in the primary pane
	 * @param name
	 * @return label
	 */
	public static Label labelCreate(String name) {

		Label label = new Label(name);

		StyleGetter styleGetter = new StyleGetter();

		label.getStylesheets().add(styleGetter.getStyle());

		label.getStyleClass().add("header");

		label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

		BorderPane.setMargin(label, new Insets(5));

		return label;

	}
}
