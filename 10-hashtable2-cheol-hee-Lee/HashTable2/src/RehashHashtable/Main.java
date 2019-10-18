package RehashHashtable;

public class Main {

	public static void main(String[] args) {
		RehashHashtable hashTable = new RehashHashtable(10);
		
		System.out.println("* Put Test ---------------------------");
		hashTable.put1("김소월", "진달래꽃");
		hashTable.put1("현진건", "운수 좋은 날");
		hashTable.put1("김유정", "동백꽃");
		hashTable.put1("최인훈", "광장");
		hashTable.put1("박목월", "보랏빛 소묘");

		hashTable.printEntries();
		System.out.println("\n");

		System.out.println("* Remove Test ---------------------------");
		hashTable.remove("최인훈");
		hashTable.printEntries();

		hashTable.remove("김소월");
		hashTable.printEntries();
		System.out.println("\n");

		System.out.println("* Rehash Test ---------------------------");
		hashTable.put1("정지용", "향수");
		hashTable.put1("이육사", "청포도");
		hashTable.put1("박경리", "토지");
		hashTable.put1("양귀자", "원미동 사람들");
		hashTable.put1("이상", "날개");
		hashTable.put1("윤동주", "별헤는 밤");
		hashTable.put1("나도향", "벙어리 삼룡이");
		hashTable.put1("김영랑", "모란이 피기까지는");
		hashTable.put1("김소월", "진달래꽃");
		hashTable.printEntries();
		System.out.println("\n");
	}
}
