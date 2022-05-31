package utils;

import interfaces.WordsInterface;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class WordScrapper implements WordsInterface {

	/***
	 * Class for getting all 5-letter words from a certain site (dictionary)
	 */

	private Document document;
	private Elements elements;
	private List<String> wordList = new ArrayList<>();

	@Override
	public List<String> getAllWords() {

		{
			try {
				document = Jsoup.connect("https://www.thefreedictionary.com/5-letter-words.htm").get();

				elements = document.select("#dCont > .TCont");

				for (Element el : elements) {
					String word = el.select("ul > li").text().toUpperCase(Locale.ROOT);
					wordList.add(word);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return Collections.singletonList(wordList.toString());
	}

}

