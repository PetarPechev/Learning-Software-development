package Exercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String firstString = input[0];
        String secondString = input[1];
        int sum = getSumOfCharacters(firstString, secondString);

        System.out.print(sum);
    }

    private static int getSumOfCharacters(String firstString, String secondString) {
        int sum = 0;

        if (firstString.length() < secondString.length()) {
            sum += addMultipliedValue(firstString, secondString) + addRest(secondString, firstString.length());
        } else {
            sum += addMultipliedValue(secondString, firstString) + addRest(firstString, secondString.length());
        }

        return sum;
    }

    private static int addMultipliedValue(String smallerString, String biggerString) {
        int currentSum = 0;

        for (int i = 0; i < smallerString.length(); i++) {
            currentSum += smallerString.charAt(i) * biggerString.charAt(i);
        }

        return currentSum;
    }

    private static int addRest(String text, int startIndex) {
        int currentSum = 0;

        for (int i = startIndex; i < text.length(); i++) {
            currentSum += text.charAt(i);
        }

        return currentSum;
    }
}
