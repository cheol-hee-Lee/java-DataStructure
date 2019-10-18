package ArrayMap;

public class Entry {
	private Object key;
	private Object value;
	
	/*
	 * Entry�� key, value�� �ʱ�ȭ�ϴ� ������
	 * 
	 * @param key, value
	 */
	public Entry(Object key, Object value) {
		this.key = key;
		this.value = value;
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
	 * 
	 * @param value
	 * @return void
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
