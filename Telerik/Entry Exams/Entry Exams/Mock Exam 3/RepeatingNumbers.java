package MockExam3;

import java.util.Scanner;

public class RepeatingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] numbers = new int[10][2];

        for (int i = 1; i <= 10; i++) {
            int index = i - 1;
            numbers[index][0] = i;
        }

        for (int i = 0; i < n; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());

            numbers[currentNumber-1][1]++;
        }

        int biggestNumberCount = Integer.MIN_VALUE;
        int biggestNumber = 0;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i][1] >= biggestNumberCount) {
                biggestNumberCount = numbers[i][1];
                biggestNumber = numbers[i][0];
            }
        }

        System.out.print(biggestNumber);
    }
}
