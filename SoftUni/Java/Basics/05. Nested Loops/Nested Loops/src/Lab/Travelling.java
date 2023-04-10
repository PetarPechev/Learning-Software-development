package Lab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            double budget = Double.parseDouble(scanner.nextLine());
            double savings = 0;

            while (savings < budget) {
                savings += Double.parseDouble(scanner.nextLine());
            }

            System.out.printf("Going to %s!%n", input);
            input = scanner.nextLine();
        }
    }
}
