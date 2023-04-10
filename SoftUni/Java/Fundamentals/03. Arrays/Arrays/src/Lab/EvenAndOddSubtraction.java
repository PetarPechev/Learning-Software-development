package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (int number : numbersArray) {
            if (number % 2 == 0){
                evenSum += number;
            } else {
                oddSum += number;
            }
        }

        System.out.print(evenSum - oddSum);
    }
}
