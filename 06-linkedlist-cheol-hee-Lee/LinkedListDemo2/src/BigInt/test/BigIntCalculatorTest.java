package BigInt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import BigInt.BigInt;
import BigInt.BigIntCalculator;

class BigIntCalculatorTest {

	/**
	 * 덧셈 테스트
	 */
	@Test
	void testAddBigInt() {
		BigIntCalculator bc = new BigIntCalculator();
		String a = "590156784295421";
		String b = "549123542478219";
		BigInt aBigInt = new BigInt(a);
		BigInt bBigInt = new BigInt(b);

		assertEquals("1139280326773640", bc.addBigInt(aBigInt, bBigInt).printBigInt());
	}

	/**
	 * 뺄셈 테스트 10000 - 1 포함
	 */
	@Test
	void testSubtractBigInt() {
		BigIntCalculator bc = new BigIntCalculator();
		String a, b;
		BigInt aBigInt, bBigInt;

		a = "590156784295421";
		b = "549123542478219";
		aBigInt = new BigInt(a);
		bBigInt = new BigInt(b);
		System.out.println();
		assertEquals("41033241817202", bc.subtractBigInt(aBigInt, bBigInt).printBigInt());

		a = "10000";
		b = "1";
		aBigInt = new BigInt(a);
		bBigInt = new BigInt(b);
		System.out.println();
		assertEquals("9999", bc.subtractBigInt(aBigInt, bBigInt).printBigInt());

	}

}
