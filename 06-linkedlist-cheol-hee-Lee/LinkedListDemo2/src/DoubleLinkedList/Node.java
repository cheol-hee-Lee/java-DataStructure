package DoubleLinkedList;

public class Node {
	/**
	 * data
	 */
	public Object data;
	/**
	 * 다음 노드
	 */
	public Node next;

	/**
	 * 이전 노드
	 */
	public Node prev;

	/**
	 * input data를 갖는 노드를 생성
	 * 
	 * @param input 값
	 */
	public Node(Object input) {
		this.data = input;
		this.next = null;
		this.prev = null;
	}

	public String toString() {
		return String.valueOf(this.data);
	}
}
