package DoubleLinkedList;

public interface LinkedList {

	/**
	 * 처음에 노드를 추가
	 * 
	 * @param input 값
	 */
	void addFirst(Object input);

	/**
	 * 마지막에 노드를 추가
	 * 
	 * @param input 값
	 */
	void addLast(Object input);

	/**
	 * k번째에 노드를 추가
	 * 
	 * @param k 위치
	 * @param input 값
	 */
	void add(int k, Object input);

	/**
	 * 처음 노드를 삭제
	 * 
	 * @return Object 삭제된 노드
	 */
	Object removeFirst();

	/**
	 * 마지막 노드를 삭제
	 * 
	 * @return Object 삭제된 노드
	 */
	Object removeLast();

	/**
	 * k번째 노드를 삭제
	 * 
	 * @param k 위치
	 * @return 삭제된 노드
	 */
	Object remove(int k);

	/**
	 * data를 가진 노드의 index를 반환
	 * 
	 * @param data 값
	 * @return index 위치
	 */
	int indexOf(Object data);

	/**
	 * k번쨰 노드의 data를 반환
	 * 
	 * @param k 위치
	 * @return data 값
	 */
	Object get(int k);

	/**
	 * k번째 노드를 반환
	 * 
	 * @param index 위치
	 * @return Node 해당 노드
	 */
	Node node(int index);

	/**
	 * 크기를 반환
	 * 
	 * @return size 크기
	 */
	int size();
}
