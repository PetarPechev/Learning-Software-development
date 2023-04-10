package Exercise;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            sum += currentNumber;

            if (maxNumber < currentNumber) {
                maxNumber = currentNumber;
            }
        }

        int sumWithoutMaxNumber = sum - maxNumber;

        if (sumWithoutMaxNumber == maxNumber) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", sumWithoutMaxNumber);
        } else {
            int difference = Math.abs(sumWithoutMaxNumber - maxNumber);

            System.out.println("No");
            System.out.printf("Diff = %d", difference);
        }
    }
}
