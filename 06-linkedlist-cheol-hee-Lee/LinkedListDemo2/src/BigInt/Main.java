package BigInt;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		BigIntCalculator bc = new BigIntCalculator();
		int a_Int;
		int b_Int;
		String a_String;
		String b_String;
		String result_String;
		boolean equals = false;
		BigInt a_BigInt;
		BigInt b_BigInt;
		Random random = new Random();

		System.out.println("* BigInt 계산기");
		System.out.println("-----------------------------------------------");
		System.out.println("* 덧셈");

		for (int i = 0; i < 10; i++) {
			a_Int = 1000000000;
			b_Int = random.nextInt(1000000000);
			a_String = String.valueOf(a_Int);
			b_String = String.valueOf(b_Int);
			a_BigInt = new BigInt(a_String);
			b_BigInt = new BigInt(b_String);

			System.out.print(a_String + " + " + b_String + " = ");
			result_String = bc.addBigInt(a_BigInt, b_BigInt).printBigInt();
			equals = (a_Int + b_Int == Integer.parseInt(result_String));
			if (equals) {
				System.out.println(result_String + " (" + equals + ")");
			}
		}

		System.out.println("-----------------------------------------------");
		System.out.println("* 뺄셈");

		for (int i = 0; i < 10; i++) {
			a_Int = 2100000000;
			b_Int = random.nextInt(2100000000);
			a_String = String.valueOf(a_Int);
			b_String = String.valueOf(b_Int);
			a_BigInt = new BigInt(a_String);
			b_BigInt = new BigInt(b_String);

			System.out.print(a_String + " - " + b_String + " = ");
			result_String = bc.subtractBigInt(a_BigInt, b_BigInt).printBigInt();

			equals = (a_Int - b_Int == Integer.parseInt(result_String));
			if (equals) {
				System.out.println(result_String + " (" + equals + ")");
			}
		}

	}
}
