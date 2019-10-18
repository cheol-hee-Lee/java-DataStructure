package SingleLinkedList;

public class Main {

	public static void main(String[] args) {
		SingleLinkedList sl = new SingleLinkedList();
		
		sl.insert("안녕하세요");
		sl.printList();
		System.out.println("---------------------");
		sl.insert("즐거운");
		sl.printList();

		System.out.println("---------------------");
		sl.insert("자료구조");
		sl.printList();

		System.out.println("---------------------");
		sl.insert("시간입니다.");
		sl.printList();
		
		System.out.println("---------------------");
		sl.delete("안녕하세요");
		sl.printList();
	}
}
