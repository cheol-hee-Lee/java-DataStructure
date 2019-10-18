package OrderedTree;

import java.util.ArrayDeque;
import java.util.Iterator;
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
public class OrderedTree {
	/**
	 * 최상의 노드
	 */
	private Object root;
	/**
	 * subtree의 집합을 저장하는 리스트
	 */
	private List subtrees;

	/**
	 * 크기
	 */
	private int size;

	/**
	 * 생성자
	 */
	public OrderedTree() {

	}

	/**
	 * 생성자
	 * 
	 * @param root 하나의 노드
	 */
	public OrderedTree(Object root) {
		this.root = root;
		subtrees = new LinkedList(); // 자식을 저장
		this.size = 1;

	}

	/**
	 * 생성자, trees에 있는 원소들을 subtrees에 저장한다.
	 * 
	 * @param root  하나의 노드
	 * 
	 * @param trees 하위 노드를 저장하고 있는 리스트
	 */
	public OrderedTree(Object root, List trees) {
		this(root);

		for (Iterator it = trees.iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof OrderedTree) {
				OrderedTree tree = (OrderedTree) object;
				subtrees.add(tree);
				size += tree.size();
			}
		}
	}

	/**
	 * 
	 * @return size OrderedTree가 가진 노드의 개수를 반환한다.
	 *
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Level Order로 Tree를 출력
	 *
	 */
	public void printTreeByLevelOrder() {
		ArrayDeque queue = new ArrayDeque();
		queue.add(this);
		while (!queue.isEmpty()) {
			OrderedTree tmpSubtrees = (OrderedTree) queue.pop();
			System.out.print(tmpSubtrees.root + " ");

			for (Iterator it = tmpSubtrees.subtrees.iterator(); it.hasNext();) {
				Object object = it.next();

				if (object instanceof OrderedTree) {
					OrderedTree tree = (OrderedTree) object;
					queue.add(tree);
				}
			}
		}

	}

	/**
	 * Pre Order로 Tree를 출력
	 * 
	 *
	 */
	public void printTreeByPreOrder() {
		System.out.print(root + " ");

		for (Iterator it = subtrees.iterator(); it.hasNext();) {
			Object object = it.next();

			if (object instanceof OrderedTree) {
				OrderedTree tree = (OrderedTree) object;
				tree.printTreeByPreOrder();
			}

		}
	}

	/**
	 * Post Order로 Tree를 출력
	 *
	 */
	public void printTreeByPostOrder() {
		for (Iterator it = subtrees.iterator(); it.hasNext();) {
			Object object = it.next();

			if (object instanceof OrderedTree) {
				OrderedTree tree = (OrderedTree) object;
				tree.printTreeByPostOrder();
			}
		}
		System.out.print(root + " ");
	}

}
