package Lab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArray = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondArray = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        int maxLength = Math.max(firstArray.length, secondArray.length);
        boolean areTheyEqual = true;

        for (int i = 0; i < maxLength; i++) {
            if (firstArray[i] != secondArray[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                areTheyEqual = false;
                break;
            }

            sum+= firstArray[i];
        }

        if (areTheyEqual){
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
