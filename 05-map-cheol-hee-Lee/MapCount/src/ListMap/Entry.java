package ListMap;

public class Entry {
	private Object key;
	private Object value;
	public Entry next;
	
	/*
	 * Entry의 key, value, next를 초기화하는 함수
	 * 
	 * @param key, value, next
	 * @return void
	 */
	public Entry(Object key, Object value, Entry next) {
		this.key = key;
		this.value = value;
		this.next = next;
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
	 * Entry의 next를 반환하는 함수
	 * 
	 * @param void
	 * @return next
	 */
	public Object getNext() {
		return this.next;
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
	 * @param value
	 * @return void
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	/*
	 * Entry의 next Entry를 설정하는 함수
	 * @param next Entry
	 * @return void
	 */
	public void setNext(Entry entry) {
		this.next = entry;
	}
}
