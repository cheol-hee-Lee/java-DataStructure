package ListMap;

public class ListMap implements Map {
	private Entry entry;
	private int size;

	public ListMap() {
		this.entry = null;
		this.size = 0;
	}

	/*
	 * key에 해당하는 value를 반환한다.
	 * 
	 * @param key
	 * 
	 * @return value
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
	 * key, value를 입력 받는다. ListMap에 key가 존재하면 value값을 변경한다. size = 0 이면 새로운 Entry를
	 * entry 변수에 넣는다. 키 값인 _entryKey, _key, _tmpKey를 비교하며 key, value를 가진 Entry를 어디에
	 * 삽입할 지 결정한다.
	 * 
	 * @param key, value
	 * 
	 * @return oldValue | null
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

		// key값이 이미 존재하면
		tmp = entry;
		while (tmp != null) {
			if (tmp.getKey().equals(key)) {
				Object oldValue = tmp.getValue();
				tmp.setValue(value);
				return oldValue;
			}
			tmp = tmp.next;
		}

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
				// 맨 앞에 삽입
				if (_key.compareTo(_entryKey) < 0) {
					nextEntry = new Entry(this.entry.getKey(), this.entry.getValue(), null);
					if (entry.next != null) {
						nextEntry.setNext(entry.next);
					}
					newEntry = new Entry(key, value, nextEntry);
					this.entry = newEntry;
					this.size++;
					return null;
					// 중간에 삽입
				} else if (tmp.next != null) {
					_tmpNextKey = String.valueOf(tmp.next.getKey());
					if (_key.compareTo(_entryKey) > 0 && _key.compareTo(_tmpKey) > 0
							&& _key.compareTo(_tmpNextKey) < 0) {
						newEntry = new Entry(key, value, tmp.next);
						tmp.next = newEntry;
						this.size++;
						return null;
					}
					// 맨뒤에 삽입
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
	 * size를 반환
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
	 * key에 해당하는 Entry를 삭제한다.
	 * 
	 * @param key
	 * 
	 * @return 삭제가 성공했는지 여부, true | false
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
	 * ListMap내의 Entry의 key와 value를 출력한다.
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
}
