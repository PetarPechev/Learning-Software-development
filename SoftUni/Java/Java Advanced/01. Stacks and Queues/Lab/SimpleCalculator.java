package Lab;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbersAndOperators = new ArrayDeque<>();
        Collections.addAll(numbersAndOperators, input);

        while(numbersAndOperators.size() > 1) {
            int firstNumber = Integer.parseInt(numbersAndOperators.pop());
            String operator = numbersAndOperators.pop();
            int secondNumber = Integer.parseInt(numbersAndOperators.pop());

            if (operator.equals("+")) {
                numbersAndOperators.push(String.valueOf(firstNumber + secondNumber));
            } else if (operator.equals("-")) {
                numbersAndOperators.push(String.valueOf(firstNumber - secondNumber));
            }
        }

        System.out.println(numbersAndOperators.pop());
    }
}
