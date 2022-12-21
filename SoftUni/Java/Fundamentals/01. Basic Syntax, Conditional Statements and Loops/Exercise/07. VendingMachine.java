package Exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoneys = 0.0;

        while (!input.equals("Start")) {
            double currentMoney = Double.parseDouble(input);

            if (currentMoney == 0.1 || currentMoney == 0.2 || currentMoney == 0.5 ||
                    currentMoney == 1 || currentMoney == 2) {
                totalMoneys+= currentMoney;
            } else  {
                System.out.printf("Cannot accept %.2f%n", currentMoney);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            double moneysNeeded = 0;
            boolean isValidItem = true;

            switch (input) {
                case "Nuts":
                    moneysNeeded = 2.0;
                    break;
                case "Water":
                    moneysNeeded = 0.7;
                    break;
                case "Crisps":
                    moneysNeeded = 1.5;
                    break;
                case "Soda":
                    moneysNeeded = 0.8;
                    break;
                case "Coke":
                    moneysNeeded = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    isValidItem = false;
                    break;
            }

            if (isValidItem) {
                if (totalMoneys - moneysNeeded >= 0){
                    totalMoneys -= moneysNeeded;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", totalMoneys);
    }
}
