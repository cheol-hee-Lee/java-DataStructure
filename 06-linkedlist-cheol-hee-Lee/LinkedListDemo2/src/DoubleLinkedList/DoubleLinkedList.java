package DoubleLinkedList;

public class DoubleLinkedList implements LinkedList {
	/**
	 * 처음 노드
	 */
	private Node head;
	/**
	 * 마지막 노드
	 */
	private Node tail;
	/**
	 * 크기
	 */
	private int size = 0;

	@Override
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;

		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;

		if (head.next == null) {
			tail = head;
		}

		size++;
	}

	@Override
	public void addLast(Object input) {
		Node newNode = new Node(input);

		if (size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;

			size++;
		}
	}

	@Override
	public void add(int k, Object input) {
		if (k == 0) {
			addFirst(input);
		} else {
			Node temp1 = node(k - 1);
			Node temp2 = temp1.next;
			Node newNode = new Node(input);

			temp1.next = newNode;
			newNode.next = temp2;

			if (temp2 != null) {
				temp2.prev = newNode;
			}
			newNode.prev = temp1;

			if (newNode.next == null) {
				tail = newNode;
			}

			size++;
		}
	}

	@Override
	public Object removeFirst() {
		Node temp = head;
		head = head.next;
		Object returnData = temp.data;
		temp = null;
		if (head != null) {
			head.prev = null;
		}
		size--;

		return returnData;
	}

	@Override
	public Object removeLast() {
		return remove(size - 1);
	}

	@Override
	public Object remove(int k) {
		if (k == 0) {
			return removeFirst();
		}
		Node temp = node(k - 1);
		Node todoDeleted = temp.next;
		temp.next = temp.next.next;

		if (temp.next != null) {
			temp.next.prev = temp;
		}

		Object returnData = todoDeleted.data;
		if (todoDeleted == tail) {
			tail = temp;
		}
		todoDeleted = null;
		size--;

		return returnData;
	}

	@Override
	public int indexOf(Object data) {
		Node temp = head;
		int index = 0;
		while (temp.data != data) {
			temp = temp.next;
			index++;
			if (temp == null) {
				return -1;
			}
		}
		return index;
	}

	@Override
	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}

	@Override
	public Node node(int index) {
		if (index < size / 2) {
			Node x = head;

			for (int i = 0; i < index; i++) {
				x = x.next;
			}

			return x;
		} else {
			Node x = tail;

			for (int i = size - 1; i > index; i--) {
				x = x.prev;
			}

			return x;
		}

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if (head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";

		while (temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}

		str += temp.data;

		return str + "]";
	}
}
