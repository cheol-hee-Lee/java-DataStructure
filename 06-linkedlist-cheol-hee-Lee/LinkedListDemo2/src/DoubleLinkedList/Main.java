package DoubleLinkedList;

public class Main {

	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();

		dll.addLast("계산이론"); // 마지막에 추가
		System.out.println("dll.addLast(\"계산이론\");");
		System.out.println(dll.toString());
		System.out.println();

		dll.addFirst("자료구조"); // 처음에 추가
		System.out.println("dll.addFirst(\"자료구조\");");
		System.out.println(dll.toString());
		System.out.println();

		dll.addLast("컴퓨터프로그래밍3");
		System.out.println("dll.addLast(\"컴퓨터프로그래밍3\");");
		System.out.println(dll.toString());
		System.out.println();

		dll.addFirst("논리회로및실험");
		System.out.println("dll.addFirst(\"논리회로및실험\");");
		System.out.println(dll.toString());
		System.out.println();

		dll.addLast("확률및통계");
		System.out.println("dll.addLast(\"확률및통계\");");
		System.out.println(dll.toString());
		System.out.println();

		dll.addFirst("법학개론");
		System.out.println("dll.addFirst(\"법학개론\");");
		System.out.println(dll.toString());
		System.out.println();

		dll.removeFirst(); // 삭제
	}
}
