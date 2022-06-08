package interfaces;

import java.util.List;

public interface WordsInterface {

	/***
	 * Method that returns all 5-letter words from a certain site (dictionary)
	 * @return wordsList
	 */
	List<String> scrapeWords();

}
