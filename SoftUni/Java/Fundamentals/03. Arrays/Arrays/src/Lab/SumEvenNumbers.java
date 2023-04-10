package Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sumEvenNumbers = 0;

        for (int number : numbers) {
            if (number % 2 == 0){
                sumEvenNumbers += number;
            }
        }

        System.out.print(sumEvenNumbers);
    }
}
