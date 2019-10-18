package AVLTree;

/**
 * 12. AVLTree
 * 
 * @author : LeeCheolHee
 * 
 * 2019. 5. 29.
 * 
 */
public class AVLTree {
	private Node root;

	/**
	 * 생성자
	 * 
	 */
	public AVLTree() {
		this.root = null;
	}

	/**
	 * 생성자
	 * 
	 * @param root root
	 */
	public AVLTree(Node root) {
		this.root = root;
	}

	/**
	 * root 반환
	 * 
	 * @return root root
	 *
	 */
	public Node getRoot() {
		return this.root;
	}

	/**
	 * root에 노드를 삽입
	 * 
	 * @param newNode root
	 *
	 */
	public void setRoot(Node newNode) {
		this.root = newNode;
	}

	/**
	 * 높이를 반환
	 * 
	 * @param N node
	 *
	 * @return height 높이
	 *
	 */
	int height(Node N) {
		if (N == null) {
			return 0;
		}

		return N.getHeight();
	}

	/**
	 * node의 balance를 반환한다.
	 * 
	 * @param N node
	 *
	 * @return balance balance
	 *
	 */
	int getBalance(Node N) {
		if (N == null) {
			return 0;
		}

		return height(N.getLeftChild()) - height(N.getRightChild());
	}

	/**
	 * root로부터 preOrder 순으로 출력한다.
	 * 
	 * @param node root
	 *
	 */
	void preOrderPrint(Node node) {
		if (node != null) {
			System.out.print(node.getValue() + " ");
			preOrderPrint(node.getLeftChild());
			preOrderPrint(node.getRightChild());
		}
	}

	/**
	 * <p>
	 * root에 value를 삽입한다.
	 * </p>
	 * <p>
	 * balancing process를 진행한다. (LL, RR, LR, RL)
	 * </p>
	 * 
	 * 
	 * @param node root
	 *
	 * @param key  삽입할 원소
	 * 
	 * @return root 삽입한 이후의 최상위 노드
	 *
	 */
	public Node insert(Node node, int key) {
		if (node == null) {
			return (new Node(key, null, null));
		}

		if (key < node.getValue()) {
			node.setLeftChild(insert(node.getLeftChild(), key));
		} else {
			node.setRightChild(insert(node.getRightChild(), key));
		}
		int tmp = Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
		node.setHeight(tmp);

		// balancing process
		int balance = getBalance(node);

		// Left Left
		if (balance > 1 && key < node.getLeftChild().getValue()) {
			return rightRotate(node);
		}
		// Right Right
		if (balance < -1 && key > node.getRightChild().getValue()) {
			return leftRotate(node);
		}
		// Left Right
		if (balance > 1 && key > node.getLeftChild().getValue()) {
			node.setLeftChild(leftRotate(node.getLeftChild()));
			return rightRotate(node);
		}

		// Right Left
		if (balance < -1 && key < node.getRightChild().getValue()) {
			node.setRightChild(rightRotate(node.getRightChild()));
			return leftRotate(node);
		}

		return node;
	}

	/**
	 * rightRotate를 수행한다.
	 * 
	 * @param y right rotate를 수행할 최상위 노드
	 *
	 * @return x right rotate를 수행한 이후의 최상위 노드
	 *
	 */
	private Node rightRotate(Node y) {
		Node x = y.getLeftChild();
		Node T2 = x.getRightChild();

		x.setRightChild(y);
		y.setLeftChild(T2);

		int tmp = Math.max(height(y.getLeftChild()), height(y.getRightChild())) + 1;
		y.setHeight(tmp);

		tmp = Math.max(height(x.getLeftChild()), height(x.getRightChild())) + 1;
		x.setHeight(tmp);

		return x;
	}

	/**
	 * leftRotate를 수행한다.
	 * 
	 * @param x left rotate를 수행할 최상위 노드
	 *
	 * @return y left rotate를 수행한 이후의 최상위 노드
	 *
	 */
	private Node leftRotate(Node x) {
		Node y = x.getRightChild();
		Node T2 = y.getLeftChild();

		y.setLeftChild(x);
		x.setRightChild(T2);

		int tmp = Math.max(height(x.getLeftChild()), height(x.getRightChild())) + 1;
		x.setHeight(tmp);

		tmp = Math.max(height(y.getLeftChild()), height(y.getRightChild())) + 1;
		y.setHeight(tmp);

		return y;
	}

	/**
	 * AVLTree에 저장된 노드를 가독성있게 출력
	 * 
	 * @param root   출력할 최상 노드
	 * 
	 * @param prefix 출력할 문자열
	 * 
	 * @param isTail 마지막 자식 노드인지 여부
	 *
	 *
	 */
	public void print(Node root, String prefix, boolean isTail) {
		if (root == null) {
			return;
		}
		if (prefix == "") {
			System.out.println(prefix + "    " + root.getValue());
		} else {
			System.out.println(prefix + (isTail ? "└── " : "├── ") + root.getValue());
		}

		if (root.getLeftChild() != null && root.getRightChild() != null) {
			print(root.getLeftChild(), prefix + (isTail ? "    " : "│   "), false);
			print(root.getRightChild(), prefix + (isTail ? "    " : "│   "), true);
		}

		if (root.getLeftChild() != null && root.getRightChild() == null) {
			print(root.getLeftChild(), prefix + (isTail ? "    " : "│   "), true);
		}
		if (root.getLeftChild() == null && root.getRightChild() != null) {
			print(root.getRightChild(), prefix + (isTail ? "    " : "│   "), true);
		}
	}

}
