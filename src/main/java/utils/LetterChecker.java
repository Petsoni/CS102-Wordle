package utils;

import java.util.Locale;

public class LetterChecker {

	//method that checks all letters in a word and compares it to the letters of the other word
	public static boolean checkLetters(String word, String otherWord) {

		//convert both words to lowercase
		word = word.toUpperCase(Locale.ROOT);
		otherWord = otherWord.toUpperCase(Locale.ROOT);

		//check if the words are the same length
		if (word.length() != otherWord.length()) {
			return false;
		}

		//check if the words contain the same letters
		for (int i = 0; i < word.length(); i++) {
			if (!word.contains(String.valueOf(otherWord.charAt(i)))) {
				return false;
			}
		}

		return true;
	}

}
