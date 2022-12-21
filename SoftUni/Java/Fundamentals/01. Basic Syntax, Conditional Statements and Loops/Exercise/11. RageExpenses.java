package Exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGameCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        double totalExpenses = 0.0;

        if (lostGameCount / 12 >= 1) {
            totalExpenses += displayPrice * (lostGameCount / 12);
        }
        if (lostGameCount / 6 >= 1) {
            totalExpenses += keyboardPrice * (lostGameCount / 6);
        }
        if (lostGameCount / 3 >= 1) {
            totalExpenses += mousePrice * (lostGameCount / 3);
        }
        if (lostGameCount / 2 >= 1) {
            totalExpenses += headsetPrice * (lostGameCount / 2);
        }

        System.out.printf("Rage expenses: %.2f lv.", totalExpenses);
    }
}
