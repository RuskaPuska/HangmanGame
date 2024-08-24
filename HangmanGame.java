package HangmanGameOOP;

import java.io.FileNotFoundException;
import java.util.*;

public class HangmanGame {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Words words = new Words();
        Set<String> wrongLetters = new TreeSet<>();

        while (true) {
            System.out.println("Выберите действие: Новая игра (Н) или Выход (для выхода нажмите любую клавишу)");
            if (scanner.nextLine().equals("")) {
                System.out.println("Начинаем");
            } else {
                break;
            }

//            StringBuilder word = new StringBuilder(words.wordList.get(new Random().nextInt(words.wordList.size())));
            StringBuilder word = new StringBuilder(words.wordList.get(5));
            int counter = 0;

            StringBuilder maskedWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                maskedWord.append("*");
                System.out.print(maskedWord.charAt(i) + " ");
            }
            System.out.println();

            while (maskedWord.indexOf("*") != -1) {
                System.out.println("Угадайте букву");
                String letter = scanner.nextLine();

                while (letter.length() != 1) {
                    System.out.println("Не вводи больше одной буквы, давай еще раз");
                    letter = scanner.nextLine();
                }


                if (word.indexOf(letter) != -1) {
                    while (word.indexOf(letter) != -1) {
                        maskedWord.replace(word.indexOf(letter), word.indexOf(letter) + 1, letter);
                        word.replace(word.indexOf(letter), word.indexOf(letter) + 1, "*");
                    }

                    for (int i = 0; i < maskedWord.length(); i++) {
                        System.out.print(maskedWord.charAt(i) + " ");
                    }
                    System.out.println();

                    if (maskedWord.indexOf("*") == -1) {
                        System.out.println("Поздравляю, вы отгадали слово!");
                        wrongLetters.clear();
                        System.out.println("Всего допущено ошибок: " + counter + "\n");
                        break;
                    }
                } else {
                    if (wrongLetters.add(letter)) {
                        counter++;
                        wrongLetters.add(letter);
                        System.out.println("Использованные буквы: " + wrongLetters);
                        System.out.println("Не угадал, количество ошибок: " + counter);
                    } else {
                        System.out.println("Такая буква уже была");
                        System.out.println("Использованные буквы: " + wrongLetters);
                    }

                    for (int i = 0; i < maskedWord.length(); i++) {
                        System.out.print(maskedWord.charAt(i) + " ");
                    }
                    System.out.println();

                    if (counter == 6) {
                        System.out.println("Ты проиграл, лох");
                        wrongLetters.clear();
                        break;
                    }
                }
            }
        }
        scanner.close();
    }
}