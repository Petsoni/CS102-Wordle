package tests;

import org.testng.annotations.Test;
import utils.FieldsEmptyCheck;

import static org.testng.Assert.*;

public class FieldsEmptyCheckTest {

	@Test
	public void testCheck() {

		String textField1 = "";

		FieldsEmptyCheck.check(textField1);

		assertFalse(FieldsEmptyCheck.check(textField1));

	}

	@Test
	public void testCheckIfHasLetters() {

		String textField1 = "This is a test";

		FieldsEmptyCheck.check(textField1);

		assertTrue(FieldsEmptyCheck.check(textField1));

	}
}