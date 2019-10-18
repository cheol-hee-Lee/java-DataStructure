package ListMap;

public class ListMap implements Map {
	private Entry entry;
	private int size;

	public ListMap() {
		this.entry = null;
		this.size = 0;
	}

	/*
	 * key로 value를 얻는 함수
	 * 
	 * @param key
	 * 
	 * @return value
	 * 
	 */
	@Override
	public Object get(Object key) {
		Entry tmp = this.entry;

		while (tmp != null) {
			if (tmp.getKey().equals(key)) {
				return tmp.getValue();
			}
			tmp = tmp.next;
		}
		return null;
	}

	/*
	 * key, value를 저장하는 함수, key가 이미 존재한다면 value+1로 갱신한다.
	 * 
	 * @param key, value
	 * 
	 * @return 기존 value | null
	 */
	@Override
	public Object put(Object key, Object value) {
		String _tmpKey;
		String _tmpNextKey;
		String _entryKey;
		String _key = String.valueOf(key);
		Entry tmp;
		Entry newEntry;
		Entry nextEntry;
		int count;

		// key가 존재하는 경우
		tmp = entry;
		while (tmp != null) {
			if (tmp.getKey().equals(key)) {
				Integer oldValue = (Integer) tmp.getValue();
				count = oldValue + 1;
				tmp.setValue(count);
				return oldValue;
			}
			tmp = tmp.next;
		}

		// List의 크기가 0일 때, entry를 초기화한다.
		if (size == 0) {
			entry = new Entry(key, value, null);
			this.size++;
			return null;
		}

		if (size >= 1) {
			tmp = entry;
			_entryKey = String.valueOf(entry.getKey());
			while (tmp != null) {
				_tmpKey = String.valueOf(tmp.getKey());
				// entry의 키 값보다 작으면 맨 앞에 넣는다.
				if (_key.compareTo(_entryKey) < 0) {
					nextEntry = new Entry(this.entry.getKey(), this.entry.getValue(), null);
					if (entry.next != null) {
						nextEntry.setNext(entry.next);
					}
					newEntry = new Entry(key, value, nextEntry);
					this.entry = newEntry;
					this.size++;
					return null;
					// next가 비어있지 않고 entryKey보다 뒤에 있고 tmpKey보다 뒤에 있고 tmpNextKey보다 앞에 있으면 중간에 넣는다.
				} else if (tmp.next != null) {
					_tmpNextKey = String.valueOf(tmp.next.getKey());
					if (_key.compareTo(_entryKey) > 0 && _key.compareTo(_tmpKey) > 0
							&& _key.compareTo(_tmpNextKey) < 0) {
						newEntry = new Entry(key, value, tmp.next);
						tmp.next = newEntry;
						this.size++;
						return null;
					}
					// next가 비어있고 tmpKey보다 뒤에 있으면 맨 뒤에 넣는다.
				} else if (tmp.next == null && _key.compareTo(_tmpKey) > 0) {
					newEntry = new Entry(key, value, null);
					tmp.next = newEntry;
					this.size++;
					return null;
				}

				tmp = tmp.next;
			}
		}

		return null;
	}

	/*
	 * List의 size를 반환한다.
	 * 
	 * @param void
	 * 
	 * @return size
	 */
	@Override
	public int size() {
		return this.size;
	}

	/*
	 * key값에 해당하는 entry를 삭제한다.
	 * 
	 * @param key
	 * 
	 * @return true | false
	 */
	@Override
	public boolean remove(Object key) {
		if (entry == null) {
			return false;
		}

		Entry tmp = this.entry;

		while (tmp != null) {
			if (tmp.next.getKey().equals(key)) {
				Entry nextEntry = tmp.next.next;
				tmp.next = nextEntry;
				this.size--;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}

	/*
	 * ListMap의 key, value를 출력해서 보여준다.
	 * 
	 * @param void
	 * 
	 * @return void
	 */
	@Override
	public void printList() {
		Entry tmp = this.entry;

		while (tmp != null) {
			System.out.println(tmp.getKey() + " : " + tmp.getValue());
			tmp = tmp.next;
		}
	}

	/*
	 * 모든 Entry를 배열에 저장한 후 반환
	 * 
	 * @param void
	 * 
	 * @return Entry[]
	 */
	public Entry[] getEntries() {
		Entry[] entries = new Entry[size];
		Entry tmp = entry;
		int i = 0;
		while (tmp != null) {
			entries[i] = tmp;
			tmp = tmp.next;
			i++;
		}

		return entries;
	}
}
