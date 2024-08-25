package HangmanGameOOP;

import java.io.FileNotFoundException;
import java.util.*;

public class HangmanGame {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Words words = new Words();
        Set<String> usedLetters = new TreeSet<>();

        while (true) {
            System.out.println("Выберите действие: Новая игра (Н) или Выход (любая клавиша)");
            if (!scanner.nextLine().equals("Н")) {
                break;
            }

            StringBuilder word = new StringBuilder(words.wordList.get(new Random().nextInt(words.wordList.size())));
            String finalWord = String.valueOf(word);
            int counter = 0;

            StringBuilder maskedWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                maskedWord.append("*");
            }
            System.out.println();

            while (maskedWord.indexOf("*") != -1) {
                System.out.println("Угадайте букву");
                Gallows.showGallows(counter);
                for (int i = 0; i < maskedWord.length(); i++) {
                    System.out.print(maskedWord.charAt(i) + " ");
                }
                System.out.println();
                String letter = scanner.nextLine();

                while (letter.length() != 1) {
                    System.out.println("Некорректный ввод, давай еще раз");
                    letter = scanner.nextLine();
                }

                if (word.indexOf(letter) != -1) {
                    usedLetters.add(letter);
                    System.out.println("Использованные буквы: " + usedLetters);
                    System.out.println("Количество ошибок: " + counter);
                    while (word.indexOf(letter) != -1) {
                        maskedWord.replace(word.indexOf(letter), word.indexOf(letter) + 1, letter);
                        word.replace(word.indexOf(letter), word.indexOf(letter) + 1, "*");
                    }

                    if (maskedWord.indexOf("*") == -1) {
                        System.out.println("Поздравляю, вы отгадали слово " + "\"" + maskedWord + "\"!");
                        System.out.println("Всего допущено ошибок: " + counter + "\n");
                        usedLetters.clear();
                        break;
                    }
                } else {
                    if (usedLetters.add(letter)) {
                        counter++;
                        System.out.println("Не угадал, количество ошибок: " + counter);
                        System.out.println("Использованные буквы: " + usedLetters);
                    } else {
                        System.out.println("Такая буква уже была");
                        System.out.println("Использованные буквы: " + usedLetters);
                    }

                    if (counter == 6) {
                        Gallows.showGallows(counter);
                        System.out.println("Ты проиграл, загаданное слово: " + finalWord);
                        usedLetters.clear();
                        break;
                    }
                }
            }
        }
        scanner.close();
    }
}