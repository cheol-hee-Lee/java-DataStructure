package ArrayMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
/*
 * ������ �о� �ܾ�� ��ġ�� ArrayMap�� �����ϴ� ���α׷�
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
	 * ������ �о� �ܾ�� ��ġ�� ArrayMap�� �����ϴ� �Լ�
	 * 
	 * @param ������ ��ġ�� ArrayMap, ���� ���� ���
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
				// ���ڴ� �ܾ ���Խ�Ű�� �ʴ´�.
				StringTokenizer parser = new StringTokenizer(line, " ,:;=.?!-");
				// �ܾ ���������� �ݺ��Ѵ�.
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					String wordLocation = (String) arrayMap.get(word);

					if (wordLocation == null) {
						arrayMap.put(word, String.valueOf(lineNumber));
					} else {
						// �ܾ ��ġ�� �ε����� �Բ� �����Ѵ�.
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
