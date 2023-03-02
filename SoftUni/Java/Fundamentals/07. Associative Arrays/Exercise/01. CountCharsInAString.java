package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textInput = scanner.nextLine().replaceAll("\\s+", "");
        Map<Character, Integer> charsCount = new LinkedHashMap<>();

        for (int index = 0; index < textInput.length(); index++) {
            char currentChar = textInput.charAt(index);
            charsCount.putIfAbsent(currentChar, 0);
            charsCount.put(currentChar, charsCount.get(currentChar) + 1);
        }

        charsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
