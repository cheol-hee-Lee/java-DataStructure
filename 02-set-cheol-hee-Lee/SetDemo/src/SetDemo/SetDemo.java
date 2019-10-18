package SetDemo;

public class SetDemo implements SetDemoInterface{
	private static final int MAX_SIZE = 100;
	private int maxSize;
	private Object[] objects;
	private int size = 0;

	public SetDemo() {
		this.maxSize = MAX_SIZE;
		this.objects = new Object[maxSize];
		this.size = 0;
	}

	@Override
	public boolean add(Object object) {
		if (size == maxSize) {
			return false;
		}
		if (this.contains(object)) {
			return false;
		}
		
		objects[size++] = object;
		return true;
	}

	@Override
	public boolean contains(Object object) {
		for (int k = 0; k < size; k++) {
			if (objects[k] == object) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Object getFirst() {
		return objects[0];
	}

	@Override
	public boolean remove(Object object) {
		if (isEmpty()) {
			return false;
		}

		for (int k = 0; k < size; k++) {
			if (objects[k] == object) {
				System.arraycopy(objects, k + 1, objects, k, size - k - 1);
				objects[size - 1] = null;
				size--;
				break;
			}
		}
		return true;
	}

	@Override
	public Object removeFirst() {
		if (isEmpty()) {
			return null;
		}
		Object returnData = objects[0];
		System.arraycopy(objects, 1, objects, 0, size - 1);
		objects[size - 1] = null;
		size--;
		return returnData;
	}

	@Override
	public void printAll() {
		System.out.print("[");
		for (int i = 0; i < size; i++) {
			if (i == size -1) {
				System.out.print(objects[i]);
			} else {
				System.out.print(objects[i] + ", ");
			}
		}
		System.out.println("]");
	}
}
