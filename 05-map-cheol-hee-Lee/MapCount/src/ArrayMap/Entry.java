package ArrayMap;

public class Entry {
	private Object key;
	private Object value;
	
	/*
	 * Entry의 key, value를 초기화하는 생성자
	 * 
	 * @param key, value
	 */
	public Entry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	/*
	 * Entry의 key를 반환하는 함수
	 * 
	 * @param void
	 * @return key
	 */
	public Object getKey() {
		return this.key;
	}
	/*
	 * Entry의 value를 반환하는 함수
	 * 
	 * @param void
	 * @return value
	 */
	public Object getValue() {
		return this.value;
	}
	
	/*
	 * Entry의 key를 설정하는 함수
	 * 
	 * @param key
	 * @return void
	 */
	public void setKey(Object key) {
		this.key = key;
	}
	
	/*
	 * Entry의 value를 설정하는 함수
	 * 
	 * @param value
	 * @return void
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
