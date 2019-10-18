package LinearProbing;

public class LinearProbing {
	private Entry[] entries;
	private int size;

	/**
	 * 생성자
	 * 
	 * @param capacity 배열의 크기
	 */
	public LinearProbing(int capacity) {
		this.entries = new Entry[capacity];
		this.size = 0;
	}

	/**
	 * 선형조사를 사용해 key에 해당하는 value를 반환
	 * 
	 * @param key 키
	 *
	 * @return value 키에 해당하는 value
	 *
	 */
	public Object get(Object key) {
		int hashIndex = hash(key);
		while (key != entries[hashIndex].getKey()) {
			hashIndex = (hashIndex + 1) % entries.length;
		}

		return entries[hashIndex].getValue();
	}

	/**
	 * key를 입력해 hash를 얻어낸다.
	 * 
	 * @param key 키 값
	 *
	 * @return hash 해시 값
	 *
	 */
	public int hash(Object key) {
		if (key == null) {
			return -1;
		}
		return (key.hashCode() & 0x7fffffff) % entries.length;
	}

	/**
	 * key, value를 가지는 Entry 삽입
	 * 
	 * @param key   key
	 * 
	 * @param value value
	 *
	 * @return 삽입여부 true or false
	 *
	 */
	public boolean put(Object key, Object value) {
		int hashIndex = hash(key);
		for (int i = 0; i < entries.length; i++) {
			hashIndex = (hashIndex + 1) % entries.length;
			if (entries[hashIndex] == null || entries[hashIndex].isNIL()) {
				entries[hashIndex] = new Entry(key, value);
				size++;
				return true;
			}

		}
		return false;
	}

	/**
	 * <p>
	 * key를 가지는 Entry 삭제
	 * </p>
	 * <p>
	 * hashIndex 위치에 null이 있으면 삭제하지 않는다.
	 * </p>
	 * <p>
	 * hashIndex 위치에 NIL이 있으면 hashIndex를 1 증가한다.
	 * </p>
	 * <p>
	 * key를 가지는 노드를 발견하면 그 자리를 NIL로 채운다.(삭제)
	 * </p>
	 * 
	 * @param key key
	 *
	 * @return removedEntry 삭제된 Entry
	 *
	 */
	public Object remove(Object key) {
		int hashIndex = hash(key);

		for (int i = 0; i < entries.length; i++) {
			hashIndex = (hashIndex + 1) % entries.length;

			Entry entry = entries[hashIndex];

			if (entry == null) {
				return null;
			}

			if (entry.isNIL()) {
				continue;
			}

			if (entry.getKey() == key) {
				Entry removedEntry = entries[hashIndex];
				entries[hashIndex] = new Entry(null, null);
				size--;
				return removedEntry;
			}
		}
		return null;
	}

	/**
	 * size를 반환한다.
	 * 
	 * @return size size
	 *
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Entry 배열에 저장된 모든 Entry의 key, value를 출력한다.
	 * 
	 */
	public void printEntries() {
		for (int i = 0; i < this.entries.length; i++) {
			if (this.entries[i] != null && !this.entries[i].isNIL()) {
				System.out.println("Table[" + i + "] = " + this.entries[i].getKey().toString() + ", "
						+ this.entries[i].getValue().toString());
			}
		}
	}
}
