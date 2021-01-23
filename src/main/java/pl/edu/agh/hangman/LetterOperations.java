package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class LetterOperations {
	Scanner scanner = new Scanner(System.in);
	String letter;

	public String getLetter() {
		do {
			System.out.print("Podaj literę: ");
			letter = scanner.next();
			if (letter.length() != 1) {
				System.out.println("Podaj tylko jedną literę");
			}
		} while (letter.length() == 1);
		return letter;
	}

	public static ArrayList<Integer> verifyLetter(String letter, String word) {
		ArrayList<Integer> listOfIndexes = new ArrayList<Integer>();

		for (int index = 1; index <= word.length(); index++) {
			if (word.charAt(index) == letter.charAt(0)) {
				listOfIndexes.add(index);
			}
		}

		return listOfIndexes;
	}
	

}
