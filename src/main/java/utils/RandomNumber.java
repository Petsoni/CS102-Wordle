package utils;

import java.util.Random;

public class RandomNumber {

	/***
	 * Method that returns a random number where the upper bound is the number of words in the database
	 * @return random
	 */
	public static Integer randNumber() {

		Random random = new Random();

		int upperBound = 8913 - 1 + 1;

		return random.nextInt(upperBound);
	}
}
