package Search;

public interface SearchInterface {
	public int getIndexBySequentialSearch(char[] dictionary, char searchValue);

	public int getIndexByBinarySearch(char[] dictionary, char searchValue);

}
