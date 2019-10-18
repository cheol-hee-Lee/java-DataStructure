package QuadraticProbing;


public class Main {

	public static void main(String[] args) {
		QuadraticProbing libraryHashTable = new QuadraticProbing(15);

		System.out.println("* Put Test ---------------------------");
		libraryHashTable.put("김소월", "진달래꽃1");
		libraryHashTable.put("김소월", "진달래꽃2");
		libraryHashTable.put("김소월", "진달래꽃3");
		libraryHashTable.put("김소월", "진달래꽃4");
		libraryHashTable.put("김소월", "진달래꽃5");
		libraryHashTable.put("김소월", "진달래꽃6");
		libraryHashTable.put("김소월", "진달래꽃7");
		libraryHashTable.put("김소월", "진달래꽃8");
		libraryHashTable.put("김소월", "진달래꽃9");
		libraryHashTable.put("김소월", "진달래꽃10");
		libraryHashTable.put("김소월", "진달래꽃11");
		libraryHashTable.put("김소월", "진달래꽃12");
		libraryHashTable.put("김소월", "진달래꽃13");
		libraryHashTable.put("김소월", "진달래꽃14");

		libraryHashTable.printEntries();
	}

}
