package AVLTree.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import AVLTree.AVLTree;
import AVLTree.Node;

class AVLTreeTest {

	@Test
	void testAVLTree() {
		Node root = new Node(10, null, null);
		AVLTree avltree = new AVLTree(root);

		assertEquals(10, avltree.getRoot().getValue());
	}

	@Test
	void testHeight() {
		AVLTree avltree = new AVLTree();
		Node root = null;
		
		root = avltree.insert(root, 1);
		root = avltree.insert(root, 2);
		root = avltree.insert(root, 3);
		root = avltree.insert(root, 4);

		assertEquals(3, root.getHeight());
	}

	@Test
	void testInsert() {
		AVLTree avltree = new AVLTree();
		Node root = null;
		root = avltree.insert(root, 1);
		root = avltree.insert(root, 2);
		root = avltree.insert(root, 3);

		assertEquals(2, root.getValue());
	}

}
