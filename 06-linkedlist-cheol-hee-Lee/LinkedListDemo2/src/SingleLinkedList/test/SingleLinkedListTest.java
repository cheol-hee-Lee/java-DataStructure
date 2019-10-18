package SingleLinkedList.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import SingleLinkedList.SingleLinkedList;

class SingleLinkedListTest {

	/**
	 * insert 테스트
	 */
	@Test
	void testInsert() {
		SingleLinkedList sl = new SingleLinkedList();

		assertTrue(sl.insert("C"));
	}

	/**
	 * delete 테스트
	 */
	@Test
	void testDelete() {
		SingleLinkedList sl = new SingleLinkedList();
		sl.insert("Java");

		assertTrue(sl.delete("Java"));

	}

	/**
	 * contains 테스트
	 */
	@Test
	void testContains() {
		SingleLinkedList sl = new SingleLinkedList();
		sl.insert("C");
		sl.insert("C3");
		System.out.println(sl.contains("C"));
		assertTrue(sl.contains("C"));

	}

}
