package Lab;

import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number % 2 != 0) {
                System.out.println("Please write an even number.");
            } else {
                System.out.printf("The number is: %d", Math.abs(number));
                break;
            }
        }
    }
}
