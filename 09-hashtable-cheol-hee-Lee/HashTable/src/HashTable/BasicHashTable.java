package HashTable;

public class BasicHashTable {
	private Entry[] entries;
	private int size;

	public BasicHashTable(int capacity) {
		this.entries = new Entry[capacity];
		this.size = 0;
	}

	public Object get(Object key) {
		return entries[hash(key)].getValue();
	}

	public int hash(Object key) {
		if (key == null) {
			return -1;
		}
		return (key.hashCode() & 0x7fffffff) % entries.length;
	}

	public Object put(Object key, Object value) {
		entries[hash(key)] = new Entry(key, value);
		++size;
		return null;
	}

	public Object remove(Object key) {
		int hashIndex = hash(key);
		Object value = entries[hashIndex].getValue();
		entries[hashIndex] = null;
		--size;
		return value;
	}

	public int size() {
		return this.size;
	}

	public void printEntries() {
		for (int i = 0; i < this.entries.length; i++) {
			if (this.entries[i] != null) {
				System.out.println("Table[" + i + "] = " + this.entries[i].getKey().toString() + ", "
						+ this.entries[i].getValue().toString());
			}
		}
	}
}
