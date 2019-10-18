package BinarySearchTree;

public class Main {

	public static void main(String[] args) {
		System.out.println("* BinarySearchTree Insertion, Deletion -----------------------------------\n");
		System.out.println("* bst 객체를 생성합니다.\n");
		BinarySearchTree bst = new BinarySearchTree();
		int[] insertedData = { 50, 22, 77, 18, 44, 30, 27, 33, 70, 88, 74, 60, 66, 63, 69, 80, 94 };
		int[] deletedData = { 50, 44, 69 };

		System.out.println("* 아래의 원소를 하나씩 삽입할 때마다 출력합니다.");
		System.out.println("{ 50, 22, 77, 18, 44, 30, 27, 33, 70, 88, 74, 60, 66, 63, 69, 80, 94 }");
		for (int i = 0; i < insertedData.length; i++) {
			bst.insert(insertedData[i]);
			bst.printTree(bst.getRoot());
			System.out.println();
		}

		System.out.println();
		System.out.println("* 아래의 원소를 하나씩 삭제할 때마다 출력합니다.");
		System.out.println("{50, 44, 69}");
		for (int i = 0; i < deletedData.length; i++) {
			bst.delete(deletedData[i]);
			bst.printTree(bst.getRoot());
			System.out.println();
		}

	}

}
