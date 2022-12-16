package Lab;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxNumber = Integer.MIN_VALUE;

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            int currentNumber = Integer.parseInt(input);

            if (currentNumber > maxNumber){
                maxNumber = currentNumber;
            }
        }

        System.out.println(maxNumber);
    }
}
