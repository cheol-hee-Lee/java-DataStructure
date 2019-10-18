package HeapDemo;

public class TestHeapify {
	/**
	 * 배열을 MaxHeap으로 만듬. 배열의 상태를 출력함
	 * 
	 * @param a 배열
	 * @param i 부모 인덱스
	 * @param n 배열의 크기
	 *
	 */
	public static void buildHeap(int[] a, int i, int n) {
		if (i >= n / 2) {
			return;
		}
		buildHeap(a, 2 * i + 1, n);
		buildHeap(a, 2 * i + 2, n);
		heapify(a, i, n);
		printArray(a);
	}

	/**
	 * heapifyDown()을 통해 자식과 부모를 swap함으로써 자식-부모가 오름차순으로 정렬되게 만듬. 이로써 i = 0일 때
	 * array[i]는 최댓값을 가짐.
	 * 
	 * @param array 배열
	 * @param i     부모
	 * @param n     배열의 크기
	 *
	 */
	public static void heapify(int[] array, int i, int n) {
		int array_i = array[i]; // parent
		while (i < n / 2) {
			int j = 2 * i + 1; // left child
			// right child가 left child보다 크다면 right child선택
			if (j + 1 < n && array[j + 1] > array[j]) {
				++j;
			}

			// child <= parent
			if (array[j] <= array_i) {
				break;
			}

			// parent에 child 대입
			array[i] = array[j];
			// parent index에 child index 대입
			i = j;
		}
		// child에 원래의 parent값 대입 => swap
		array[i] = array_i;
	}

	/**
	 * MaxHeap으로 만든 HeapArray를 출력
	 * 
	 * @param array HeapArray
	 *
	 */
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = { 22, 33, 44, 55, 66, 77, 88, 99 };
		printArray(array);
		buildHeap(array, 0, array.length);
	}

}
