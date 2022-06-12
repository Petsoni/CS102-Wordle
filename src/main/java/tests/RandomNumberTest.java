package tests;

import org.junit.jupiter.api.Test;
import utils.RandomNumber;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {

	@Test
	void randNumber() {


		int upperBound = 10000 - 505 + 1;

		assertTrue(RandomNumber.randNumber() <= upperBound);

	}

	@Test
	void randNumberIsHigher() {


		int upperBound = 10000 - 505 + 1;

		assertFalse(RandomNumber.randNumber() > upperBound);

	}

	@Test
	void randNumberIsLower() {

		int lowerBound = 505;

		assertFalse(RandomNumber.randNumber() < lowerBound);

	}

}