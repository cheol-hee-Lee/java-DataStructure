package SingleLinkedList;

public class Node {
	/**
	 * 값
	 */
	private Object data;
	/**
	 * 다음 노드
	 */
	public Node next;

	/**
	 * 생성자
	 * 
	 * @param data 값
	 * @param next 다음 노드
	 */
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * 값을 반환
	 * 
	 * @return data 값
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 다음 노드를 반환
	 * 
	 * @return next nextNode
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * 값을 설정
	 * 
	 * @param data 설정할 값
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * 다음 노드를 설정
	 * 
	 * @param next nextNode
	 */
	public void setNext(Node next) {
		this.next = next;
	}
}
