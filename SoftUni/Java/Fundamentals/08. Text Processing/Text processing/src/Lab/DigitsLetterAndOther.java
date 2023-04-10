package Lab;

import java.util.Collections;
import java.util.Scanner;

public class DigitsLetterAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        filterAllCharacters(digits, letters, others, input);
        printAllFiltered(digits, letters, others);
    }

    private static void printAllFiltered(StringBuilder digits, StringBuilder letters, StringBuilder others) {
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }

    private static void filterAllCharacters(StringBuilder digits, StringBuilder letters, StringBuilder others, String input) {
        for (char c :input.toCharArray()){
            if (Character.isDigit(c)){
                digits.append(c);
            } else if (Character.isLetter(c)) {
                letters.append(c);
            } else {
                others.append(c);
            }
        }
    }
}
