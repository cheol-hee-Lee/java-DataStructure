package RehashHashtable;

public class RehashHashtable {
	private Entry[] entries;
	private int size;

	/**
	 * 생성자
	 * 
	 * @param capacity 배열의 크기
	 */
	public RehashHashtable(int capacity) {
		this.entries = new Entry[capacity];
		this.size = 0;
	}

	/**
	 * key를 가진 Entry의 value를 얻는다.
	 * 
	 * @param key key
	 *
	 * @return value value
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
	 * key에 해당하는 hash를 반환한다.
	 * 
	 * @param key key
	 *
	 * @return hash hash
	 *
	 */
	public int hash(Object key) {
		if (key == null) {
			return -1;
		}
		return (key.hashCode() & 0x7fffffff) % entries.length;
	}

	/**
	 * <p>
	 * 추가한 Entry의 key, value를 출력하는 put 함수
	 * </p>
	 * <p>
	 * key를 가진 Entry가 있으면 그 위치에 key, value를 가진 Entry를 덮어쓴다. (overwrite)
	 * </p>
	 * <p>
	 * hashIndex에 null 또는 NIL이 저장되어 있으면, key, value를 가진 Entry를 삽입한다.
	 * </p>
	 * 
	 * @param key   key
	 * 
	 * @param value value
	 *
	 * @return 성공여부
	 *
	 */
	public boolean put1(Object key, Object value) {
		if (size >= entries.length * 0.7) {
			System.out.println("적재율 초과 - 재해싱");
			rehash();
		}

		System.out.printf("\"%s\" : \"%s\" 추가\n", key, value);
		int hashIndex = hash(key);

		for (int i = 0; i < entries.length; i++) {
			if (entries[hashIndex] == null) {
				entries[hashIndex] = new Entry(key, value);
				this.size++;
				return true;
			}
			if (entries[hashIndex].getKey() == key) {
				entries[hashIndex] = new Entry(key, value);
				return true;

			}

			if (entries[hashIndex].isNIL()) {
				entries[hashIndex] = new Entry(key, value);
				this.size++;
				return true;
			}
			hashIndex = (hashIndex + 1) % entries.length;
		}
		return false;
	}

	/**
	 * <p>
	 * 추가한 Entry의 key, value를 출력하지 않는 put 함수 (적재율 70%)
	 * </p>
	 * <p>
	 * key를 가진 Entry가 있으면 그 위치에 key, value를 가진 Entry를 덮어쓴다. (overwrite)
	 * </p>
	 * <p>
	 * hashIndex에 null 또는 NIL이 저장되어 있으면, 넘어간다.
	 * </p>
	 * 
	 * @param key   key
	 * 
	 * @param value value
	 *
	 * @return 성공여부
	 *
	 */
	public boolean put2(Object key, Object value) {
		if (size >= entries.length * 0.7) {
			System.out.println("적재율 초과 - 재해싱");
			rehash();
		}

		int hashIndex = hash(key);
		for (int i = 0; i < entries.length; i++) {
			if (entries[hashIndex] == null) {
				entries[hashIndex] = new Entry(key, value);
				this.size++;
				return true;
			}
			if (entries[hashIndex].isNIL()) {
				hashIndex = (hashIndex + 1) % entries.length;
				continue;
			}
			if (entries[hashIndex].getKey() == key) {
				entries[hashIndex] = new Entry(key, value);
				return true;
			}
			hashIndex = (hashIndex + 1) % entries.length;
		}
		return false;
	}

	/**
	 * key를 가진 Entry를 삭제
	 * 
	 * @param key key
	 *
	 * @return removedEntry 삭제된 Entry
	 *
	 */
	public Object remove(Object key) {
		int hashIndex = hash(key);

		for (int i = 0; i < entries.length; i++) {
			Entry entry = entries[hashIndex];

			if (entry == null) {
				return null;
			}

			if (entry.isNIL()) {
				hashIndex = (hashIndex + 1) % entries.length;
				continue;
			}

			if (entry.getKey() == key) {
				System.out.println(key + " 삭제");
				Entry removedEntry = entries[hashIndex];
				entries[hashIndex] = new Entry(null, null);
				size--;
				return removedEntry;
			}
			hashIndex = (hashIndex + 1) % entries.length;
		}
		return null;
	}

	/**
	 * size를 반환
	 * 
	 * @return size size
	 *
	 */
	public int size() {
		return this.size;
	}

	/**
	 * <p>
	 * rehash, 배열의 크기를 2배로 늘림
	 * </p>
	 * <p>
	 * null, NIL을 제외한 Entry를 rehashHashtable에 삽입한다.
	 * </p>
	 *
	 */
	public void rehash() {
		RehashHashtable rehashHT = new RehashHashtable(entries.length * 2);
		for (int i = 0; i < entries.length; i++) {
			if (entries[i] == null || entries[i].isNIL()) {
				continue;
			}
			rehashHT.put2(entries[i].getKey(), entries[i].getValue());
		}
		this.entries = rehashHT.entries;
		this.size = rehashHT.size;
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
