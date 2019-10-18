package ListMap.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ListMap.ListMap;

class ListMapTest {
	/*
	 * key�� �Է��� �ش� value�� ��� �Լ�
	 */
	@Test
	void testGet() {
		ListMap listMap = new ListMap();
		listMap.put("�ܾ�", 1);
		assertEquals(1, listMap.get("�ܾ�"));
	}

	/*
	 * ���� key���� ���� 2�� put�ϸ� value�� 1 �����ȴ�.
	 */
	@Test
	void testPut() {
		ListMap listMap = new ListMap();
		listMap.put("�ܾ�", 1);
		listMap.put("�ܾ�", 1);
		assertEquals(2, listMap.get("�ܾ�"));
	}

	/*
	 * key���� �ߺ����� �����Ƿ� 3�� put �ص� size�� 2�̴�.
	 */
	@Test
	void testSize() {
		ListMap listMap = new ListMap();
		listMap.put("�ܾ�", 1);
		listMap.put("�ܾ�", 1);
		listMap.put("key�߰�", 1);
		assertEquals(2, listMap.size());
	}
}
