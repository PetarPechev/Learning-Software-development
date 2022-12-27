package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timesToRead = Integer.parseInt(scanner.nextLine());
        int[] firstArray = new int[timesToRead];
        int[] secondArray = new int[timesToRead];

        for (int i = 0; i < timesToRead; i++) {
            int[] inputNumbers = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (i % 2 == 0) {
                firstArray[i] = inputNumbers[0];
                secondArray[i] = inputNumbers[1];
            } else {
                firstArray[i] = inputNumbers[1];
                secondArray[i] = inputNumbers[0];
            }
        }

        for (int numberFirstArray : firstArray) {
            System.out.print(numberFirstArray + " ");
        }

        System.out.println();

        for (int numberSecondArray : secondArray) {
            System.out.print(numberSecondArray + " ");
        }
    }
}
