package utils;

import java.util.Random;

public class RandomNumber {

	/***
	 * Method that returns a random number where the upper bound is the number of words in the database
	 * @return random
	 */
	public static Random randNumber() {

		Random random = new Random();

		int upperBound = 100;

		int randomNum = random.nextInt(upperBound);

		return random;
	}
}
