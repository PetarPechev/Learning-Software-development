package Exercise;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        double result = divideTwoFactorials(firstNum, secondNum);

        System.out.printf("%.2f", result);
    }

    private static double divideTwoFactorials(int firstNum, int secondNum) {
        long firstFactorial = calculateFactorial(firstNum);
        long secondFactorial = calculateFactorial(secondNum);

        return 1.0 * firstFactorial / secondFactorial;
    }

    private static long calculateFactorial(int number) {
        long factorial = 1;

        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
