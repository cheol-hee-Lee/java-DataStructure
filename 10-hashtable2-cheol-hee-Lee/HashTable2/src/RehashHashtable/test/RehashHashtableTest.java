package RehashHashtable.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import RehashHashtable.RehashHashtable;

class RehashHashtableTest {

	@Test
	void testGet() {
		RehashHashtable hashTable = new RehashHashtable(10);

		System.out.println("* Put Test ---------------------------");
		hashTable.put2("김소월", "진달래꽃");
		hashTable.put2("현진건", "운수 좋은 날");
		hashTable.put2("김유정", "동백꽃");
		hashTable.put2("최인훈", "광장");
		hashTable.put2("박목월", "보랏빛 소묘");

		assertEquals("광장", hashTable.get("최인훈"));
	}

	@Test
	void testPut2() {
		RehashHashtable hashTable = new RehashHashtable(10);
		hashTable.put2("김소월", "진달래꽃");
		hashTable.put2("현진건", "운수 좋은 날");
		hashTable.put2("김유정", "동백꽃");
		hashTable.put2("최인훈", "광장");
		hashTable.put2("박목월", "보랏빛 소묘");

		assertEquals(5, hashTable.size());
	}

	@Test
	void testRemove() {
		RehashHashtable hashTable = new RehashHashtable(10);
		hashTable.put2("김소월", "진달래꽃");
		hashTable.put2("현진건", "운수 좋은 날");
		hashTable.put2("김유정", "동백꽃");
		hashTable.put2("최인훈", "광장");
		hashTable.put2("박목월", "보랏빛 소묘");

		hashTable.remove("김소월");
		hashTable.remove("최인훈");
		hashTable.remove("박목월");

		assertEquals(2, hashTable.size());
	}

}
