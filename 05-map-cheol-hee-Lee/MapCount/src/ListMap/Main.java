package ListMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/*
 * ������ �о� �ܾ�� �� ������ ListMap�� �����ϴ� ���α׷�
 *  
 * @author cheol-hee-lee
 * 
 */
public class Main {

	public static void main(String[] args) {
		long[] putTime = new long[3]; // ������ ���� �ð�
		long[] getTime = new long[3]; // ������ Ž�� �ð�
		ArrayList<ListMap> listMaps = new ArrayList<>();
		String[] dataSize = { "100kb", "500kb", "1000kb" };
		String[] txtPath = new String[3]; // txt file ���

		for (int i = 0; i < 3; i++) {
			listMaps.add(new ListMap());
		}

		for (int i = 0; i < 3; i++) {
			txtPath[i] = "https://sample-videos.com/text/Sample-text-file-" + dataSize[i] + ".txt";
			System.out.println("\n* listMap_" + dataSize[i] + " -----------------------------");
			putTime[i] = putTime(listMaps.get(i), txtPath[i]);
			getTime[i] = getTime(listMaps.get(i));
			listMaps.get(i).printList();
			System.out.println("ListMap Size : " + listMaps.get(i).size());
		}

		System.out.println("\n * ListMap's putTime, getTime with 100KB, 500KB, 1000KB txt file\n");
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
	 * txtPath�� �����͸� listMap�� �����ϴµ� �ɸ��� �ð� ��ȯ
	 * 
	 * @param listMap, txtPath
	 * 
	 * @return endTime - startTime
	 */
	private static long putTime(ListMap listMap, String txtPath) {
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
					listMap.put(word, 1);
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
	 * listMap.size()�� Ž���ϴµ� �ɸ��� �ð� ��ȯ
	 * 
	 * @param listMap
	 * 
	 * @return endTime - startTime
	 */
	private static long getTime(ListMap listMap) {
		long startTime = 0, endTime = 0;
		Random random = new Random();
		Entry[] entries = listMap.getEntries();
		Object[] randomKey = new Object[entries.length];
		int randomNum;

		for (int i = 0; i < listMap.size(); i++) {
			randomNum = random.nextInt(entries.length - 1);
			randomKey[i] = entries[randomNum].getKey();
		}
		startTime = System.nanoTime();
		for (int i = 0; i < listMap.size(); i++) {
			listMap.get(randomKey[i]);
		}
		endTime = System.nanoTime();

		return endTime - startTime;
	}

}