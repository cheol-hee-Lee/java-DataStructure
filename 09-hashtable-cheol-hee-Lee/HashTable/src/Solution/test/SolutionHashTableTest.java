package Solution.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Solution.SolutionHashTable;

class SolutionHashTableTest {

	@Test
	void testGet() {
		SolutionHashTable libraryHashTable = new SolutionHashTable(15);
		System.out.println("* Put Test ---------------------------");
		libraryHashTable.put("김소월", "진달래꽃");
		assertEquals("진달래꽃", libraryHashTable.get("김소월"));
	}

	@Test
	void testPut() {
		SolutionHashTable libraryHashTable = new SolutionHashTable(15);
		libraryHashTable.put("김소월", "진달래꽃");
		assertEquals(1, libraryHashTable.size());
	}

	@Test
	void testRemove() {
		SolutionHashTable libraryHashTable = new SolutionHashTable(15);
		/*	7개 추가	*/
		libraryHashTable.put("김소월", "진달래꽃");
		libraryHashTable.put("현진건", "운수 좋은 날");
		libraryHashTable.put("김유정", "동백꽃");
		libraryHashTable.put("최인훈", "광장");
		libraryHashTable.put("정지용", "향수");
		libraryHashTable.put("이육사", "청포도");
		libraryHashTable.put("박목월", "보랏빛 소묘");
		/*	2개 삭제	*/
		libraryHashTable.remove("최인훈");
		libraryHashTable.remove("김소월");
		assertEquals(5, libraryHashTable.size());
	}

	@Test
	void testSize() {
		SolutionHashTable libraryHashTable = new SolutionHashTable(15);
		assertEquals(0, libraryHashTable.size());
	}


}
