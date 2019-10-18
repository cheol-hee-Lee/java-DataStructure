package Sort;

import java.util.Random;

public class SortFunction implements SortInterface {
	private static int MAX_SIZE = 100; // 배열의 최대 크기 지정
	private int[] numberArray; // 정렬 전 배열
	private int[] sortedArray; // 정렬 후 배열
	private Random random; // 난수를 저장하기 위해 사용됨

	public SortFunction() {
		this.numberArray = new int[MAX_SIZE];
		this.random = new Random();

		// 난수 100개를 배열에 저장한다.
		for (int i = 0; i < this.numberArray.length; i++) {
			numberArray[i] = random.nextInt(1000);
		}

		this.sortedArray = new int[MAX_SIZE];
		// numberArray의 값을 sortedArray에 복사한다.
		System.arraycopy(numberArray, 0, sortedArray, 0, MAX_SIZE);
	}

	// 버블 정렬
	@Override
	public void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			// 한 번 돌면, 마지막에 제일 큰수가 저장되므로 정렬할 항이 1개씩 줄어든다.
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) { // 앞항이 뒷항보다 크면 교환한다.
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
			// 한 번 돌면, 제일 작은 항이 맨 앞으로 오게 되므로 정렬할 항이 1개씩 줄어든다.
			for (int j = i + 1; j < size; j++) {//
				if (arr[min] > arr[j]) { // 최소항보다 더 작은 항을 발견하면
					min = j; // 최솟값의 인덱스를 찾아 min에 저장한다.
				}
			}
			// 최소항과 첫 항을 교환한다.
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
		// 첫 번째 원소는 이미 정렬된 상태도 보므로 1부터 시작한다.
		for (int i = 1; i < size; i++) {
			temp = arr[i]; // 정렬을 대기하는 원소를 temp에 넣는다.
			// i-1부터 0까지 1씩 빼면서 정렬된 배열의 값들과 비교한다.
			// temp < arr[j]이면 정렬된 배열의 원소를 오른쪽으로 밀고, j를 1빼 왼쪽값과 비교한다.
			for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
				arr[j + 1] = arr[j];
			}
			// temp >= arr[j]이면 반복문을 빠져나와 j 오른쪽에 저장한다.
			arr[j + 1] = temp;
		}
	}

	// 퀵 정렬
	public void quickSort(int[] arr, int l, int r) {
		// l에는 첫항, r에는 마지막항
		int left = l;
		int right = r;
		// pivot은 가운데 값
		int pivot = arr[(l + r) / 2];

		do {
			// pivot보다 크거나 같은 값을 찾을 때까지 left를 오른쪽으로 이동시킨다.
			while (arr[left] < pivot)
				left++;
			// pivot보다 작거나 같은 값을 찾을 때까지 right를 왼쪽으로 이동시킨다.
			while (arr[right] > pivot)
				right--;
			// left, right가 엇갈리지 않았으면, 두 값을 교환한다.
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		} while (left <= right); // 엇갈리면 반복분을 빠져나온다.

		// 왼쪽 배열에 대해 재귀적으로 quickSort해준다.
		if (l < right)
			quickSort(arr, l, right);
		// 오른쪽 배열에 대해 재귀적으로 quickSort해준다.
		if (r > left)
			quickSort(arr, left, r);
	}

	@Override
	// 원래 배열을 출력하는 함수다.
	public void printOriginalArray() {
		for (int i = 0; i < numberArray.length; i++) {
			System.out.printf("%6d", numberArray[i]);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
	}

	@Override
	// 정렬된 배열을 출력하는 함수다.
	public void printSortedArray() {
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.printf("%6d", sortedArray[i]);
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
	}

	@Override
	public void setSortedArray(int[] arr) {
		this.sortedArray = arr;
	}

	@Override
	public int[] getNumberArray() {
		return numberArray;
	}

	@Override
	public int[] getSortedArray() {
		return sortedArray;
	}
}
