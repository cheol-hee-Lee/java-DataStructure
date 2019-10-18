package BigInt;

public class BigIntCalculator {

	/**
	 * a + b를 계산하여 BigInt 형태로 반환
	 * 
	 * @param a 앞 항
	 * @param b 뒷 항
	 * @return BigInt 더한 값
	 */
	public BigInt addBigInt(BigInt a, BigInt b) {
		Node aNode = a.head;
		Node bNode = b.head;

		int n = aNode.getDigit() + bNode.getDigit();

		// 1의 자리 수 저장
		BigInt result = new BigInt(String.valueOf(n % 10));

		Node resultTmp = result.head;

		aNode = aNode.next;
		bNode = bNode.next;
		// a, b의 자리가 비어있지 않다면 반복한다.
		while (aNode != null && bNode != null) {
			n = n / 10 + aNode.getDigit() + bNode.getDigit();
			resultTmp.next = new Node(n % 10, resultTmp, null);
			aNode = aNode.next;
			bNode = bNode.next;
			resultTmp = resultTmp.next;
		}
		// a의 자리가 비어있지 않다면 반복한다. (b의 자리가 비어있을 때)
		while (aNode != null) {
			// a의 값을 차례대로 저장한다.
			n = n / 10 + aNode.getDigit();
			resultTmp.next = new Node(n % 10, resultTmp, null);
			aNode = aNode.next;
			resultTmp = resultTmp.next;
		}
		// b의 자리가 비어있지 않다면 반복한다. (a의 자리가 비어있을 때)
		while (bNode != null) {
			// b의 값을 차례대로 저장한다.
			n = n / 10 + bNode.getDigit();
			resultTmp.next = new Node(n % 10, resultTmp, null);
			bNode = bNode.next;
			resultTmp = resultTmp.next;
		}

		if (n > 9) {
			resultTmp.next = new Node(n / 10, resultTmp, null);
		}

		return result;
	}

	/**
	 * a - b를 계산하여 BigInt 형태로 반환
	 * 
	 * @param a 앞 항
	 * @param b 뒷 항
	 * @return a - b 뺀 값
	 */
	public BigInt subtractBigInt(BigInt a, BigInt b) {
		Node a_Node = a.head;
		Node b_Node = b.head;

		int a_Int = a_Node.getDigit();
		int b_Int = b_Node.getDigit();
		int result_Int;

		if (isNegative(a_Int - b_Int)) {
			borrow(a_Node);
			result_Int = subtract(a_Int, b_Int);
		} else {
			result_Int = subtract(a_Int, b_Int);
		}
		BigInt result = new BigInt(String.valueOf(result_Int));

		a_Node = a_Node.next;
		b_Node = b_Node.next;

		// a, b의 자리가 비어있지 않다면 반복한다.
		while (a_Node != null && b_Node != null) {
			a_Int = a_Node.getDigit();
			b_Int = b_Node.getDigit();
			result_Int = subtract(a_Int, b_Int);

			if (isNegative(a_Int - b_Int)) {
				borrow(a_Node);
				result_Int = subtract(a_Int, b_Int);
			} else {
				result_Int = subtract(a_Int, b_Int);
			}

			result.addLast(result_Int);
			a_Node = a_Node.next;
			b_Node = b_Node.next;
		}
		while (a_Node != null) {
			result_Int = a_Node.getDigit();
			result.addLast(result_Int);
			a_Node = a_Node.next;
		}
		while (b_Node != null) {
			result_Int = b_Node.getDigit();
			result.addLast(result_Int);
			b_Node = b_Node.next;
		}

		Node tmp = result.tail;
		while (tmp.getDigit() == 0) {
			tmp.prev.next = null;
			tmp = tmp.prev;
		}

		return result;
	}

	/**
	 * a_Node.next에서 10을 빌려옴
	 * 
	 * @param a_Node 10을 빌려올 Node
	 */
	private void borrow(Node a_Node) {
		if (a_Node.next.getDigit() == 0) {
			a_Node.next.setData(9);
			borrow(a_Node.next);
		} else {
			a_Node.next.setData(a_Node.next.getDigit() - 1);
		}
	}

	/**
	 * 한 자리 내에서의 뺄셈의 결과를 구한다.
	 * 
	 * @param a_Int 앞 항
	 * @param b_Int 뒷 항
	 * @return result 뺀 값
	 */
	private int subtract(int a_Int, int b_Int) {
		int result;
		if (a_Int < b_Int) {
			result = 10 + a_Int - b_Int;
		} else {
			result = a_Int - b_Int;
		}
		return result;
	}

	/**
	 * i가 음수인지 판별한다.
	 * 
	 * @param i 검사할 대상
	 * @return boolean true | false
	 */
	private boolean isNegative(int i) {
		if (i < 0) {
			return true;
		}
		return false;
	}

}
