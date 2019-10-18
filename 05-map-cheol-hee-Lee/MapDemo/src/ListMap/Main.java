package ListMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * ������ �о� �ܾ�� �� ��ġ�� ListMap�� �����ϴ� ���α׷�
 *  
 * @author cheol-hee-lee
 * 
 */
public class Main {

	public static void main(String[] args) {
		ListMap listMap = new ListMap();
		String filePath = "gettysBurg.txt";

		wordFrequency(listMap, filePath);
	}

	/*
	 * ������ �о� �ܾ�� �ܾ��� ��ġ�� ListMap�� �����ϴ� �Լ�
	 * 
	 * @param ������ ��ġ�� ListMap, ���� ���� ���
	 * 
	 * @return void
	 */
	private static void wordFrequency(ListMap listMap, String filePath) {
		int lineNumber = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String line = in.readLine();

			while (line != null) {
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;=.?!-");

				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					String wordLocation = (String) listMap.get(word);
					if (wordLocation == null) {
						listMap.put(word, String.valueOf(lineNumber));
					} else {
						listMap.put(word, wordLocation + ", " + String.valueOf(lineNumber));
					}
				}
				line = in.readLine();
			}
			in.close();
			listMap.printList();
			System.out.println("ListMap Size : " + listMap.size());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}