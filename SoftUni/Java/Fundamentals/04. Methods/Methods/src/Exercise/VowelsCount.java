package Exercise;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();

        printCountOfVowels(text);
    }

    private static void printCountOfVowels(String text) {
        int sum = 0;

        for (int index = 0; index < text.length(); index++) {
            char currentChar = text.charAt(index);

            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i'
                    || currentChar == 'o' || currentChar == 'u'){
                sum++;
            }
        }

        System.out.print(sum);
    }
}
