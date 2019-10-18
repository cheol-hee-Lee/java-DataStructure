package ArrayMap;

public class ArrayMap implements Map {
	private static final int INITIAL_SIZE = 100;
	private Entry[] entryArray;
	private int size;

	/*
	 * Entry �迭, ArrayMap�� size�� �ʱ�ȭ�ϴ� ������
	 */
	public ArrayMap() {
		this.entryArray = new Entry[INITIAL_SIZE];
		this.size = 0;
	}

	/*
	 * key�� value�� ���� �Լ�
	 * 
	 * @param key
	 * 
	 * @return value
	 */
	@Override
	public Object get(Object key) {
		for (int i = 0; i < this.size; i++) {
			if (this.entryArray[i].getKey().equals(key)) {
				return this.entryArray[i].getValue();
			}
		}
		return null;
	}

	/*
	 * key, value�� �Է¹޾� ���ο� Entry�� ArrayMap�� �����ϴ� �Լ�
	 * 
	 * @param key, value
	 * 
	 * @return oldValue | null
	 */
	@Override
	public Object put(Object key, Object value) {
		String _tmpKey;
		String _key = String.valueOf(key);
		int compare;

		// ��� entry�� ���鼭
		for (int i = 0; i < this.size; i++) {
			// i��° entry�� key�� ���ٸ� ���ο� value�� �����Ѵ�.
			if (this.entryArray[i].getKey().equals(key)) {
				Object oldValue = this.entryArray[i].getValue();
				this.entryArray[i].setValue(value);
				return oldValue;
			}
		}

		// �迭�� ���� ������ �����ϸ� ũ�⸦ 2��� �ø���.
		if (size == entryArray.length) {
			reSize();
		}

		if (size == 0) {
			this.entryArray[size] = new Entry(key, value);
			this.size++;
		} else {
			// ��ġ�� ���Ѵ�.
			for (int j = 0; j < this.size; j++) {
				_tmpKey = String.valueOf(this.entryArray[j].getKey());
				compare = _key.compareTo(_tmpKey);
				// _key�� _tmpKey���� �տ� ������
				if (compare < 0) {
					System.arraycopy(this.entryArray, j, this.entryArray, j + 1, size - j);
					this.entryArray[j] = new Entry(key, value);
					this.size++;
					break;

				} else if (j == this.size - 1) {
					// �迭�� �������� entry�� �ְ� size�� 1 �ø���.
					this.entryArray[size] = new Entry(key, value);
					this.size++;
					break;
				}
			}
		}

		return null;
	}

	/*
	 * ArrayMap�� size�� ��ȯ�ϴ� �Լ�
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
	 * �ش� key�� Entry�� �����ϴ� �Լ�
	 * 
	 * @param key
	 * 
	 * @return ���� ����, true | false
	 */
	@Override
	public boolean remove(Object key) {
		for (int i = 0; i < this.size; i++) {
			if (this.entryArray[i].getKey().equals(key)) {
				System.arraycopy(entryArray, i + 1, entryArray, i, size - 1);
				this.entryArray[size] = null;
				this.size--;
				return true;
			}
		}
		return false;
	}

	/*
	 * ���� �迭�� �ִ� ũ�⸦ 2�� �÷��ִ� �Լ�
	 * 
	 * @param void
	 * 
	 * @return void
	 */
	public void reSize() {
		Entry[] coppiedArray = new Entry[this.entryArray.length * 2];
		System.arraycopy(entryArray, 0, coppiedArray, 0, this.size);
		this.entryArray = coppiedArray;
	}

	/*
	 * ArrayMap�� ����� ��� Entry�� key, value�� ����ϴ� �Լ�
	 * 
	 * @param void
	 * 
	 * @return void
	 */
	@Override
	public void printArray() {
		for (int i = 0; i < this.size; i++) {
			System.out.println(this.entryArray[i].getKey() + " : " + this.entryArray[i].getValue());
		}
	}

}
