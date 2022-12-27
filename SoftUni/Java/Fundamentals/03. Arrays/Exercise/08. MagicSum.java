package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayWithNumbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < arrayWithNumbers.length; i++) {
            for (int j = i + 1; j < arrayWithNumbers.length; j++) {
                int sum = arrayWithNumbers[i] + arrayWithNumbers[j];

                if (sum == number) {
                    System.out.println(arrayWithNumbers[i] + " " + arrayWithNumbers[j]);
                }
            }
        }
    }
}
