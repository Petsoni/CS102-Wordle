package utils;

public class FieldsEmptyCheck {

	/***
	 * Method that checks if a list of text fields are empty
	 * @param textFields
	 * @return boolean
	 */
	public static boolean check(String... textFields) {

		for (String textField : textFields) {

			if (textField.equals("")) {

				return false;
			}
		}

		return true;
	}
}
