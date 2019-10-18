package LinearProbing;

public class Main {

	public static void main(String[] args) {
		LinearProbing libraryHashTable = new LinearProbing(15);
		System.out.println("* Put Test ---------------------------");
		libraryHashTable.put("김소월", "진달래꽃");
		libraryHashTable.put("현진건", "운수 좋은 날");
		libraryHashTable.put("김유정", "동백꽃");
		libraryHashTable.put("최인훈", "광장");
		libraryHashTable.put("정지용", "향수");
		libraryHashTable.put("이육사", "청포도");
		libraryHashTable.put("박목월", "보랏빛 소묘");

		libraryHashTable.printEntries();

		System.out.println("\n* Remove Test --------------------------------");
		System.out.println("\n최인훈 삭제\n");
		libraryHashTable.remove("최인훈");
		libraryHashTable.printEntries();

		System.out.println("\n김소월 삭제\n");
		libraryHashTable.remove("김소월");
		libraryHashTable.printEntries();

		System.out.println("\n* Get Test ---------------------------------------");
		System.out.println("김유정 Value = " + libraryHashTable.get("김유정"));

		System.out.println("\n* Collision Test --------------------------------------");
		System.out.println("윤동주 - 별 헤는 밤 추가");
		libraryHashTable.put("윤동주", "별 헤는 밤");
		System.out.println("이육사 - 광야 추가");
		libraryHashTable.put("이육사", "광야");
		libraryHashTable.printEntries();

	}

}
