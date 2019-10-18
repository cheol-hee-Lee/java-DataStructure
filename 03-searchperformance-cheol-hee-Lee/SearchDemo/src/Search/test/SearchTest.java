package Search.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Search.Search;

class SearchTest {

	@Test
	void testGetIndexBySequentialSearch() {
		char[] alphabetArray = new char[26];
		int initNum = 65;

		for (int i = 0; i < alphabetArray.length; i++) {
			alphabetArray[i] = (char) (initNum + i);
		}

		Search search = new Search();
		assertEquals(14, search.getIndexBySequentialSearch(alphabetArray, 'O'));

	}

	@Test
	void testGetIndexByBinarySearch() {
		char[] alphabetArray = new char[26];
		int initNum = 65;

		for (int i = 0; i < alphabetArray.length; i++) {
			alphabetArray[i] = (char) (initNum + i);
		}

		Search search = new Search();

		assertEquals(25, search.getIndexByBinarySearch(alphabetArray, 'Z'));
	}
}
