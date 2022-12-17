package Lab;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int lastNumber = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean isMagic = false;

        for (int x = firstNumber; x <= lastNumber; x++) {
            for (int y = firstNumber; y <= lastNumber; y++) {
                int sum = x + y;
                counter++;

                if (sum == magicNumber) {
                    isMagic = true;
                    System.out.printf("Combination N:%d ", counter);
                    System.out.printf("(%d + %d = %d)", x, y, sum);
                    return;
                }
            }
        }

        if (!isMagic){
            System.out.printf("%d combinations - neither equals %d", counter, magicNumber);
        }
    }
}
