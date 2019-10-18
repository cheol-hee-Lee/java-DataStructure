package ArrayMap;

public interface Map {
	public Object get(Object key);
	public Object put(Object key, Object value);
	public int size();
	public boolean remove(Object key);
	public void printArray();
}
