package RehashHashtable;

public class Entry {
	private Object key;
	private Object value;

	/**
	 * 생성자
	 * 
	 * @param key key
	 * @param value value
	 */
	public Entry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * key를 반환
	 * 
	 * @return key
	 *
	 */
	public Object getKey() {
		return this.key;
	}

	/**
	 * value를 반환
	 * 
	 * @return value
	 *
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * Entry가 NIL 이면 true를 반환한다.
	 * 
	 * @return isNIL true | false
	 *
	 */
	public boolean isNIL() {
		if (this.key == null && this.value == null) {
			return true;
		}
		return false;
	}
}
