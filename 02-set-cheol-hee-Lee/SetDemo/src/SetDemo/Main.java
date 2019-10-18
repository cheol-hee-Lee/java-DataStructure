package SetDemo;

public class Main {

	public static void main(String[] args) {
		SetDemo set = new SetDemo();
		
		// add
		printProgress("* 김영삼 추가");
		set.add("김영삼");
		set.printAll();
		System.out.println("set.size() : " + set.size());
		System.out.println();
		
		// remove
		printProgress("* 김영삼 삭제");
		set.remove("김영삼");
		set.printAll();
		System.out.println("set.size() : " + set.size());
		System.out.println();
		
		// isEmpty
		printProgress("* set이 비었나?");
		set.printAll();
		System.out.println(set.isEmpty());
		System.out.println();
		
		// add elements
		printProgress("* 문재인, 박근혜, 이명박, 노무현, 김대중, 김영삼, 노태우, 전두환 추가");
		set.add("문재인");
		set.add("박근혜");
		set.add("이명박");
		set.add("노무현");
		set.add("김대중");
		set.add("김영삼");
		set.add("노태우");
		set.add("전두환");
		set.printAll();
		System.out.println("set.size() : " + set.size());
		System.out.println();
		
		// examine the duplication of elements in the collection
		printProgress("* 문재인 추가");
		set.add("문재인");
		set.printAll();
		System.out.println("set.size() : " + set.size());
		System.out.println();
		
		// remove
		printProgress("* 박근혜 삭제");
		set.remove("박근혜");
		set.printAll();
		System.out.println("set.size() : " + set.size());
		System.out.println();
		
		// contains
		printProgress("* 김대중이 set에 존재하는가?");
		System.out.println(set.contains("김대중"));
		System.out.println();
		
		// removeFirst
		printProgress("* 첫번째 원소 삭제");
		set.removeFirst();
		set.printAll();
		System.out.println("set.size() : " + set.size());
		System.out.println();
		
	}
	
	public static void printProgress(String str) {
		System.out.println("------------------------------------------------------------------");
		System.out.println(str);
		System.out.println("------------------------------------------------------------------");
		
	}
}
