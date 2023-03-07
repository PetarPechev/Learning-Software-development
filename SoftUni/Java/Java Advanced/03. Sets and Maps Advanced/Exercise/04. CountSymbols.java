package Exercise;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> countSymbols = new TreeMap<>();

        String textInput = scanner.nextLine();

        for (int i = 0; i < textInput.length(); i++) {
            char currentChar = textInput.charAt(i);

            countSymbols.putIfAbsent(currentChar, 0);
            countSymbols.put(currentChar, countSymbols.get(currentChar) + 1);
        }

        countSymbols.forEach((symbol, counts) -> System.out.printf("%c: %d time/s%n", symbol, counts));
    }
}
