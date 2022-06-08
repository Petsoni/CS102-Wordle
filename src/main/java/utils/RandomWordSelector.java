package utils;

public class RandomWordSelector {

	/***
	 * Method that returns a random word from a list of words
	 * @return randomWord
	 */
	public static String getRandomWord() {

		int randomNumber = RandomNumber.randNumber();

		WordScrapper wordScrapper = new	WordScrapper();

		String randomWord = wordScrapper.scrapeWords().get(randomNumber);

		return randomWord;

	}

}
