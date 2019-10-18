package Solution;

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
}
