package SequentialBinarySearch;

public interface SearchDemoInterface {
	void printSequentialSearchTime(SetDemo set, Integer[] searchNumberArray);

	Integer[] setToIntegerArray(SetDemo set);

	int getIndexByBinarySearch(Integer[] array, Integer searchValue);

	int getIndexBySequentialSearch(Integer[] array, Integer searchValue);

	void setFiveSearchValue(SetDemo set, Integer[] searchNumberArray);

	void searchRandomFive(SetDemo set);

	void setArray(SetDemo set, int num);

	void printBinarySearchTime(SetDemo set, Integer[] searchNumberArray);
	
}
