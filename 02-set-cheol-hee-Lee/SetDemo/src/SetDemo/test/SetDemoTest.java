package SetDemo.test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import SetDemo.SetDemo;

class SetDemoTest {

	@Test
	void testSize() {
		SetDemo set = new SetDemo();
		set.add("문재인");
		set.add("이명박");
		assertEquals(2, set.size());
	}

	@Test
	void testGetFirst() {
		SetDemo set = new SetDemo();
		set.add("문재인");
		set.add("이명박");
		
		assertSame("문재인", set.getFirst());
		
	}

	@Test
	void testRemove() {
		SetDemo set = new SetDemo();
		set.add("문재인");
		set.add("이명박");
		
		assertTrue(set.remove("이명박"));
	}
}
