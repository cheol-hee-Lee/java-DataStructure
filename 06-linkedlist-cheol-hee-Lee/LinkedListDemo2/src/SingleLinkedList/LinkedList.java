package SingleLinkedList;

public interface LinkedList {

	/**
	 * data를 가진 노드를 삽입하고 성공 여부를 반환
	 * 
	 * @param data 값
	 * @return boolean 성공 여부
	 */
	public boolean insert(Object data);

	/**
	 * data를 가진 노드를 삭제하고 성공 여부를 반환
	 * 
	 * @param target 삭제할 값
	 * @return boolean 성공 여부
	 */
	public boolean delete(Object target);

	/**
	 * 해당 data를 가진 노드가 있는지 여부를 반환
	 * 
	 * @param searchingData 찾을 값
	 * @return boolean 찾았는지 여부
	 */
	public boolean contains(Object searchingData);

	/**
	 * 크기를 반환
	 * 
	 * @return size 크기
	 */
	public int size();

	/**
	 * Linked List에 저장된 data를 출력
	 */
	public void printList();
}
