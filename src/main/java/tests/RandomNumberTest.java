package tests;

import controllers.WordController;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class RandomNumberTest {

	@Test
	public void testRandNumber() {

		Random random = new Random();

		int allWordsListSize = WordController.getAllWords().size();

		int upperBound = allWordsListSize - 1 + 1;

		int finalNum = random.nextInt(upperBound);

		assertTrue(finalNum <= allWordsListSize);

	}

	@Test
	public void testRandNumberIsLower() {

		Random random = new Random();

		int allWordsListSize = WordController.getAllWords().size();

		int upperBound = allWordsListSize - 1 + 1;

		int finalNum = random.nextInt(upperBound);

		assertFalse(finalNum > allWordsListSize);

	}
}