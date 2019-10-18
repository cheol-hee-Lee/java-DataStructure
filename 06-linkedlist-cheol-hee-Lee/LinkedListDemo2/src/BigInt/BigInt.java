package BigInt;

/**
 * Date Apr 17-2018
 * @author cheol-hee-lee
 *
 */
public class BigInt {
	public Node head;
	public Node tail;

	/**
	 * BigInt의 생성자
	 * 
	 * @param bigIntStrValue 문자열로 된 숫자
	 */
	public BigInt(String bigIntStrValue) {
		// 20자리 수를 저장한다고 가정할 때, 20번째 수를 bigIntValue에 대입
		String strValue;

		// 19번째 부터 0번째 까지 리스트에 거꾸로 저장된다
		for (int i = bigIntStrValue.length() - 1; i >= 0; i--) {
			strValue = bigIntStrValue.substring(i, i + 1);
			addLast(strValue);
		}
	}

	/**
	 * data를 입력받아 Double Linked List의 구조를 가지는 BigInt의 처음에 노드를 추가
	 * 
	 * @param input 값
	 */
	public void addFirst(Object input) {
		Node newNode = new Node(Integer.parseInt(String.valueOf(input)));
		newNode.next = head;

		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;

		if (head.next == null) {
			tail = head;
		}
	}

	/**
	 * data를 입력받아 Double Linked List의 구조를 가지는 BigInt의 마지막에 노드를 추가
	 * 
	 * @param input 값
	 */
	public void addLast(Object input) {
		Node newNode = new Node(Integer.parseInt(String.valueOf(input)));

		if (head == null) {
			addFirst(input);
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	/**
	 * BigInt의 모든 Node에 저장된 수를 String으로 반환
	 * 
	 * @return String 문자열로 된 숫자
	 */
	public String printBigInt() {
		Node tmp = head;
		String digitStr = "";

		// 0번째 부터 수를 왼쪽에 붙여가면서 문자열로된 숫자를 만든다.
		while (tmp != null) {
			digitStr = tmp.getData() + digitStr;
			tmp = tmp.next;
		}
		return digitStr.toString();
	}

}
