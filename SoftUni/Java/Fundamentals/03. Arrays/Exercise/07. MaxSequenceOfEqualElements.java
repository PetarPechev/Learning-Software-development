package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxSequence = Integer.MIN_VALUE;
        int counter = 1;
        int elementWithBiggestSequence = 0;

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                counter++;
            } else {
                counter = 1;
            }

            if (counter > maxSequence) {
                maxSequence = counter;
                elementWithBiggestSequence = numbers[i];
            }
        }

        for (int i = 0; i < maxSequence; i++) {
            System.out.print(elementWithBiggestSequence + " ");
        }
    }
}
