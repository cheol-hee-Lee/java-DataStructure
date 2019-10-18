package SequentialBinarySearch;

public class Main {

	public static void main(String[] args) {

		SearchDemo search = new SearchDemo();

		// 원소의 개수가 각 100, 1000, 10000개인 집합 선언
		SetDemo set_100 = new SetDemo();
		SetDemo set_1000 = new SetDemo();
		SetDemo set_10000 = new SetDemo();

		// 각 배열 초기화
		search.setArray(set_100, 100);
		search.setArray(set_1000, 1000);
		search.setArray(set_10000, 10000);

		// 각 배열에서 5개씩 탐색 및 탐색시간 출력
		search.searchRandomFive(set_100);
		search.searchRandomFive(set_1000);
		search.searchRandomFive(set_10000);
	}
}
