package Sort;

public class Main {
	public static void main(String[] args) {
		// 10회 측정
		double[][] sortTime_10 = new double[10][4];
		double[][] sortTime_100 = new double[10][4];
		double[][] sortTime_1000 = new double[10][4];
		double[][] sortTime_10000 = new double[10][4];
		double[][] sortTime_100000 = new double[10][4];

		System.out.println("* n이 커짐에 따른 4개의 정렬 시간 비교");

		measureAndPrint(sortTime_10, 10);
		measureAndPrint(sortTime_100, 100);
		measureAndPrint(sortTime_1000, 1000);
		measureAndPrint(sortTime_10000, 10000);
		measureAndPrint(sortTime_100000, 100000);
	}

	// 정렬시간 출력
	public static void printSortTime(double[][] arr, int n) {
		System.out.println("\nn = " + n);
		// tab문자로 구별하여 엑셀에 저장하기 쉽게 만듬
		System.out.printf("%8s\t%8s\t%8s\t%8s\n", "bubble", "selection", "insertion", "quick");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.printf("%f\t", arr[i][j]);
			}
			System.out.println();
		}
	}

	// 배열 생성, 정렬 시간 측정, 출력
	public static void measureAndPrint(double[][] sortTime, int n) {
		MeasureComplexity mc = new MeasureComplexity();
		int[] arr0 = new int[n];
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int[] arr3 = new int[n];

		for (int i = 0; i < 10; i++) {
			arr0 = mc.createRandomArray(n);
			System.arraycopy(arr0, 0, arr1, 0, n);
			System.arraycopy(arr0, 0, arr2, 0, n);
			System.arraycopy(arr0, 0, arr3, 0, n);

			sortTime[i][0] = mc.measureTime("bubble", arr0);
			sortTime[i][1] = mc.measureTime("selection", arr1);
			sortTime[i][2] = mc.measureTime("insertion", arr2);
			sortTime[i][3] = mc.measureTime("quick", arr3);
		}

		printSortTime(sortTime, n);
	}
}
