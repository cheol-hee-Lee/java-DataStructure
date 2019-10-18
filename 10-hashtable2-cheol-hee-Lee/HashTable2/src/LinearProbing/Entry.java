package LinearProbing;

public class Entry {
	private Object key;
	private Object value;
	
	public Entry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public Object getKey() {
		return this.key;
	}
	
	public Object getValue() {
		return this.value;
	}

	/**
	 * Entry가 NIL인지 여부를 출력한다.
	 * 
	 * @return isNIL NIL인지 여부
	 *
	 */
	public boolean isNIL() {
		if (this.key == null && this.value == null) {
			return true;
		}
		return false;
	}
}
