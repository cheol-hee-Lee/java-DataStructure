package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 08. Tree
 * 
 * @author : LeeCheolHee
 * 
 *         2019. 5. 4.
 * 
 */
public class BinarySearchTree {
	/**
	 * 최상위 노드
	 */
	private Node root;
	
	/**
	 * 하위 노드를 저장하는 리스트
	 */
	private List subtrees;
	/**
	 * 생성자 어떤 노드도 존재하지 않음
	 */
	public BinarySearchTree() {
		this.root = null;
		this.subtrees = new LinkedList();
	}

	/**
	 * 생성자 노드 하나만 존재
	 * 
	 * @param root 노드
	 */
	public BinarySearchTree(Node root) {
		this.root = root;
		this.subtrees = new LinkedList();
	}

	/**
	 * Node 내부 클래스
	 */
	private class Node {
		/**
		 * 값
		 */
		private int key;
		/**
		 * 왼쪽, 오른쪽 노드를 저장하는 변수
		 */
		private Node left, right;

		/**
		 * 노드의 생성자
		 * 
		 * @param key key값을 저장
		 */
		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * root를 반환
	 * 
	 * @return root 최상위 노드
	 *
	 */
	public Node getRoot() {
		return this.root;
	}

	/**
	 * 재귀적으로 트리에 있는 모든 노드 값을 오름차순으로 출력
	 * 
	 * @param root 최상위 노드
	 *
	 */
	public void printTree(Node root) {
		if (root != null) {
			printTree(root.left);
			System.out.print(root.key + " ");
			printTree(root.right);
		}
	}

	/**
	 * value를 가지는 노드를 재귀적으로 찾아 삭제
	 * 
	 * @param value 삭제할 노드 값을 출력
	 *
	 */
	public void delete(int value) {
		root = deleteRecursively(root, value);
	}

	/**
	 * targetValue를 가진 노드를 재귀적으로 삭제
	 * 
	 * 1. root가 null이면 삭제 불가 
	 * 2. root.key가 targetValue를 가지면 해당 노드를 삭제 
	 *  a. root.left가 null이고 root.right가 null이면 하나 남은 노드를 삭제하므로 root = null 
	 *  b. root.right가 null이면 삭제한 노드의 왼쪽 노드를 root에 넣으므로 root = root.left 
	 *  c. root.left가 null이면 삭제한 노드의 오른쪽 노드를 root에 넣으므로 root = root.right 
	 *  d. a, b, c가 아니면 오른쪽 트리에서 최소값을 탐색하여 key값을 교환한다. 
	 * 3. targetValue가 root.key보다 작으면 root.left에서 deleteRecursively 호출 
	 * 4. targetValue가 root.key보다 크면 root.right에서 deleteRecursively 호출
	 * 
	 * 
	 * @param root        삭제하기 전 최상위 노드
	 *
	 * @param targetValue 삭제할 노드의 값
	 *
	 * @return root 삭제한 후 최상위 노드(변경될 수 있음)
	 *
	 */
	public Node deleteRecursively(Node root, int targetValue) {
		if (root == null) {
			return null;
		}

		if (targetValue == root.key) {
			if (root.left == null && root.right == null) {
				return null;
			}
			if (root.right == null) {
				return root.left;
			}

			if (root.left == null) {
				return root.right;
			}

			int rightMin = treeMin(root.right);
			root.key = rightMin;
			root.right = deleteRecursively(root.right, rightMin);
			return root;
		}

		if (targetValue < root.key) {
			root.left = deleteRecursively(root.left, targetValue);
			return root;
		}

		if (targetValue > root.key) {
			root.right = deleteRecursively(root.right, targetValue);
			return root;
		}

		return null;

	}

	/**
	 * root를 포함한 하위 트리로부터 최소값을 반환
	 * 
	 * @param root 최상위 노드
	 *
	 * @return int 최소값
	 *
	 */
	private int treeMin(Node root) {
		return root.left == null ? root.key : treeMin(root.left);
	}

	/**
	 * value값을 가지는 노드를 삽입한다.
	 * 
	 * @param value 삽입할 노드의 값
	 *
	 */
	public void insert(int value) {
		root = insertRecursively(root, value);
	}

	/**
	 * value값을 가진 노드를 root를 가진 트리에 삽입
	 * 
	 * 1. root이 null과 같으면 root에 삽입
	 * 2. value가 root.key보다 작으면 root.left 트리에 삽입 
	 * 3. value가 root.key보다 크면 root.right 트리에 삽입
	 * 4. value가 root.key과 같으면 삽입 하지 않음
	 * 
	 * @param root  root의 left | right에 value값을 가지는 노드를 삽입한다.
	 *
	 * @param value 삽입할 노드의 값
	 * 
	 * @return Node 삽입된 노드
	 *
	 */
	public Node insertRecursively(Node root, int value) {
		if (root == null) {
			return new Node(value);
		}
		if (value < root.key) {
			root.left = insertRecursively(root.left, value);
		} else if (value > root.key) {
			root.right = insertRecursively(root.right, value);
		} else {
			return root;
		}
		return root;
	}
	
}
