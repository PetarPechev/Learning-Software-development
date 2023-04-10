package MockExam3;

import java.util.Arrays;
import java.util.Scanner;

public class AloneNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int[] numbersArr = new int[input.length];
        int target = Integer.parseInt(scanner.nextLine());

        for (int j = 0; j < input.length; j++) {
            numbersArr[j] = Integer.parseInt(input[j]);
        }

        for (int i = 1; i < numbersArr.length - 1; i++) {
            boolean isAloneAndTargetNum = numbersArr[i] == target
                    && numbersArr[i] != numbersArr[i + 1]
                    && numbersArr[i] != numbersArr[i - 1];

            if (isAloneAndTargetNum) {
                numbersArr[i] = Math.max(numbersArr[i-1], numbersArr[i+1]);
            }
        }

        System.out.println(Arrays.toString(numbersArr));
    }
}
