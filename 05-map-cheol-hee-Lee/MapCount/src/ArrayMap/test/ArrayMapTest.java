package ArrayMap.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ArrayMap.ArrayMap;

class ArrayMapTest {
	/*
	 * key를 입력해 해당 value를 얻는 함수
	 */
	@Test
	void testGet() {
		ArrayMap arrayMap = new ArrayMap();
		arrayMap.put("단어", 1);
		assertEquals(1, arrayMap.get("단어"));
	}

	/*
	 * 같은 key값에 대해 2번 put하면 value가 1 증가된다.
	 */
	@Test
	void testPut() {
		ArrayMap arrayMap = new ArrayMap();
		arrayMap.put("단어", 1);
		arrayMap.put("단어", 1);
		assertEquals(2, arrayMap.get("단어"));
	}

	/*
	 * key값을 중복되지 않으므로 3번 put 해도 size가 2이다.
	 */
	@Test
	void testSize() {
		ArrayMap arrayMap = new ArrayMap();
		arrayMap.put("단어", 1);
		arrayMap.put("단어", 1);
		arrayMap.put("key추가", 1);
		assertEquals(2, arrayMap.size());
	}
}
