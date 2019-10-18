package classExample.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import classExample.BasicCalculator;

class BasicCalculatorTest {
	@Test
	void testAddition() {
		BasicCalculator basicCalculator = new BasicCalculator();
		assertEquals(5, basicCalculator.Addition(2, 3));
	}
	@Test
	void testSubstraction() {
		BasicCalculator basicCalculator = new BasicCalculator();
		assertEquals(6, basicCalculator.Subtraction(13, 7));
	}
	@Test
	void testMultiplication() {
		BasicCalculator basicCalculator = new BasicCalculator();
		assertEquals(63, basicCalculator.Multiplication(7, 9));
	}
	@Test
	void testDivision() {
		BasicCalculator basicCalculator = new BasicCalculator();
		assertEquals(5, basicCalculator.Division(25, 5));
	}
	@Test
	void testDivideByZero() {
		boolean thrown = false;
		BasicCalculator basicCalculator = new BasicCalculator();
		try {
			basicCalculator.Division(40, 0);
		} catch (ArithmeticException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
}
