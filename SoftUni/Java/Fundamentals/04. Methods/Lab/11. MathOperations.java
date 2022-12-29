package Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        int secondNum = Integer.parseInt(scanner.nextLine());

        double result = 0.0;

        switch (operator){
            case '+':
                result = sumNumbers(firstNum, secondNum);
                break;
            case '-':
                result = subtractNumbers(firstNum, secondNum);
                break;
            case '*':
                result = multiplyNumbers(firstNum, secondNum);
                break;
                case '/':
                result = divideNumbers(firstNum, secondNum);
                break;
        }

        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println(df.format(result));
    }

    private static double divideNumbers(int firstNum, int secondNum) {
        return 1.0 * firstNum / secondNum;
    }

    private static double multiplyNumbers(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    private static double subtractNumbers(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    private static double sumNumbers(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
}
