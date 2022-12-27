package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayWithNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (arrayWithNumbers.length > 1){
            int[] condensed = new int[arrayWithNumbers.length - 1];

            for (int i = 0; i < arrayWithNumbers.length - 1; i++) {
                condensed[i] = arrayWithNumbers[i] + arrayWithNumbers[i + 1];
            }

            arrayWithNumbers = condensed;
        }

        System.out.print(arrayWithNumbers[0]);
    }
}
