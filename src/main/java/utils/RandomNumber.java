package utils;

import controllers.WordController;

import java.util.Random;

public class RandomNumber {

	/***
	 * Method that returns a random number where the upper bound is the number of words in the database
	 * @return random
	 */
	public static Integer randNumber() {

		Random random = new Random();

		int allWordsListSize = WordController.getAllWords().size();

		int upperBound = allWordsListSize - 1 + 1;

		return random.nextInt(upperBound);
	}
}
