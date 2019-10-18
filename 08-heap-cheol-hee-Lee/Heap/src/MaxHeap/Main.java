package MaxHeap;

public class Main {

	public static void main(String[] args) {
		int[] arr = { 3, 10, 6, 8, 5, 7, 11 };
		MaxHeap maxHeap = new MaxHeap(2 * arr.length + 2);

		System.out.println("09. Heap - MaxHeap 삽입, 삭제 테스트 과제");
		System.out.println("1. MaxHeap 삽입 테스트 ----------------------\n");
		System.out.println(" 1) Heap에 { 3, 10, 6, 8, 5, 7, 11 } 를 삽입합니다.\n");
		for (int i = 0; i < arr.length; i++) {
			maxHeap.insert(arr[i]);
		}
		System.out.println(" 2) 삽입 후 Heap의 상태\n");
		maxHeap.print();

		System.out.println("\n2. MaxHeap 삭제 테스트  ----------------------\n");
		System.out.println(" 1) maxHeap.delete()\n");
		System.out.println("    - 11과 7을 swap");
		System.out.println("    - 11을 삭제");
		System.out.println("    - 부모 7은 자식보다 작다. 자식 중 8 < 10 이므로 7과 10을 교환 (Max : 10)");
		System.out.println("    - 7 > 6 이므로 교환하지 않음 (모든 자식-부모가 오름차순으로 졍렬됨)\n");

		maxHeap.delete();

		System.out.println(" 2) maxHeap.delete()\n");
		System.out.println("    - 10과 6을 swap");
		System.out.println("    - 10을 삭제");
		System.out.println("    - 자식 중 7 < 8 이므로 6(부모)과 8(큰 자식)을 교환 (Max : 8)");
		System.out.println("    - 6 > 3, 6 > 5 이므로 교환하지 않음 (모든 자식-부모가 오름차순으로 졍렬됨)\n");

		maxHeap.delete();
		System.out.println(" 3) maxHeap.delete()\n");
		System.out.println("    - 8과 5을 swap");
		System.out.println("    - 8을 삭제");
		System.out.println("    - 자식 중 6 < 7 이므로 5(부모)와 7(큰 자식)을 교환 (Max : 7)");
		System.out.println("    - 5의 자식이 없으므로 heapifyDown()종료 (모든 자식-부모가 오름차순으로 졍렬됨)\n");

		maxHeap.delete();
	}
}
