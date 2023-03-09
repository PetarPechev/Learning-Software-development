package Lab;

import java.util.Collections;
import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            text = text.replaceAll(bannedWord, Collections.nCopies(bannedWord.length(), '*')
                    .toString().replaceAll("[\\[\\], ]", ""));
        }

        System.out.print(text);
    }
}
