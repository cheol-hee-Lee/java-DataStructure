package SequentialBinarySearch;

import java.util.Arrays;
import java.util.Random;

public class SearchDemo implements SearchDemoInterface {

	@Override
	public void setArray(SetDemo set, int num) {
		// num개 만큼 arraySet 집합에 저장
		for (int i = 0; i < num; i++) {
			set.add(i);
		}
	}

	@Override
	public void searchRandomFive(SetDemo set) {
		int size = set.size();
		Integer[] searchNumberArray = new Integer[5];
		
		setFiveSearchValue(set, searchNumberArray); // 무작위 탐색값 설정
		
		System.out.println("About set_" + size + " ....");
		System.out.println("* Sequential Search Results");
		printSequentialSearchTime(set, searchNumberArray); // 순차탐색 시간 출력
		
		System.out.println("* Binary Search Results");
		printBinarySearchTime(set,searchNumberArray); // 이진탐색 시간 출력
	}

	@Override
	public void setFiveSearchValue(SetDemo set, Integer[] searchNumberArray) {
		int size = set.size();
		// 무작위 값 설정 변수
		Random random = new Random();
		int randomIndex;
		// 탐색할 5개 값 무작위 설정
		for (int i = 0; i < 5; i++) {
			randomIndex = random.nextInt(size); // 0 ~ size-1의 인덱스를 무작위로 저장한다.
			// 무작위 인덱스의 값을 탐색값으로 저장한다.
			searchNumberArray[i] = (Integer) set.getValueByIndex(randomIndex); 
		}
	}

	@Override
	public int getIndexBySequentialSearch(Integer[] array, Integer searchValue) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == searchValue) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int getIndexByBinarySearch(Integer[] array, Integer searchValue) {
		int startIndex = 0;
		int endIndex = array.length - 1;
		int middle;

		while (startIndex <= endIndex) {
			middle = (startIndex + endIndex) / 2; // 중앙 인덱스를 기준으로
			if (array[middle] == searchValue) { // 탐색값이 중앙값과 같으면
				return middle;
			} else if (array[middle] < searchValue) { // 탐색값이 중앙값보다 크면 
				startIndex = middle + 1;
			} else { // 탐색값이 중앙값보다 작으면
				endIndex = middle - 1;
			}
		}

		return -1;
	}

	@Override
	public Integer[] setToIntegerArray(SetDemo set) {
		int size = set.size();
		// set을 Integer 배열에 저장
		Integer[] dictionary = new Integer[size];
		System.arraycopy(set.getObjects(), 0, dictionary, 0, size);
		Arrays.sort(dictionary);
		return dictionary;
	}

	@Override
	public void printSequentialSearchTime(SetDemo set, Integer[] searchNumberArray) {
		int size = set.size();
		long startTime, endTime;
		Integer[] dictionary = new Integer[size];
		
		// 5개의 원소 탐색 및 탐색시간 측정
		System.out.println(" [Search Value]   [Search Time]");
		for (int i = 0; i < 5; i++) {
			// set을 Integer 배열에 저장
			dictionary = setToIntegerArray(set);
			// 탐색시간 측정
			startTime = System.nanoTime();
			getIndexBySequentialSearch(dictionary, searchNumberArray[i]);
			endTime = System.nanoTime();
			// 탐색시간 출력
			System.out.printf("%15d %15d\n", searchNumberArray[i], endTime - startTime);

		}
		System.out.println();
		
	}

	@Override
	public void printBinarySearchTime(SetDemo set, Integer[] searchNumberArray) {
		int size = set.size();
		long startTime, endTime;
		Integer[] dictionary = new Integer[size];
		
		System.out.println(" [Search Value]   [Search Time]");
		for (int i = 0; i < 5; i++) {
			// set을 Integer 배열에 저장
			dictionary = setToIntegerArray(set);
			// 정렬
			Arrays.sort(dictionary);
			// 탐색시간 측정
			startTime = System.nanoTime();
			getIndexByBinarySearch(dictionary, searchNumberArray[i]);
			endTime = System.nanoTime();
			// 탐색시간 출력
			System.out.printf("%15d %15d\n", searchNumberArray[i], endTime - startTime);
		}
		System.out.println("\n");
	}

}
