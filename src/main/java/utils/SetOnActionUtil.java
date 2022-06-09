package utils;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.util.List;

public class SetOnActionUtil {

	/***
	 * Method that sets an action to a textField when the enter key is pressed and moves to the next
	 * textField
	 * @param textFieldList
	 */
	public static void setOnAction(List<List<TextField>> textFieldList, String answer) {

		LetterChecker letterChecker = new LetterChecker();

		for (int i = 0; i < textFieldList.size(); i++) {

			List<TextField> textFieldListForRow = textFieldList.get(i);
			int j;
			for (j = 0; j < textFieldListForRow.size(); j++) {

				TextField textField = textFieldListForRow.get(j);

				int finalJ = j;
				int finalI = i;

				textField.setOnKeyTyped(e -> {
					if (textField.getText().length() == 1) {

						if (finalJ == textFieldListForRow.size() - 1) {

							if (finalI == textFieldList.size() - 1) {

								textFieldList.get(0).get(0).requestFocus();

							} else {

								textField.setOnKeyPressed(e1 -> {

									if (e1.getCode().equals(KeyCode.ENTER)) {

										textFieldList.get(finalI + 1).forEach((textField1) -> {
											textField1.setDisable(false);
											letterChecker.checkGuess(textFieldList, answer);
										});

										textFieldList.get(finalI + 1).get(0).requestFocus();
									}
								});
							}
						} else {
							textFieldListForRow.get(finalJ + 1).requestFocus();
						}
					}
				});
			}

		}
	}
}
