package QuadraticProbing;

import LinearProbing.Entry;

public class QuadraticProbing {
	private Entry[] entries;
	private int size;

	public QuadraticProbing(int capacity) {
		this.entries = new Entry[capacity];
		this.size = 0;
	}

	public Object get(Object key) {
		int hashIndex = hash(key);
		while (key != entries[hashIndex].getKey()) {
			hashIndex = (hashIndex + 1) % entries.length;
		}

		return entries[hashIndex].getValue();
	}

	public int hash(Object key) {
		if (key == null) {
			return -1;
		}
		return (key.hashCode() & 0x7fffffff) % entries.length;
	}

	public boolean put(Object key, Object value) {
		int hashIndex = hash(key);
		for (int i = 0; i < entries.length; i++) {
			hashIndex = (hashIndex + i * i) % entries.length;
			if (entries[hashIndex] == null || entries[hashIndex].isNIL()) {
				entries[hashIndex] = new Entry(key, value);
				size++;
				return true;
			}
		}
		return false;
	}

	public Object remove(Object key) {
		int hashIndex = hash(key);

		for (int i = 0; i < entries.length; i++) {
			hashIndex = (hashIndex + 1) % entries.length;

			Entry entry = entries[hashIndex];

			if (entry == null) {
				return null;
			}

			if (entry.isNIL()) {
				continue;
			}

			if (entry.getKey() == key) {
				Entry removedEntry = entries[hashIndex];
				entries[hashIndex] = new Entry(null, null);
				size--;
				return removedEntry;
			}
		}
		return null;
	}

	public int size() {
		return this.size;
	}

	public void printEntries() {
		for (int i = 0; i < this.entries.length; i++) {
			if (this.entries[i] != null && !this.entries[i].isNIL()) {
				System.out.println("Table[" + i + "] = " + this.entries[i].getKey().toString() + ", "
						+ this.entries[i].getValue().toString());
			}
		}
	}
}
