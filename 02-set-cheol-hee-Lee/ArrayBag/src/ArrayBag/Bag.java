package ArrayBag;

public interface Bag {
	public boolean add(Object object);
	public boolean contains(Object object);
	public int size();
	public boolean isEmpty();
	public Object getFirst();
	public boolean remove(Object object);
	public Object removeFirst();
	public void printAll();
}
