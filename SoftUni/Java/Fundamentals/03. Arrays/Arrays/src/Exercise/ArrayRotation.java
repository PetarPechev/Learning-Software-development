package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rotations; i++) {
            int firstNumber = numbersArray[0];

            for (int j = 0; j < numbersArray.length - 1; j++) {
                numbersArray[j] = numbersArray[j + 1];
            }

            numbersArray[numbersArray.length - 1] = firstNumber;
        }

        for (int number : numbersArray) {
            System.out.print(number + " ");
        }
    }
}
