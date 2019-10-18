package ArrayMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
/*
 * 파일을 읽어 단어와 위치를 ArrayMap에 저장하는 프로그램
 *  
 * @author cheol-hee-lee
 * 
 */
public class Main {

	public static void main(String[] args) {
		ArrayMap arrayMap = new ArrayMap();
		String filePath = "gettysBurg.txt";
		wordFrequency(arrayMap, filePath);
	}
	/*
	 * 파일을 읽어 단어와 위치를 ArrayMap에 저장하는 함수
	 * 
	 * @param 저장할 위치인 ArrayMap, 읽을 파일 경로
	 * 
	 * @return void
	 */
	private static void wordFrequency(ArrayMap arrayMap, String filePath) {
		int lineNumber = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String line = in.readLine();

			while (line != null) {
				++lineNumber;
				// 문자는 단어에 포함시키지 않는다.
				StringTokenizer parser = new StringTokenizer(line, " ,:;=.?!-");
				// 단어가 남아있으면 반복한다.
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					String wordLocation = (String) arrayMap.get(word);

					if (wordLocation == null) {
						arrayMap.put(word, String.valueOf(lineNumber));
					} else {
						// 단어가 위치한 인덱스를 함께 저장한다.
						arrayMap.put(word, wordLocation + ", " +String.valueOf(lineNumber));
					}
				}
				line = in.readLine();
			}
			in.close();
			arrayMap.printArray();
			System.out.println("ArrayMap Size : " + arrayMap.size());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
