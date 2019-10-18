package ListMap;

public class ListMap implements Map {
	private Entry entry;
	private int size;

	public ListMap() {
		this.entry = null;
		this.size = 0;
	}

	/*
	 * key�� value�� ��� �Լ�
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
	 * key, value�� �����ϴ� �Լ�, key�� �̹� �����Ѵٸ� value+1�� �����Ѵ�.
	 * 
	 * @param key, value
	 * 
	 * @return ���� value | null
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

		// key�� �����ϴ� ���
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

		// List�� ũ�Ⱑ 0�� ��, entry�� �ʱ�ȭ�Ѵ�.
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
				// entry�� Ű ������ ������ �� �տ� �ִ´�.
				if (_key.compareTo(_entryKey) < 0) {
					nextEntry = new Entry(this.entry.getKey(), this.entry.getValue(), null);
					if (entry.next != null) {
						nextEntry.setNext(entry.next);
					}
					newEntry = new Entry(key, value, nextEntry);
					this.entry = newEntry;
					this.size++;
					return null;
					// next�� ������� �ʰ� entryKey���� �ڿ� �ְ� tmpKey���� �ڿ� �ְ� tmpNextKey���� �տ� ������ �߰��� �ִ´�.
				} else if (tmp.next != null) {
					_tmpNextKey = String.valueOf(tmp.next.getKey());
					if (_key.compareTo(_entryKey) > 0 && _key.compareTo(_tmpKey) > 0
							&& _key.compareTo(_tmpNextKey) < 0) {
						newEntry = new Entry(key, value, tmp.next);
						tmp.next = newEntry;
						this.size++;
						return null;
					}
					// next�� ����ְ� tmpKey���� �ڿ� ������ �� �ڿ� �ִ´�.
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
	 * List�� size�� ��ȯ�Ѵ�.
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
	 * key���� �ش��ϴ� entry�� �����Ѵ�.
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
	 * ListMap�� key, value�� ����ؼ� �����ش�.
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
	 * ��� Entry�� �迭�� ������ �� ��ȯ
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
