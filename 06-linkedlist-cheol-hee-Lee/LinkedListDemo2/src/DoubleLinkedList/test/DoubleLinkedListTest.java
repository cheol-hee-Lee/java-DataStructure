package DoubleLinkedList.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import DoubleLinkedList.DoubleLinkedList;

class DoubleLinkedListTest {

	/**
	 * addFirst를 테스트
	 */
	@Test
	void testAddFirst() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.addFirst("one");
		dll.addFirst("two");

		assertEquals("two", dll.get(0));
	}

	/**
	 * addLast를 테스트
	 */
	@Test
	void testAddLast() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.addLast("one");
		dll.addLast("two");

		assertEquals("two", dll.get(1));
	}

	/**
	 * removeLast를 테스트
	 */
	@Test
	void testRemoveLast() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.addLast("one");
		dll.addLast("two");
		dll.addLast("three");
		dll.addLast("four");

		assertEquals("four", dll.removeLast());
	}

	/**
	 * remove를 테스트
	 */
	@Test
	void testRemove() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.addLast("one");
		dll.addLast("two");
		dll.addLast("three");
		dll.addLast("four");

		assertEquals("three", dll.remove(2));
	}

	/**
	 * size를 테스트
	 */
	@Test
	void testSize() {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.addLast("one");
		dll.addLast("two");
		dll.addLast("three");
		dll.addLast("four");

		assertEquals(4, dll.size());
	}

}
