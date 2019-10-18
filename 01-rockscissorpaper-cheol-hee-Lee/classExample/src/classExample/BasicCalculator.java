package classExample;

public class BasicCalculator {

	public int Addition(int a, int b) {
		return a + b;
	}

	public int Subtraction(int a, int b) {
		return a - b;
	}

	public int Multiplication(int a, int b) {
		return a * b;
	}

	public double Division(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException();
		}
		
		return (double) a / (double) b;
	}

}
