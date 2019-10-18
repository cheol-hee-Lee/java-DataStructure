package ArrayMap.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ArrayMap.ArrayMap;

class ArrayMapTest {
	/*
	 * key�� �Է��� �ش� value�� ��� �Լ�
	 */
	@Test
	void testGet() {
		ArrayMap arrayMap = new ArrayMap();
		arrayMap.put("�ܾ�", 1);
		assertEquals(1, arrayMap.get("�ܾ�"));
	}

	/*
	 * ���� key���� ���� 2�� put�ϸ� value�� 1 �����ȴ�.
	 */
	@Test
	void testPut() {
		ArrayMap arrayMap = new ArrayMap();
		arrayMap.put("�ܾ�", 1);
		arrayMap.put("�ܾ�", 1);
		assertEquals(2, arrayMap.get("�ܾ�"));
	}

	/*
	 * key���� �ߺ����� �����Ƿ� 3�� put �ص� size�� 2�̴�.
	 */
	@Test
	void testSize() {
		ArrayMap arrayMap = new ArrayMap();
		arrayMap.put("�ܾ�", 1);
		arrayMap.put("�ܾ�", 1);
		arrayMap.put("key�߰�", 1);
		assertEquals(2, arrayMap.size());
	}
}
