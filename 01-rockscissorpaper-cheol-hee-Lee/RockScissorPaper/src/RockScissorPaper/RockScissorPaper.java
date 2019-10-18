package RockScissorPaper;

import java.util.Random;
import java.util.Scanner;

public class RockScissorPaper {

	public RockScissorPaper() {
		Random random = new Random();
		int randomNum;
		String userInput = "";
		String PCInput = "";
		String winner = "";
		Scanner scanner = new Scanner(System.in);
		// user
		System.out.print("무엇을 낼 건가요? : ");
		userInput = scanner.nextLine();
		// computer
		randomNum = random.nextInt(3);
		switch (randomNum) {
		case 0:
			PCInput = "가위";
			break;
		case 1:
			PCInput = "바위";
			break;
		case 2:
			PCInput = "보";
			break;
		default:
			break;
		}
		System.out.println("PC는 " + PCInput + "를 냈습니다!");
		// whoIsWinner
		winner = whoIsWinner(userInput, PCInput);
		if (winner.equals("무승부")) {
			System.out.println("승부는 무승부");
		} else {
			System.out.println("승자는 " + winner);
		}
	}
	public static String whoIsWinner(String userInput, String PCInput) {
		String winner = "";
		if (userInput.equals("가위")) {
			if (PCInput.equals("가위")) {
				winner = "무승부";
			}
			if (PCInput.equals("바위")) {
				winner = "PC";
			}
			if (PCInput.equals("보")) {
				winner = "USER";
			}
		}
		if (userInput.equals("바위")) {
			if (PCInput.equals("가위")) {
				winner = "USER";
			}
			if (PCInput.equals("바위")) {
				winner = "무승부";
			}
			if (PCInput.equals("보")) {
				winner = "PC";
			}
		}
		if (userInput.equals("보")) {
			if (PCInput.equals("가위")) {
				winner = "PC";
			}
			if (PCInput.equals("바위")) {
				winner = "USER";
			}
			if (PCInput.equals("보")) {
				winner = "무승부";
			}
		}
		return winner;
	}
}
