package Lab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());

        for (int ch = 1; ch <= numbers; ch++) {
            int sum = 0;
            int currentNumber = ch;

            while (currentNumber > 0) {
                sum += currentNumber % 10;
                currentNumber = currentNumber / 10;
            }
            boolean isSpecial = (sum == 5) || (sum == 7) || (sum == 11);

            System.out.printf("%d -> %s%n", ch,  isSpecial == true ? "True" : "False");
        }
    }
}
