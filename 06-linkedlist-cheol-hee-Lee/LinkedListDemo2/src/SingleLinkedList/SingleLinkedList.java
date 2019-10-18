package SingleLinkedList;

public class SingleLinkedList implements LinkedList {
	/**
	 * 처음 노드
	 */
	private Node head;
	/**
	 * 크기
	 */
	private int size;

	/**
	 * 크기가 0인 LinkedList를 생성
	 */
	public SingleLinkedList() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public boolean insert(Object data) {
		// 리스트에 노드가 없을 때
		if (this.head == null) {
			this.head = new Node(data, null);
			this.size++;
			return true;
		} else { // 리스트에 노드가 존재하면
			Node tmp = this.head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			// 리스트의 마지막에 data를 가진 Node를 생성한 후 대입한다.
			tmp.next = new Node(data, null);
			this.size++;
			return true;
		}
	}

	@Override
	public boolean delete(Object target) {
		// 리스트에 노드가 없을 때
		if (this.head == null) {
			return false;
		}
		// 리스트에 노드가 있을 때
		Node tmp = this.head;
		Node prevTmp = null;

		// 리스트의 마지막까지 target을 가진 노드를 검색한다.
		while (tmp != null) {
			// 검색이 성공하면
			if (tmp.getData().equals(target)) {
				// 다음 노드를 저장한다.
				Node nextNode = tmp.next;
				// 이전 노드가 없으면
				if (prevTmp == null) {
					head = nextNode;
				} else { // 이전 노드의 바로 다음 노드에 nextNode를 저장한다.
					prevTmp.next = nextNode;
				}
				this.size--;
				return true;
			}
			// prevTmp, tmp를 한 칸 이동한다.
			prevTmp = tmp;
			tmp = tmp.next;
		}
		return false;
	}

	@Override
	public boolean contains(Object searchingData) {
		// 처음 노드로 초기화한다.
		Node tmp = this.head;

		// 모든 노드를 검색한다.
		while (tmp.next != null) {
			// searchingData를 가진 노드를 발견하면 true를 반환한다.
			System.out.println(tmp.getData() + " : " + searchingData);
			if (tmp.getData().equals(searchingData)) {
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void printList() {
		Node tmp = this.head;

		while (tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.next;
		}
	}

}
