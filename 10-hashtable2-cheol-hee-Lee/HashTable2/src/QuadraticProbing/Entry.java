package QuadraticProbing;

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

	public boolean isNIL() {
		if (this.key == null && this.value == null) {
			return true;
		}
		return false;
	}
	
}
