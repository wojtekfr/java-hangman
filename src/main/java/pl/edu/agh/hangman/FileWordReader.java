package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWordReader {

  public static List<String> getListOfWords() {
    File fileToRead = new File("src/main/resources/slowa.txt");
    List<String> listOfWords = new ArrayList<>();
    try {
      Scanner myReader = new Scanner(fileToRead);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        listOfWords.add(data.toUpperCase());
      }
    } catch (
        FileNotFoundException e) {
      e.printStackTrace();
    }
    return listOfWords;
  }

}
