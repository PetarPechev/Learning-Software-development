package Lab;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                addNumbers(firstNum, secondNum);
                break;
            case "subtract":
                subtractNumbers(firstNum, secondNum);
                break;
            case "multiply":
                multiplyNumbers(firstNum, secondNum);
                break;
            case "divide":
                divideNumbers(firstNum, secondNum);
                break;
        }
    }

    private static void divideNumbers(int firstNum, int secondNum) {
        System.out.print(firstNum / secondNum);
    }

    private static void multiplyNumbers(int firstNum, int secondNum) {
        System.out.print(firstNum * secondNum);
    }

    private static void subtractNumbers(int firstNum, int secondNum) {
        System.out.print(firstNum - secondNum);
    }

    private static void addNumbers(int firstNum, int secondNum) {
        System.out.print(firstNum + secondNum);
    }
}
