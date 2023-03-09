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
            sum += getSum(firstString, secondString);
        } else {
            sum += getSum(secondString, firstString);
        }

        return sum;
    }

    private static int getSum(String smallerString, String biggerString) {
        int currentSum = 0;

        for (int i = 0; i < smallerString.length(); i++) {
            currentSum += smallerString.charAt(i) * biggerString.charAt(i);
        }

        // add rest values from the bigger String
        for (int i = smallerString.length(); i < biggerString.length(); i++) {
            currentSum += biggerString.charAt(i);
        }
        return currentSum;
    }
}
