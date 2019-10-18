package Sort;

public class MySort implements MySortInterface {
	private static int MAX_SIZE = 1000000;

	// 버블 정렬
	@Override
	public void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	// 선택 정렬
	@Override
	public void selectionSort(int[] arr) {
		int size = arr.length;
		int min;
		int temp;

		for (int i = 0; i < size - 1; i++) {
			min = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[min] > arr[j]) {
					min = j; // 최솟값의 인덱스를 찾아 min에 저장한다.
				}
			}
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}

	// 삽입 정렬
	@Override
	public void insertionSort(int[] arr) {
		int size = arr.length;
		int temp = 0;
		int j = 0;
		for (int i = 1; i < size; i++) {
			temp = arr[i];
			for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}

	// 퀵 정렬
	public void quickSort(int[] arr, int l, int r) {
		int left = l;
		int right = r;
		int pivot = arr[(l + r) / 2];

		do {
			while (arr[left] < pivot)
				left++;
			while (arr[right] > pivot)
				right--;
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		} while (left <= right);

		if (l < right)
			quickSort(arr, l, right);
		if (r > left)
			quickSort(arr, left, r);
	}

}
