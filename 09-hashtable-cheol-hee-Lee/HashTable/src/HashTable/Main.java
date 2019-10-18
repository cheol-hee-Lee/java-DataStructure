package HashTable;

public class Main {

	public static void main(String[] args) {
		BasicHashTable libraryHashTable = new BasicHashTable(15);
		
		System.out.println("* Put Test ---------------------------");
		libraryHashTable.put("김소월", "진달래꽃");
		libraryHashTable.put("현진건", "운수 좋은 날");
		libraryHashTable.put("김유정", "동백꽃");
		libraryHashTable.put("최인훈", "광장");
		libraryHashTable.printEntries();
		
		System.out.println("\n* Remove Test --------------------------------");
		libraryHashTable.remove("최인훈");
		libraryHashTable.printEntries();
		
		System.out.println("\n* Get Test ---------------------------------------");
		System.out.println("김유정 Value = " +libraryHashTable.get("김유정"));
		
		System.out.println("\n* Collision Test --------------------------------------");
		System.out.println("윤동주 - 별 헤는 밤 추가");
		libraryHashTable.put("윤동주", "별 헤는 밤");
		libraryHashTable.printEntries();
		
		System.out.println("\n김소월 HashIndex : " + libraryHashTable.hash("김소월"));
		System.out.println("현진건 HashIndex : " + libraryHashTable.hash("현진건"));
		System.out.println("윤동주 HashIndex : " + libraryHashTable.hash("윤동주"));
		System.out.println("김유정 HashIndex : " + libraryHashTable.hash("김유정"));
		System.out.println("최인훈 HashIndex : " + libraryHashTable.hash("최인훈"));
		
		
		
	}

}
