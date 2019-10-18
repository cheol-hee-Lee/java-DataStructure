package ListMap;

public class Entry {
	private Object key;
	private Object value;
	public Entry next;
	
	/*
	 * Entry�� key, value, next�� �ʱ�ȭ�ϴ� �Լ�
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
	 * Entry�� key�� ��ȯ�ϴ� �Լ�
	 * 
	 * @param void
	 * @return key
	 */
	public Object getKey() {
		return this.key;
	}
	
	/*
	 * Entry�� value�� ��ȯ�ϴ� �Լ�
	 * 
	 * @param void
	 * @return value
	 */
	public Object getValue() {
		return this.value;
	}
	
	/*
	 * Entry�� next�� ��ȯ�ϴ� �Լ�
	 * 
	 * @param void
	 * @return next
	 */
	public Object getNext() {
		return this.next;
	}
	
	/*
	 * Entry�� key�� �����ϴ� �Լ�
	 * 
	 * @param key
	 * @return void
	 */
	public void setKey(Object key) {
		this.key = key;
	}
	
	/*
	 * Entry�� value�� �����ϴ� �Լ�
	 * @param value
	 * @return void
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	/*
	 * Entry�� next Entry�� �����ϴ� �Լ�
	 * @param next Entry
	 * @return void
	 */
	public void setNext(Entry entry) {
		this.next = entry;
	}
}
