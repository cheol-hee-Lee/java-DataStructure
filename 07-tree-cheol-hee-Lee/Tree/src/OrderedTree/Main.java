package OrderedTree;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		OrderedTree treeA, treeB, treeD;

		// 최하위 노드
		OrderedTree treeC = new OrderedTree("C");
		OrderedTree treeE = new OrderedTree("E");
		OrderedTree treeF = new OrderedTree("F");
		OrderedTree treeG = new OrderedTree("G");

		// 하위 노드를 가지는 트리들
		List subtreesOfB = new LinkedList();
		subtreesOfB.add(treeE);
		subtreesOfB.add(treeF);
		treeB = new OrderedTree("B", subtreesOfB);

		List subtreesOfD = new LinkedList();
		subtreesOfD.add(treeG);
		treeD = new OrderedTree("D", subtreesOfD);

		List subtreesOfA = new LinkedList();
		subtreesOfA.add(treeB);
		subtreesOfA.add(treeC);
		subtreesOfA.add(treeD);
		treeA = new OrderedTree("A", subtreesOfA);

		// 출력
		System.out.print("Level Order Print : ");
		treeA.printTreeByLevelOrder();
		System.out.println();

		System.out.print("Pre Order Print : ");
		treeA.printTreeByPreOrder();
		System.out.println();

		System.out.print("Post Order Print : ");
		treeA.printTreeByPostOrder();
		System.out.println();

	}

}
