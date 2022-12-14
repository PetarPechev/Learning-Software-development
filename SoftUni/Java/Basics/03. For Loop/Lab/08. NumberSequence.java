package Lab;

import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int biggestNum = Integer.MIN_VALUE;
        int smallestNum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());

            if (currentNumber > biggestNum) {
                biggestNum = currentNumber;
            }

            if (currentNumber < smallestNum) {
                smallestNum = currentNumber;
            }
        }

        System.out.printf("Max number: %d\n", biggestNum);
        System.out.printf("Min number: %d", smallestNum);
    }
}