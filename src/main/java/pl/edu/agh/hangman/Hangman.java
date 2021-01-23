package pl.edu.agh.hangman;

import java.util.List;

public class Hangman {
	
	
    public static final String[] HANGMANPICS = new String[]{
    		
    		
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

    public static void main(String[] args) {
        printStringArray(new String[]{"_", "_", "_"});
    }

    public static String w(String word){
        int num = word.length();
        String emptyWord = "";
        for (int i=0; i<num; i++){
            emptyWord += "_";
        }
        return emptyWord;
    }


    public static String[] drawEmptyWord(String word) {
        int num = word.length();
        String[] emptyWord = new String[word.length()];
        for (int i = 0; i < num; i++) {
            emptyWord[i] = "_";
        }
        return emptyWord;
    }

    public String[] drawLetter(String letter, String[] wordArray, String word) {
        List<Integer> indexes = LetterOperations.verifyLetter(letter, word);
        if (indexes.isEmpty()) {
            return wordArray;
        } else {
            for (Integer index: indexes) {
                wordArray[index] = letter;
            }
        }
        return wordArray;
    }

    public static void printStringArray(String[] array) {
        for (String letter: array) {
            System.out.print(letter + " ");
        }
    }

}
