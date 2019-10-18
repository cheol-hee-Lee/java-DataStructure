package Search;

public class Search implements SearchInterface {

	@Override
	public int getIndexBySequentialSearch(char[] dictionary, char searchValue) {
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i] == searchValue) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int getIndexByBinarySearch(char[] dictionary, char searchValue) {
		int startIndex = 0;
		int endIndex = dictionary.length - 1;
		int middle;

		while (startIndex <= endIndex) {
			middle = (startIndex + endIndex) / 2;
			if (dictionary[middle] == searchValue) {
				return middle;
			} else if (dictionary[middle] < searchValue) {
				startIndex = middle + 1;
			} else {
				endIndex = middle - 1;
			}
		}
		return -1;
	}
}
