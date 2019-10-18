package Sort;

public interface SortInterface {
	public void bubbleSort(int[] arr);

	public void selectionSort(int[] arr);

	public void quickSort(int[] arr, int l, int r);

	public void insertionSort(int[] arr);

	public void printOriginalArray();

	public void printSortedArray();

	public int[] getNumberArray();

	public int[] getSortedArray();

	public void setSortedArray(int[] arr);
}
