package ArrayBag;

public class Main {

	public static void main(String[] args) {
		ArrayBag arrayBag = new ArrayBag();
		
		System.out.println("---------------------------------");
		System.out.println("* Hi 원소 추가");
		System.out.println("---------------------------------");
		arrayBag.add("Hi");
		arrayBag.printAll();
		
		System.out.println("---------------------------------");
		System.out.println("* Hi 원소 삭제");
		System.out.println("---------------------------------");
		arrayBag.remove("Hi");
		arrayBag.printAll();
		
		System.out.println("---------------------------------");
		System.out.println("* ArrayBag이 비었나?");
		System.out.println("---------------------------------");
		System.out.println(arrayBag.isEmpty());
		
		System.out.println("---------------------------------");
		System.out.println("* 원소 추가");
		System.out.println("---------------------------------");
		arrayBag.add("이철희");
		arrayBag.add("이철희");
		arrayBag.add("201802141");
		arrayBag.printAll();
		
		System.out.println("---------------------------------");
		System.out.println("* 원소 개수 출력");
		System.out.println("---------------------------------");
		System.out.println(arrayBag.size());
		
		System.out.println("---------------------------------");
		System.out.println("* 학번이 Bag에 존재하는가?");
		System.out.println("---------------------------------");
		System.out.println(arrayBag.contains("201802141"));
		
		System.out.println("---------------------------------");
		System.out.println("* 첫번째 원소 삭제");
		System.out.println("---------------------------------");
		arrayBag.removeFirst();
		arrayBag.printAll();
		
	}

}
