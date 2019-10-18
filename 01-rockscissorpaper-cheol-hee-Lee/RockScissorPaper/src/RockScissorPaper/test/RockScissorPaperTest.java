package RockScissorPaper.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import RockScissorPaper.RockScissorPaper;

class RockScissorPaperTest {

	@Test
	void testWhoIsWinner1() {
		assertEquals("USER", RockScissorPaper.whoIsWinner("바위", "가위"));
	}

	@Test
	void testWhoIsWinner2() {
		assertEquals("USER", RockScissorPaper.whoIsWinner("바위", "보"));
	}

	@Test
	void testWhoIsWinner3() {
		assertEquals("USER", RockScissorPaper.whoIsWinner("가위", "가위"));
	}

	@Test
	void testWhoIsWinner4() {
		assertEquals("USER", RockScissorPaper.whoIsWinner("보", "가위"));
	}

	@Test
	void testWhoIsWinner5() {
		assertEquals("무승부", RockScissorPaper.whoIsWinner("바위", "가위"));
	}

	@Test
	void testWhoIsWinner6() {
		assertEquals("무승부", RockScissorPaper.whoIsWinner("보", "보"));
	}

	@Test
	void testWhoIsWinner7() {
		assertEquals("무승부", RockScissorPaper.whoIsWinner("보", "가위"));
	}

	@Test
	void testWhoIsWinner8() {
		assertEquals("PC", RockScissorPaper.whoIsWinner("바위", "바위"));
	}

	@Test
	void testWhoIsWinner9() {
		assertEquals("PC", RockScissorPaper.whoIsWinner("가위", "바위"));
	}

	@Test
	void testWhoIsWinner10() {
		assertEquals("PC", RockScissorPaper.whoIsWinner("보", "가위"));
	}
}
