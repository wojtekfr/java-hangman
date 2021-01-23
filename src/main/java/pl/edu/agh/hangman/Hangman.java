package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hangman {

	static int counter = 0;
	static boolean isWon = false;

	public static final String[] HANGMANPICS = new String[] {

			"  +---+\n" + "  |   |\n" + "      |\n" + "      |\n" + "      |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + "      |\n" + "      |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + "  |   |\n" + "      |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|   |\n" + "      |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + "      |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + " /    |\n" + "      |\n" + "=========",
			"  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + " / \\  |\n" + "      |\n" + "========" };

	public static void main(String[] args) {
	
		List<String> words = FileWordReader.getListOfWords();
		String word = RandomWord.getRandomWord(words);
		String[] gameWordArray = drawEmptyWord(word);

		System.out.println(word);

		while (counter < 6) {
			System.out.println(HANGMANPICS[counter]);
			printStringArray(gameWordArray);
			System.out.println();
			System.out.println();
			gameWordArray = drawLetter(LetterOperations.getLetter(), gameWordArray, word);
			if (!Arrays.stream(gameWordArray).anyMatch("_"::equals)) {

				printStringArray(gameWordArray);
				System.out.println();
				System.out.println();
				System.out.println("You won !");
				isWon = true;
				break;
			}


		}

		if (!isWon) {
			System.out.println(HANGMANPICS[counter]);
			System.out.println("Game over !");
			System.out.println("The word was : "+ word);
		}
	
	}

	public static String[] drawEmptyWord(String word) {
		int num = word.length();
		String[] emptyWord = new String[word.length()];
		for (int i = 0; i < num; i++) {
			emptyWord[i] = "_";
		}
		return emptyWord;
	}

	public static String[] drawLetter(String letter, String[] wordArray, String word) {
		List<Integer> indexes = LetterOperations.verifyLetter(letter, word);
		if (indexes.isEmpty()) {
			counter++;
			return wordArray;
		} else {
			for (Integer index : indexes) {
				wordArray[index] = letter;

			}
		}
		return wordArray;
	}

	public static void printStringArray(String[] array) {
		for (String letter : array) {
			System.out.print(letter + " ");
		}
	}

}
