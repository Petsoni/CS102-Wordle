package utils;

import controllers.WordController;
import entities.User;
import exceptions.alerts.AlertUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/***
 * Class that is used for all the actions that are used in the game for player inputs
 */
public class SetOnActionUtil {

	/***
	 * Method that sets an action to a textField when the enter key is pressed and moves to the next
	 * textField
	 * @param textFieldList
	 */
	public static void setOnAction(List<List<TextField>> textFieldList, String answer, User user) {

		LetterChecker letterChecker = new LetterChecker();
		AtomicBoolean correctAnswer = new AtomicBoolean(false);

		int i;

		for (i = 0; i < textFieldList.size(); i++) {

			List<TextField> textFieldListForRow = textFieldList.get(i);

			int j;


			for (j = 0; j < textFieldListForRow.size(); j++) {

				TextField textField = textFieldListForRow.get(j);

				int finalJ = j;
				int finalI = i;

				textField.setOnKeyPressed(e -> {
					if (textField.getText().length() == 1) {

						if (finalJ == textFieldListForRow.size() - 1) {

							if (finalI == textFieldList.size() - 1) {

								textFieldList.get(0).get(0).requestFocus();

							} else {

								textField.setOnKeyPressed(e1 -> {

									if (e1.getCode().equals(KeyCode.ENTER)) {

										String playerInput = letterChecker.combineCharsToMakeAWord(
												textFieldListForRow);

										System.out.println(playerInput);

										boolean exists = WordController.checkIfWordExists(playerInput);

										if (!exists) {

											AlertUtil.showAlert("Non Existent Word",
													"The word " + playerInput + " does not exist in the" +
															" dictionary",
													"", Alert.AlertType.ERROR);

										} else {

											textFieldList.get(finalI + 1).forEach((textField1) -> {

												textField1.setDisable(false);
												letterChecker.checkGuess(textFieldListForRow, answer, user);

												correctAnswer.set(true);

											});

										}

										textFieldList.get(finalI + 1).get(0).requestFocus();

									}
								});
							}
						} else {
							textFieldListForRow.get(finalJ + 1).requestFocus();
						}

					} else if (e.getCode().equals(KeyCode.BACK_SPACE) && finalJ > 0) {
						textFieldListForRow.get(finalJ - 1).requestFocus();
						System.out.println("aaaaa");
					}

				});
				if (correctAnswer.get()) {
					break;
				}
			}
			if (correctAnswer.get()) {
				break;
			}
		}

	}
}