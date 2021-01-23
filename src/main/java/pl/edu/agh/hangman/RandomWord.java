package pl.edu.agh.hangman;

import java.util.List;
import java.util.Random;

public class RandomWord {

  public static String getRandomWord(List<String> listOfWords) {
    Random rand = new Random();
    return listOfWords.get(rand.nextInt(listOfWords.size()));
  }

}
