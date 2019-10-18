package AVLTree;

/**
 * 12. AVLTree
 * 
 * @author : LeeCheolHee
 * 
 *         2019. 5. 29.
 * 
 */
public class Node {
	private int value;
	private Node leftChild;
	private Node rightChild;
	private int height;

	/**
	 * 생성자
	 * 
	 * @param _v value
	 * @param lc left child
	 * @param rc right child
	 */
	public Node(int _v, Node lc, Node rc) {
		this.value = _v;
		this.leftChild = lc;
		this.rightChild = rc;
		this.height = 1;
	}

	/**
	 * value를 반환
	 * 
	 * @return value value
	 *
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * left child를 반환
	 * 
	 * @return leftChild left child
	 *
	 */
	public Node getLeftChild() {
		return this.leftChild;
	}

	/**
	 * right child를 반환
	 * 
	 * @return rightChild right child
	 *
	 */
	public Node getRightChild() {
		return this.rightChild;
	}

	/**
	 * height를 반환
	 * 
	 * @return height
	 *
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * left child를 설정
	 * 
	 * @param lc left child
	 *
	 */
	public void setLeftChild(Node lc) {
		this.leftChild = lc;
	}

	/**
	 * right child를 설정
	 * 
	 * @param rc right child
	 */
	public void setRightChild(Node rc) {
		this.rightChild = rc;
	}

	/**
	 * height를 설정
	 * 
	 * @param height height
	 *
	 */
	public void setHeight(int height) {
		this.height = height;
	}

}
