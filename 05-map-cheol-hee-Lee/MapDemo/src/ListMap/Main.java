package ListMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * 파일을 읽어 단어와 그 위치를 ListMap에 저장하는 프로그램
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
	 * 파일을 읽어 단어와 단어의 위치를 ListMap에 저장하는 함수
	 * 
	 * @param 저장할 위치인 ListMap, 읽을 파일 경로
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