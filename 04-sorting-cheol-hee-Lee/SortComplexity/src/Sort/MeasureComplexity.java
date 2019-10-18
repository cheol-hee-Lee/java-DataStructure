package Sort;

import java.util.Random;

public class MeasureComplexity {

	// 크기가 n인 난수 배열을 만드는 함수
	public int[] createRandomArray(int n) {
		Random random = new Random();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(n);
		}

		return arr;
	}

	// 정렬 시간을 구하는 함수
	public double measureTime(String str, int[] arr) {
		MySort mySort = new MySort(); // 4개의 정렬 알고리즘을 저장하는 MySort
		long[] time = new long[2];
		long nano = 1000000000; // 단위를 초로 보이게 하기 위해 나누는 값

		if (str.equals("bubble")) {
			time[0] = System.nanoTime();
			mySort.bubbleSort(arr);
			time[1] = System.nanoTime();
		}

		if (str.equals("insertion")) {
			time[0] = System.nanoTime();
			mySort.insertionSort(arr);
			time[1] = System.nanoTime();
		}
		if (str.equals("selection")) {
			time[0] = System.nanoTime();
			mySort.selectionSort(arr);
			time[1] = System.nanoTime();
		}
		if (str.equals("quick")) {
			time[0] = System.nanoTime();
			mySort.quickSort(arr, 0, arr.length - 1);
			time[1] = System.nanoTime();
		}

		return (time[1] - time[0]) * (1.0) / nano;
	}
}
