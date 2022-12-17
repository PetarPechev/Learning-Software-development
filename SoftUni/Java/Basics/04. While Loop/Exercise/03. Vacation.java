package Exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededMoneyForTrip = Double.parseDouble(scanner.nextLine());
        double ownedMoney = Double.parseDouble(scanner.nextLine());
        int daysCounter = 0;
        int spendingCounter = 0;

        while (ownedMoney < neededMoneyForTrip && spendingCounter < 5) {
            String command = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());
            daysCounter++;

            if (command.equals("save")) {
                ownedMoney += money;
                spendingCounter = 0;
            } else if (command.equals("spend")) {
                ownedMoney -= money;
                spendingCounter++;

                if (ownedMoney < 0){
                    ownedMoney = 0;
                }
            }
        }

        if (spendingCounter == 5) {
            System.out.println("You can't save the money.");
            System.out.printf("%d", daysCounter);
        }
        if (ownedMoney >= neededMoneyForTrip) {
            System.out.printf("You saved the money for %d days.", daysCounter);
        }
    }
}
