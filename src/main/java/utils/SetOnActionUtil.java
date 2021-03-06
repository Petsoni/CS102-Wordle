package utils;

import building_classes.FinishScene;
import building_classes.PlayAgainScene;
import controllers.ScoreController;
import controllers.WordController;
import entities.Score;
import entities.User;
import exceptions.NonExistentWordException;
import exceptions.alerts.AlertUtil;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.List;

/***
 * Class that is used for all the actions that are used in the game for player inputs
 */
public class SetOnActionUtil {

	private Stage stage;

	/***
	 * Method that sets an action to a textField when the enter key is pressed and moves to the next
	 * textField
	 * @param textFieldList
	 */
	public void setOnAction(List<List<TextField>> textFieldList, String answer, User user,
							Stage stage) {

		LetterChecker letterChecker = new LetterChecker();

		this.stage = stage;

		int i;

		// for each row
		for (i = 0; i < textFieldList.size(); i++) {

			List<TextField> textFieldListForRow = textFieldList.get(i);

			int j;

			// for each textField in the row
			for (j = 0; j < textFieldListForRow.size(); j++) {

				TextField textField = textFieldListForRow.get(j);

				int finalJ = j;
				int finalI = i;

				OnlyLettersUtil.allowOnlyLetters(textField);

				textField.setOnKeyPressed(e -> {

					//if textfield is not empty
					if (textField.getText().length() == 1) {

						//if the textfield is the last in the row
						if (finalJ == textFieldListForRow.size() - 1) {

							//if the textfield is the last in the row and the last in the list
							if (finalI == textFieldList.size() - 1) {

								Scene scene = new Scene(
										new PlayAgainScene(stage, user, answer),
										450, 300);
								stage.setScene(scene);
								stage.show();

							} else {

								textField.setOnKeyPressed(e1 -> {

									if (e1.getCode().equals(KeyCode.ENTER)) {

										String playerInput = CharCombiner.combineCharsToMakeAWord(
												textFieldListForRow);

										try {

											boolean exists = WordController.checkIfWordExists(playerInput);

											if (!exists) {

												throw new NonExistentWordException("Word is non-existent");

											} else {

//												//sets the last textfields to be non-editable
												textFieldList.get(finalI).forEach((textField1) -> {

													textField1.setEditable(false);

												});

												//goes to the next row of textfields
												textFieldList.get(finalI + 1).forEach((textField1) -> {

													textField1.setDisable(false);

												});

												//checking the player input against the answer
												boolean guessCheck =
														letterChecker.checkGuess(textFieldListForRow,
																answer, user, stage);

												if (guessCheck) {

													Score score = new Score();

													double value = 0;

													//enhanced switch statement that sets the score based
													// on which row the player guess is
													value = switch (finalI) {
														case 0 -> 1000;
														case 1 -> 750;
														case 2 -> 500;
														case 3 -> 250;
														case 4 -> 100;
														case 5 -> 50;
														default -> value;
													};

													score.setValue(value);
													score.setUser(user);

													ScoreController.save(score);

													Scene scene = new Scene(
															new FinishScene(stage, user, answer),
															450, 300);
													stage.setScene(scene);
													stage.show();

												}

												//if the player input is not the answer then the next row of textfields
												//is enabled
												if (!guessCheck) {
													textFieldList.get(finalI + 1).get(0).requestFocus();
												}

											}
										} catch (NonExistentWordException exception) {

											AlertUtil.showAlert("Non Existent Word",
													"The word " + playerInput + " does not exist in the" +
															" dictionary",
													"", Alert.AlertType.ERROR);

											exception.printStackTrace();

										}
									}
								});
							}
						} else {
							//requests focus on the next textfield in the row
							textFieldListForRow.get(finalJ + 1).requestFocus();
						}

					} else if (e.getCode().equals(KeyCode.BACK_SPACE) && finalJ > 0) {
						textFieldListForRow.get(finalJ - 1).requestFocus();
					}

				});
			}
		}

	}

}