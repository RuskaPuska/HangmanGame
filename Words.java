package HangmanGameOOP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Words {
    private File file = new File("words.txt");
    List<String> wordList = new ArrayList<>(20000);

    public Words() throws FileNotFoundException {
        Scanner scanner = new Scanner(file.getAbsolutePath());
        String word;

        while (scanner.hasNext()) {
            word = scanner.nextLine().toLowerCase();
            if (word.matches("[а-яёА-ЯЁ]{4,}")) {
                wordList.add(word);
            }
        }
        scanner.close();
    }

    public String toString() {
        return wordList.toString();
    }
}
