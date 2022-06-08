package utils;

import interfaces.WordsInterface;
import javafx.event.ActionEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/***
 * Class for getting all 5-letter words from a certain site (dictionary)
 */

public class WordScrapper implements WordsInterface {

	private final List<String> wordList = new ArrayList<>();

	@Override
	public List<String> scrapeWords() {

		{
			try {

				Document document = Jsoup.connect(
						"https://www.thefreedictionary.com/5-letter-words.htm").get();

				Elements elements = document.select("#dCont > .TCont");

				for (Element el : elements) {
					String word = el.select("ul > li").text().toUpperCase(Locale.ROOT);
					wordList.addAll(List.of(word.split(" ")));
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return wordList;
	}

}

