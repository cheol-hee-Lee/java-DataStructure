package ArrayBag.test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ArrayBag.ArrayBag;

class ArrayBagTest {

	@Test
	void testSize() {
		ArrayBag ab = new ArrayBag();
		ab.add("Hi");
		assertEquals(1, ab.size());
	}

	@Test
	void testRemove() {
		ArrayBag ab = new ArrayBag();
		ab.add("Hi");
		assertTrue(ab.remove("Hi"));
	}
	
	@Test
	void testGetFirst() {
		ArrayBag ab = new ArrayBag();
		ab.add("1");
		assertSame("1", ab.getFirst());
	}



}
