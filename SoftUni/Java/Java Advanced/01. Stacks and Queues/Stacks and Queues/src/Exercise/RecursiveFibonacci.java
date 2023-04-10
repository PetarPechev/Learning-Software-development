package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacciStack = new ArrayDeque<>();
        fibonacciStack.push(0l);
        fibonacciStack.push(1l);

        if (number < 2) {
            System.out.println("1");
        }

        for (int i = 0; i < number; i++) {
            long number1 = fibonacciStack.pop();
            long number2 = fibonacciStack.pop();
            fibonacciStack.push(number1);
            fibonacciStack.push(number1 + number2);
        }

        if (!fibonacciStack.isEmpty()) {
            System.out.println(fibonacciStack.pop());
        }
    }
}
