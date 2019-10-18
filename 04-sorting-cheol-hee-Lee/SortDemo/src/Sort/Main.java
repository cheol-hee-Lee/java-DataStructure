package Sort;

public class Main {

	public static void main(String[] args) {
		SortFunction sf = new SortFunction();
		int arr1[] = sf.getNumberArray();
		int arr2[] = sf.getNumberArray();

		// 원래 배열을 출력
		show("Original Number Array");
		sf.printOriginalArray();

		// 버블 정렬된 배열을 출력
		show("Bubble Sort Result");
		sf.bubbleSort(arr1);
		sf.setSortedArray(arr1);
		sf.printSortedArray();

		// 선택 정렬된 배열을 출력
		show("Selection Sort Result");
		sf.selectionSort(arr2);
		sf.setSortedArray(arr2);
		sf.printSortedArray();
	}

	public static void show(String str) {
		System.out.println("* " + str + "--------------------------------------");
	}
}
