package JavaCore3;

import java.util.Scanner;

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int biggestSequence = 1;

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        System.out.println(getBiggestSequence(biggestSequence, numbers));
    }

    private static int getBiggestSequence(int biggestSequence, int[] numbers) {
        int currentSequence = 1;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                currentSequence++;
            } else {
                currentSequence = 1;
            }

            if (currentSequence > biggestSequence) {
                biggestSequence = currentSequence;
            }
        }

        return biggestSequence;
    }
}