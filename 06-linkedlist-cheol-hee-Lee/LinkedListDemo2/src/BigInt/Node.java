package BigInt;

public class Node {
	/**
	 * Node가 저장하는 값
	 */
	public Object data;

	/**
	 * 다음 Node
	 */
	public Node next;
	/**
	 * 이전 Node
	 */
	public Node prev;

	/**
	 * 입력값을 저장한 Node를 생성
	 * 
	 * @param input 값
	 */
	public Node(Object input) {
		this.data = input;
		this.prev = null;
		this.next = null;
	}

	/**
	 * input, 이전 Node, 다음 Node를 저장한 Node를 생성
	 * 
	 * @param input 값
	 * @param prev  이전 노드
	 * @param next  다음 노드
	 */
	public Node(Object input, Node prev, Node next) {
		this.data = input;
		this.prev = prev;
		this.next = next;
	}

	/**
	 * @return data 숫자값
	 */
	public int getDigit() {
		return Integer.parseInt(String.valueOf(data));
	}

	/**
	 * data를 반환한다.
	 * 
	 * @return data 값
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @return next 다음 노드
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @return prev 이전 노드
	 */
	public Node getPrev() {
		return prev;
	}

	/**
	 * data를 수정한다.
	 * 
	 * @param data 값
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * next를 수정한다.
	 * 
	 * @param next 다음 노드
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * prev를 수정한다.
	 * 
	 * @param prev 이전 노드
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}

}
