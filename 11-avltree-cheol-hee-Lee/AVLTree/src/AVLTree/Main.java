package AVLTree;

public class Main {

	public static void main(String[] args) {
		AVLTree avlTree_LL = new AVLTree();
		AVLTree avlTree_RR = new AVLTree();
		AVLTree avlTree_LR = new AVLTree();
		AVLTree avlTree_RL = new AVLTree();

		Node root_LL = null;
		Node root_RR = null;
		Node root_LR = null;
		Node root_RL = null;

		int[] testData_LL = { 13, 10, 15, 5, 16, 11, 4, 8, 3 };
		int[] testData_RR = { 30, 5, 35, 32, 40, 45 };
		int[] testData_LR = { 13, 10, 15, 5, 11, 16, 4, 6, 7 };
		int[] testData_RL = { 5, 2, 7, 1, 4, 6, 9, 3, 16, 15 };


		System.out.println("\n\n* LL testing ---------------------------");

		for (int i = 0; i < testData_LL.length; i++) {
			root_LL = avlTree_LL.insert(root_LL, testData_LL[i]);
			avlTree_LL.print(root_LL, "", true);
			System.out.println();
		}
		avlTree_LL.preOrderPrint(root_LL);
		System.out.println("\n");
		
		System.out.println("\n\n* RR testing ---------------------------");
		for (int i = 0; i < testData_RR.length; i++) {
			root_RR = avlTree_RR.insert(root_RR, testData_RR[i]);
			avlTree_RR.print(root_RR, "", true);
			System.out.println();
		}
		avlTree_RR.preOrderPrint(root_RR);
		System.out.println("\n");
		
		System.out.println("\n\n* LR testing ---------------------------");
		for (int i = 0; i < testData_LR.length; i++) {
			root_LR = avlTree_LR.insert(root_LR, testData_LR[i]);
			avlTree_LR.print(root_LR, "", true);
			System.out.println();
		}
		avlTree_LR.preOrderPrint(root_LR);
		System.out.println("\n");
		
		System.out.println("\n\n* RL testing ---------------------------");
		for (int i = 0; i < testData_RL.length; i++) {
			root_RL = avlTree_RL.insert(root_RL, testData_RL[i]);
			avlTree_RL.print(root_RL, "", true);
			System.out.println();
		}
		avlTree_RL.preOrderPrint(root_RL);
		System.out.println("\n");
		
	}

}
