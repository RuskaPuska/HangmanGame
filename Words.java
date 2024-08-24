package HangmanGameOOP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Words {
    private File file = new File("/Users/ruslan/Desktop/JavaProjects/JavaRoadmapProjects/src/words.txt");
    List<String> wordList = new ArrayList<>(20000);

    public Words() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            if (scanner.nextLine().length() > 3)
                wordList.add(scanner.nextLine().toLowerCase());
        }
    }
}
