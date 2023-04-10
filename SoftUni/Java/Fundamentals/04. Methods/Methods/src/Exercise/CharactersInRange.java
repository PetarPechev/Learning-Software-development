package Exercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        printCharsBetweenGivenTwo(firstChar, secondChar);
    }

    private static void printCharsBetweenGivenTwo(char firstChar, char secondChar) {
        int startChar = Math.min(firstChar, secondChar);
        int endChar = Math.max(firstChar, secondChar);

        for (int i = startChar + 1; i < endChar; i++) {
            System.out.print((char)i + " ");
        }
    }
}
