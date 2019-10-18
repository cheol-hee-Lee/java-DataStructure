package ArrayMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/*
 * 파일을 읽어 단어와 그 개수를 ArrayMap에 저장하는 프로그램
 *  
 * @author cheol-hee-lee
 * 
 */
public class Main {

	public static void main(String[] args) {
		long[] putTime = new long[3]; // 데이터 삽입 시간
		long[] getTime = new long[3]; // 데이터 탐색 시간
		ArrayList<ArrayMap> arrayMaps = new ArrayList<>();
		String[] dataSize = { "100kb", "500kb", "1000kb" };
		String[] txtPath = new String[3]; // txt file 경로

		for (int i = 0; i < 3; i++) {
			arrayMaps.add(new ArrayMap());
		}

		for (int i = 0; i < 3; i++) {
			txtPath[i] = "https://sample-videos.com/text/Sample-text-file-" + dataSize[i] + ".txt";
			System.out.println("\n* arrayMap_" + dataSize[i] + " -----------------------------");
			putTime[i] = putTime(arrayMaps.get(i), txtPath[i]);
			getTime[i] = getTime(arrayMaps.get(i));
			arrayMaps.get(i).printArray();
			System.out.println("ArrayMap Size : " + arrayMaps.get(i).size());
		}

		System.out.println("\n* ArrayMap's putTime, getTime with 100KB, 500KB, 1000KB txt file\n");
		System.out.printf("\t\t%s\t\t%s\t\t%s\t\n", "100KB", "500KB", "1000KB");
		System.out.printf("%s\t\t", "putTime");

		for (int i = 0; i < 3; i++) {
			System.out.printf("%f\t", putTime[i] * (1.0) / 1000000000);
		}
		System.out.println();
		System.out.printf("%s\t\t", "getTime");
		for (int i = 0; i < 3; i++) {
			System.out.printf("%f\t", getTime[i] * (1.0) / 1000000000);
		}
	}

	/*
	 * txtPath의 데이터를 arrayMap에 저장하는데 걸리는 시간 반환
	 * 
	 * @param arrayMap, txtPath
	 * 
	 * @return endTime - startTime
	 */
	private static long putTime(ArrayMap arrayMap, String txtPath) {
		long startTime = 0, endTime = 0;
		try {
			URL url = new URL(txtPath);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			startTime = System.nanoTime();

			String line = in.readLine();
			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ,:;=.?!-");

				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					arrayMap.put(word, 1);
				}
				line = in.readLine();
			}
			in.close();

			endTime = System.nanoTime();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return endTime - startTime;
	}

	/*
	 * arrayMap.size()번 탐색하는데 걸리는 시간 반환
	 * 
	 * @param arrayMap
	 * 
	 * @return endTime - startTime
	 */
	private static long getTime(ArrayMap arrayMap) {
		long startTime = 0, endTime = 0;
		Entry[] entryArray = arrayMap.getEntryArray();
		Random random = new Random();
		int randomNum;
		Object[] randomKey = new Object[entryArray.length];

		for (int j = 0; j < arrayMap.size(); j++) {
			randomNum = random.nextInt(arrayMap.size() - 1);
			randomKey[j] = entryArray[randomNum].getKey();
		}
		startTime = System.nanoTime();
		for (int k = 0; k < arrayMap.size(); k++) {
			arrayMap.get(randomKey[k]);
		}
		endTime = System.nanoTime();

		return endTime - startTime;
	}
}
