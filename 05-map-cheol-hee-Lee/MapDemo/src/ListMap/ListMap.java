package ListMap;

public class ListMap implements Map {
	private Entry entry;
	private int size;

	public ListMap() {
		this.entry = null;
		this.size = 0;
	}

	/*
	 * key�� �ش��ϴ� value�� ��ȯ�Ѵ�.
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
	 * key, value�� �Է� �޴´�. ListMap�� key�� �����ϸ� value���� �����Ѵ�. size = 0 �̸� ���ο� Entry��
	 * entry ������ �ִ´�. Ű ���� _entryKey, _key, _tmpKey�� ���ϸ� key, value�� ���� Entry�� ���
	 * ������ �� �����Ѵ�.
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

		// key���� �̹� �����ϸ�
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
				// �� �տ� ����
				if (_key.compareTo(_entryKey) < 0) {
					nextEntry = new Entry(this.entry.getKey(), this.entry.getValue(), null);
					if (entry.next != null) {
						nextEntry.setNext(entry.next);
					}
					newEntry = new Entry(key, value, nextEntry);
					this.entry = newEntry;
					this.size++;
					return null;
					// �߰��� ����
				} else if (tmp.next != null) {
					_tmpNextKey = String.valueOf(tmp.next.getKey());
					if (_key.compareTo(_entryKey) > 0 && _key.compareTo(_tmpKey) > 0
							&& _key.compareTo(_tmpNextKey) < 0) {
						newEntry = new Entry(key, value, tmp.next);
						tmp.next = newEntry;
						this.size++;
						return null;
					}
					// �ǵڿ� ����
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
	 * size�� ��ȯ
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
	 * key�� �ش��ϴ� Entry�� �����Ѵ�.
	 * 
	 * @param key
	 * 
	 * @return ������ �����ߴ��� ����, true | false
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
	 * ListMap���� Entry�� key�� value�� ����Ѵ�.
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
