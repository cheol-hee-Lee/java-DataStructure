package ArrayMap;

public class ArrayMap implements Map {
	private static final int INITIAL_SIZE = 100;
	private Entry[] entryArray;
	private int size;

	/*
	 * Entry 배열, ArrayMap의 size를 초기화하는 생성자
	 */
	public ArrayMap() {
		this.entryArray = new Entry[INITIAL_SIZE];
		this.size = 0;
	}

	/*
	 * key로 value를 얻어내는 함수
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
	 * key, value를 입력받아 새로운 Entry를 ArrayMap에 저장하는 함수
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

		// 모든 entry를 돌면서
		for (int i = 0; i < this.size; i++) {
			// i번째 entry가 key와 같다면 새로운 value로 수정한다.
			if (this.entryArray[i].getKey().equals(key)) {
				Object oldValue = this.entryArray[i].getValue();
				this.entryArray[i].setValue(value);
				return oldValue;
			}
		}

		// 배열에 넣을 공간이 부족하면 크기를 2배로 늘린다.
		if (size == entryArray.length) {
			reSize();
		}

		if (size == 0) {
			this.entryArray[size] = new Entry(key, value);
			this.size++;
		} else {
			// 위치를 정한다.
			for (int j = 0; j < this.size; j++) {
				_tmpKey = String.valueOf(this.entryArray[j].getKey());
				compare = _key.compareTo(_tmpKey);
				// _key가 _tmpKey보다 앞에 있으면
				if (compare < 0) {
					System.arraycopy(this.entryArray, j, this.entryArray, j + 1, size - j);
					this.entryArray[j] = new Entry(key, value);
					this.size++;
					break;

				} else if (j == this.size - 1) {
					// 배열의 마지막에 entry를 넣고 size를 1 늘린다.
					this.entryArray[size] = new Entry(key, value);
					this.size++;
					break;
				}
			}
		}

		return null;
	}

	/*
	 * ArrayMap의 size를 반환하는 함수
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
	 * 해당 key의 Entry를 삭제하는 함수
	 * 
	 * @param key
	 * 
	 * @return 삭제 여부, true | false
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
	 * 내부 배열의 최대 크기를 2배 늘려주는 함수
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
	 * ArrayMap에 저장된 모든 Entry의 key, value를 출력하는 함수
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
