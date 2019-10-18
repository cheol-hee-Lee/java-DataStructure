package Solution;

import java.util.LinkedList;

public class SolutionHashTable {
	private LinkedList<Entry>[] listArray;
	private int size;

	/**
	 * 생성자
	 * 
	 * @param capacity 링크드리스트를 원소로 갖는 배열의 크기
	 */
	public SolutionHashTable(int capacity) {
		this.listArray = new LinkedList[capacity];
		this.size = 0;
	}

	/**
	 * key로 value를 찾아냄
	 * 
	 * @param key value를 찾아내기 위한 key값
	 *
	 * @return value key로 찾은 value
	 *
	 */
	public Object get(Object key) {
		int hashIndex = hash(key);

		if (listArray[hashIndex] == null) {
			return null;
		}
		LinkedList<Entry> list = listArray[hashIndex];
		if (getEntry(list, key) == null) {
			return null;
		}
		Entry entry = getEntry(list, key);
		return entry.getValue();
	}

	/**
	 * <p>
	 * key, value를 입력해 Entry를 HashTable에 삽입
	 * </p>
	 * <p>
	 * 1. Entry(key, value) 생성
	 * </p>
	 * <p>
	 * 2. hashIndex 위치에 list가 없다면 list를 생성한 후 Entry 삽입
	 * </p>
	 * <p>
	 * 3. hashIndex 위치에 list가 있다면 해당 리스트에 Entry 삽입
	 * </p>
	 * <p>
	 * 4. size 1 증가
	 * </p>
	 * 
	 * @param key   Entry의 key
	 * @param value Entry의 value
	 *
	 */
	public void put(Object key, Object value) {
		Entry newEntry = new Entry(key, value);
		int hashIndex = hash(key);

		if (listArray[hashIndex] == null) {
			LinkedList<Entry> list = new LinkedList<Entry>();
			list.add(newEntry);
			listArray[hashIndex] = list;
			size++;
			return;
		}
		LinkedList<Entry> list = listArray[hashIndex];
		list.add(newEntry);
		size++;
		return;
	}

	/**
	 * <p>
	 * key를 입력받아 Entry를 삭제
	 * </p>
	 * <p>
	 * 1. hashIndex를 계산하여 해당 위치의 list가 없으면 null 반환
	 * </p>
	 * <p>
	 * 2. 해당 위치의 list가 있다면, list 내부에 key값을 가진 Entry를 찾아 제거
	 * </p>
	 * 
	 * @param key 삭제할 Entry의 key
	 *
	 * @return removedEntry 삭제된 Entry
	 *
	 */
	public Object remove(Object key) {
		int hashIndex = hash(key);
		LinkedList<Entry> list = listArray[hashIndex];
		if (list == null) {
			return null;
		}
		Entry removedEntry = getEntry(list, key);
		if (removedEntry == null) {
			return null;
		}

		list.remove(removedEntry);
		size--;
		if (list.size() == 0) {
			listArray[hashIndex] = null;
		}
		return removedEntry;
	}

	/**
	 * key에 해당하는 hash값을 반환
	 * 
	 * @param key key
	 *
	 * @return hashIndex key에 해당하는 hashIndex를 반환
	 *
	 */
	public int hash(Object key) {
		if (key == null) {
			return -1;
		}
		return (key.hashCode() & 0x7fffffff) % listArray.length;
	}

	/**
	 * list와 key를 입력해 해당 list의 Entry를 반환
	 * 
	 * @param list Entry를 원소로 갖는 LinkedList
	 * 
	 * @param key  검색할 Entry의 key
	 * 
	 * @return Entry key를 가진 Entry
	 *
	 */
	public Entry getEntry(LinkedList<Entry> list, Object key) {
		for (int i = 0; i < list.size(); i++) {
			Object existingKey = list.get(i).getKey();
			if (existingKey == key) { // 검사
				Entry returnedEntry = list.get(i);
				return returnedEntry;
			}
		}
		return null;
	}

	/**
	 * size를 반환
	 * 
	 * @return size
	 *
	 */
	public int size() {
		return this.size;
	}

	/**
	 * HashTable에 존재하는 모든 Entry의 key, value를 출력
	 *
	 */
	public void printEntries() {
		for (int i = 0; i < this.listArray.length; i++) {
			LinkedList<Entry> list = listArray[i];
			if (list != null) {
				System.out.print("Table[" + i + "] = ");
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j) != null) {
						Entry entry = list.get(j);
						System.out.print(entry.getKey().toString() + ", " + entry.getValue().toString());
						if (j < list.size() - 1) {
							System.out.print(" -> ");
						}
					}
				}
				System.out.println();
			}

		}
	}
}
